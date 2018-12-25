package com.cospaii.views

import com.cospaii.controllers.MenuController.categories
import com.fascode.templates.R
import com.cospaii.models.CartItem
import com.fascode.templates.*
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*


class HeaderView: Template<HtmlBlockTag> {
    var currentLanguage: String = "English"
    var currentCurrency: String = "USD"
    var cartItems: List<CartItem>? = null
    var searchingText: String? = null

    override fun HtmlBlockTag.apply() {
        header {
            id = "header-area"
            div("preheader-area") {
                insert(TopBarTemplate()) {
                    email = "support@cospaii.com"
                    phone = "(81)90-6659-8766"
                    menu {
                        li {
                            a(href = "/MyAccount") { +R.getString("my_account") }
                        }
                        li {
                            a(href = "/WishList") { +R.getString("wish_list") }
                        }
                        li {
                            a(href = "/Login") { +R.getString("login") }
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
            div("navigation-area") {
                id = "fixheader"
//                insert(SlickNavTemplate()) {
//                    slick_nav_menu {
//                        insert(SlickNavCollapseItemTemplate()) {
//                            parent {
//                                +(NavBar.clothes.first)
//                            }
//                            NavBar.clothesChildren.forEach { child ->
//                                subItem {
//                                    attributes.put("href", child.second)
//                                    text(child.first)
//                                }
//                            }
//                        }
//                        insert(SlickNavCollapseItemTemplate()) {
//                            parent {
//                                attributes.put("href", NavBar.electronics.second)
//                                text(NavBar.electronics.first)
//                            }
//                            NavBar.electronicsChildren.forEach { child ->
//                                subItem {
//                                    attributes.put("href", child.second)
//                                    text(child.first)
//                                }
//                            }
//                        }
//                        insert(SlickNavSingleItemTemplate()) {
//                            item {
//                                attributes.put("href", NavBar.wallets.second)
//                                text(NavBar.wallets.first)
//                            }
//                        }
//                    }
//                }

                div("container") {
                    div("row") {
                        insert(CategoryListTemplate()) {
                            cat_menu {
                                categories.forEach { cat ->
                                    insert(CategoryItemTemplate()) {
                                        category {
                                            href = cat.href
                                            img(alt = "Compute", src = "assets/img/icons/desktop.png")
                                            text(cat.name)
                                        }
                                        cat.subCategories?.forEach { mid ->
                                            subCategory {
                                                mid_item {
                                                    href = mid.href
                                                    text(mid.name)
                                                }
                                                mid.subCategories?.forEach { low ->
                                                    low_item {
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
                        div("col-2 col-lg-9 d-none d-lg-block") {
                            insert(NavMenuTemplate()) {
                                main_menu {
                                    li {
                                        a {
                                            +"main item 1"
                                        }
                                    }
                                    li {
                                        a {
                                            +"main item 2"
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