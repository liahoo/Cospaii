package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class NavItemSingleTemplate: Template<UL> {
    val parent =  Placeholder<A>()
    val item = PlaceholderList<UL, A>()
    val items = PlaceholderList<LI, ExpandableItemTemplate>()
    override fun UL.apply() {
        li("dropdown-show") {
            a(href = "#", classes = "arrow-toggle") {
                insert(parent)
            }
            ul(classes="dropdown-nav sub-dropdown") {
                each(item) {
                    li {
                        a {
                            insert(it)
                        }
                    }
                }
            }
        }
    }
}