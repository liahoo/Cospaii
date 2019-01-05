package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class SwitcherTemplate : Template<UL> {
    val switcherSelected = Placeholder<A>()
    val switcherItem = PlaceholderList<UL, LI>()
    override fun UL.apply() {
        li("switcher dropdown-show") {
            a(classes = "arrow-toggle") { insert(switcherSelected) }
            ul("dropdown-nav") {
                each(switcherItem) {
                    li {
                        insert(it)
                    }
                }
            }
        }
    }

}