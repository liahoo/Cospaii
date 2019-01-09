package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class RatingTemplate: Template<FlowContent> {
    val score = Placeholder<SPAN>()

    override fun FlowContent.apply() {
        div(classes = "rating") {
            i(classes = "fa fa-star")
            i(classes = "fa fa-star")
            i(classes = "fa fa-star")
            i(classes = "fa fa-star")
            i(classes = "fa fa-star")
            span { insert(score) }
        }
    }
}