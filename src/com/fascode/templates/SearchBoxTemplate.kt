package com.fascode.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import kotlinx.html.*

class SearchBoxTemplate: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div("search-box-wrap") {
            form(classes = "search-form d-flex", action = "#", method = FormMethod.get) {
                input(type = InputType.search, name = "search") {
                    placeholder = "type and hit enter"
                }
                button(classes = "btn btn-search") {
                    img(src = "assets/img/icons/icon-search.png", alt = "Search Icon")
                }
            }
        }
    }
}