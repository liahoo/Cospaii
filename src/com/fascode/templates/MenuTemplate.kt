package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class MenuTemplate(
    val langSelected : String = "English",
    val langs: Array<String> = arrayOf("English", "日本語", "中文"),
    val currencySelected: String = "USD",
    val currencies: Array<String> = arrayOf("USD", "JPY", "RMB")
): Template<FlowContent> {
    override fun FlowContent.apply() {
        div("site-setting-menu") {
            ul("nav justify-content-center justify-content-md-end") {
                li {
                    a(href = "MyAccount.html") { +"My Account" }
                }
                li {
                    a(href = "Wishist.html") { +"WishList" }
                }
                li {
                    a(href = "Login.html") { +"Login" }
                }
                insert(SwitcherTemplate()) {
                    selectedItem {
                        +langSelected
                    }
                    langs.forEach { lang ->
                        item {
                            a {
                                +lang
                            }
                        }
                    }
                }
                insert(SwitcherTemplate()) {
                    selectedItem {
                        +currencySelected
                    }
                    currencies.forEach { currency ->
                        item {
                            a {
                                +currency
                            }
                        }
                    }
                }
            }
        }
    }
}