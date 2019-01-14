package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class NavItemGroupTemplate: Template<LI> {
    val parent = Placeholder<A>()
    val groupItem = PlaceholderList<UL, ExpandableItemTemplate>()
    override fun LI.apply() {
        if (!groupItem.isEmpty()) {
            ul(classes = "mega-menu-wrap dropdown-nav") {
                each(groupItem) {
                    insert(ExpandableItemTemplate()) {
                        insert(it)
                    }
                }
            }
        } else {
            ul("dropdown-nav sub-dropdown") {
                li {
                    a {
                        insert(parent)
                    }
                }
            }
        }
    }
}