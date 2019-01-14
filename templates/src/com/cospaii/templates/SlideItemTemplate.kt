package com.cospaii.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class SlideItemTemplate: Template<FlowContent> {
    var slideClassName = ""
    val item = PlaceholderList<FlowContent, DIV>()
    override fun FlowContent.apply() {
        each(item) {
            div("single-slide-item $slideClassName") {
                div(classes = "container") {
                    div(classes = "row") {
                        div(classes = "col-lg-12") {
                            div(classes = "slider-text") {
                                insert(it)
                            }
                        }
                    }
                }
            }
        }
    }
}
