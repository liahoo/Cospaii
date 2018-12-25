package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class CategorySubItemTemplate: Template<UL> {
    val mid_item = Placeholder<A>()
    val low_item = PlaceholderList<UL, A>()
    override fun UL.apply() {

        li(classes = "mega-menu-item") {
            a(classes ="mega-item-title") {
                insert(mid_item)
            }
            ul {
                each(low_item) { low ->
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