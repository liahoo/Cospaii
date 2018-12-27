package com.cospaii.views

import com.cospaii.controllers.Menu
import com.cospaii.models.MenuItem
import com.fascode.templates.*
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class HeaderNavigationArea: Template<FlowContent> {
    var categories : Array<MenuItem> = Menu.categories
    var navItems: Array<MenuItem> = Menu.mainMenu
    override fun FlowContent.apply() {
        div("navigation-area") {
            id = "fixheader"
            div("container") {
                div("row") {
                    div("col-10 col-lg-3") {
                        div(classes="categories-list-wrap") {
                            button(classes = "btn btn-category d-none d-lg-inline-block") {
                                i("fa fa-bars")
                                text(R.getString("Categories"))
                            }
                            ul("category-list-menu") {
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
                    div("col-2 col-lg-9 d-none d-lg-block") {
                        div("main-menu-wrap") {
                            nav("mainmenu") {
                                ul("main-navbar clearfix") {
                                    navItems.forEach { topItem -> // [Home, New, Hot, Sales]
                                        if (!topItem.hasChildren) {
                                            li {
                                                a {
                                                    href = topItem.href
                                                    text(topItem.name)
                                                }
                                            }
                                        } else { // If Nav item has children
                                            li("dropdown-show") {
                                                /* Show [New, Hot, Sales] */
                                                a(href = topItem.href, classes = "arrow-toggle") {
                                                    +(topItem.name)
                                                }
                                                /* Show [Electronics, Clothes] */
                                                insert(NavItemGroupTemplate()) {
                                                    // Loop [Electronics, Clothes]
                                                    topItem.children?.forEach { midItem ->
                                                        groupItem {
                                                            parent {
                                                                /* Show [Phone, Tablet], [Men's, Ladies'] */
                                                                href = midItem.href
                                                                +(midItem.name)
                                                            }
                                                            midItem.children?.forEach { lowItem ->
                                                                /* Show [Phone, Tablet], [Men's, Ladies'] */
                                                                item {
                                                                    href = lowItem.href
                                                                    +(lowItem.name)
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
        }
    }
}