package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class SlickNavCollapseItemTemplate: Template<UL> {
    val parent = Placeholder<A>()
    val subItem = PlaceholderList<UL, A>()
    override fun UL.apply() {
        li("slicknav_parent slicknav_collapsed"){
            a(classes = "slicknav_item slicknav_row", href="#") {
                attributes.put("aria-haspopup", "true")
                tabIndex = "-1"
                role = "menuitem"
                style="outline: none;"
                insert(parent)
                span("slicknav_arrow") {
                    +"+"
                }
            }
            ul("sub-dropdown slicknav_hidden"){
                each(subItem) {item ->
                    li {
                        a {
                            role = "menuitem"
                            tabIndex = "-1"
                            insert(item)
                        }
                    }
                }
            }
        }
    }
}