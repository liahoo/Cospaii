package com.cospaii.area

import com.cospaii.models.CartItem
import com.cospaii.templates.LogoTemplate
import com.cospaii.templates.MiniCartTemplate
import com.cospaii.templates.SearchRowTemplate
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
            div("container") {
                div("row") {
                    insert(LogoTemplate()){}
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
    }
}