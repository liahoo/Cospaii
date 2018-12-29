package com.fascode.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class TabMenuTemplate : Template<FlowContent> {
    val tab = PlaceholderList<UL, A>()
    override fun FlowContent.apply() {
        ul(classes = "nav justify-content-center") {
            role = "tablist"
            each(tab) {
                li {
                    a {
//                        id = "new-product-tab"
                        attributes["data-toggle"] = "tab"
                        insert(it)
                    }
                }
            }
        }

    }
}