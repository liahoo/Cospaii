package com.cospaii.pages

import com.cospaii.views.HeaderMiddleArea
import com.cospaii.models.CartItem
import com.cospaii.views.HeaderTopArea
import com.cospaii.views.HeaderNavigationArea
import com.fascode.templates.HeadTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class IndexPage: Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +"Home" }
            insert(HeadTemplate()) {}
        }
        body {
            header {
                id = "header-area"
                insert(HeaderTopArea()) {
                }
                insert(HeaderMiddleArea()) {
                    cartItems = listOf(
                        CartItem("items 1", "$100", 2, "assets/img/product-1.jpg", "/detail/1"),
                        CartItem("items 2", "$100", 1, "assets/img/product-2.jpg", "/detail/2"),
                        CartItem("items 3", "$100", 3, "assets/img/product-3.jpg", "/detail/3")
                    )
                }
                insert(HeaderNavigationArea()) {
                }
            }
        }
    }
}