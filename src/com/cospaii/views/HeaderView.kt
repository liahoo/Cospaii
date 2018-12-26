package com.cospaii.views

import com.cospaii.controllers.Menu.categories
import com.fascode.templates.R
import com.fascode.templates.*
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*


class HeaderView: Template<HtmlBlockTag> {
    var currentLanguage: String = "English"
    var currentCurrency: String = "USD"

    override fun HtmlBlockTag.apply() {
        header {
            id = "header-area"
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
            div("navigation-area") {
                id = "fixheader"
                div("container") {
                    div("row") {
                        insert(CategoriesTemplate()) {
                            catMenu {
                                categories.forEach { cat ->
                                    insert(CategoryItemGroupTemplate()) {
                                        category {
                                            href = cat.href
                                            img(alt = "Compute", src = "assets/img/icons/desktop.png")
                                            text(cat.name)
                                        }
                                        cat.children?.forEach { mid ->
                                            subCategory {
                                                parent {
                                                    href = mid.href
                                                    text(mid.name)
                                                }
                                                mid.children?.forEach { low ->
                                                    item {
                                                        href = low.href
                                                        text(low.name)
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
    }
}