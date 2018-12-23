package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class SwitcherTemplate() : Template<UL> {
    val selectedItem = Placeholder<A>()
    val item = PlaceholderList<UL, FlowContent>()
    override fun UL.apply() {
        li("switcher dropdown-show") {
            a(classes = "arrow-toggle") { insert(selectedItem) }
            ul("dropdown-nav") {
                each(item) {
                    li {
                        insert(it)
                    }
                }
            }
        }
    }

}