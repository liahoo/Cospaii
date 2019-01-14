package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class ExpandableItemTemplate: Template<UL> {
    val parent = Placeholder<A>()
    val item = PlaceholderList<UL, A>()
    override fun UL.apply() {
        li(classes = "mega-menu-item") {
            a(classes = "mega-item-title") {
                insert(parent)
            }
            if (!item.isEmpty()) {
                ul {
                    each(item) { low ->
                        li {
                            a {
                                insert(low)
                            }
                        }
                    }
                }
            }
        }
    }

}