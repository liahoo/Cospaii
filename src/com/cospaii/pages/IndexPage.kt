package com.cospaii.pages

import com.cospaii.models.CartItem
import com.cospaii.views.HeaderView
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
            insert(HeaderView()) {
                currentLanguage = "日本語"
                currentCurrency = "JPY"
                searchingText = "Huawei"
                cartItems = listOf(
                    CartItem("item 1", "$100", 2, "assets/img/product-1.jpg", "/detail/1"),
                    CartItem("item 2", "$100", 1, "assets/img/product-2.jpg", "/detail/2"),
                    CartItem("item 3", "$100", 3, "assets/img/product-3.jpg", "/detail/3")
                )
            }
        }
    }
}