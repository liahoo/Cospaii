package com.cospaii.views

import com.fascode.templates.R
import com.fascode.templates.SwitcherTemplate
import com.fascode.templates.TopBarTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.li

class HeaderTopArea: Template<FlowContent> {
    var currentLanguage: String = "English"
    var currentCurrency: String = "USD"
    override fun FlowContent.apply() {
        div("preheader-area") {
            insert(TopBarTemplate()) {
                email = "support@cospaii.com"
                phone = "(81)90-6659-8766"
                menu {
                    li {
                        a(href = "/MyAccount") { +R.getString("My Account") }
                    }
                    li {
                        a(href = "/WishList") { +R.getString("Wish List") }
                    }
                    li {
                        a(href = "/Login") { +R.getString("Login") }
                    }
                    insert(SwitcherTemplate()) {
                        switcherSelected {
                            text(currentLanguage)
                        }
                        arrayOf("English", "日本語", "中文").forEach { lang ->
                            switcherItem {
                                a {
                                    +lang
                                }
                            }
                        }
                    }
                    insert(SwitcherTemplate()) {
                        switcherSelected {
                            text(currentCurrency)
                        }
                        arrayOf("USD", "JPY", "RMB").forEach { currency ->
                            switcherItem {
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
}