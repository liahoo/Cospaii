package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class SearchRowTemplate: Template<FlowContent> {
    val miniCartBody = Placeholder<DIV>()
    val count = Placeholder<SUP>()
    var textInput: String? = null
    override fun FlowContent.apply() {
        div("col-8 col-md-7 col- m-auto ") {
            insert(SearchBoxTemplate()) {
                inputValue = textInput
            }
        }
        div("col-12 col-md-3 col-xl-2 m-auto text-center text-lg-right mt-xs-15") {
            div("minicart-wrapper") {
                button(classes = "btn btn-minicart") {
                    text("Cart")
                    sup("cart-count") {
                        insert(count)
                    }
                }
                div("minicart-content") {
                    style = "display: none;"
                    div("mini-cart-body") {
                        insert(miniCartBody)
                    }
                }
            }
        }
    }
}