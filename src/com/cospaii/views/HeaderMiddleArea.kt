package com.cospaii.views

import com.cospaii.models.CartItem
import com.fascode.templates.MiniCartTemplate
import com.fascode.templates.SearchRowTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.img

class HeaderMiddleArea: Template<FlowContent> {
    var cartItems: List<CartItem>? = null
    var searchingText: String? = null
    override fun FlowContent.apply() {
        div("header-middle-area") {
            insert(SearchRowTemplate()) {
                textInput = searchingText
                count {
                    cartItems?.size?.let { num ->
                        if (num > 0) text(num)
                    }
                }
                miniCartBody {
                    cartItems?.let { list ->
                        if (list.isNotEmpty()) {
                            list.forEach { cartItem ->
                                insert(MiniCartTemplate()) {
                                    itemThumb {
                                        href = cartItem.hrefDetail
                                        img(src = cartItem.imgSrc, alt = cartItem.title)
                                    }
                                    itemTitle {
                                        href = cartItem.hrefDetail
                                        text(cartItem.title)
                                    }
                                    itemPrice {
                                        text(cartItem.price)
                                    }
                                    itemQuantity {
                                        text(cartItem.quantity)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}