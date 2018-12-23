package com.fascode.templates

import com.fascode.Models.CartItem
import io.ktor.html.*
import kotlinx.html.*

open class HeaderTemplate(val cartItems: Array<CartItem> = arrayOf(
    CartItem("item 1", "$100", 2, "assets/img/product-1.jpg", "/detail/1"),
    CartItem("item 2", "$100", 1, "assets/img/product-2.jpg", "/detail/2"),
    CartItem("item 3", "$100", 3, "assets/img/product-3.jpg", "/detail/3")
)): Template<HtmlBlockTag> {

//    val miniCartItems = TemplatePlaceholder<MiniCartTemplate>()
    override fun HtmlBlockTag.apply() {
        header {
            id = "header-area"
            div("preheader-area") {
                insert(TopBarTemplate()) {}
            }
            div("header-middle-area") {
                insert(SearchRowTemplate()) {
                    count {
                        text(cartItems.size)
                    }
                    miniCartBody {
                        cartItems.forEach {cartItem ->
                            insert(MiniCartTemplate()){
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