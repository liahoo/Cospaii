package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class MiniCartTemplate: Template<FlowContent> {
    val itemThumb = Placeholder<A>()
    val itemTitle = Placeholder<A>()
    val itemQuantity = Placeholder<SPAN>()
    val itemPrice = Placeholder<SPAN>()
    override fun FlowContent.apply() {
        div("single-cart-item d-flex") {
            figure("product-thumb") {
                a {
                    insert(itemThumb)
                }
            }
            div("product-details") {
                h2 {
                    a {
                        insert(itemTitle)
                    }
                }
                div("cal d-flex align-items-center") {
                    span("quantity") {
                        insert(itemQuantity)
                    }
                    span("multiplication") {
                        +" x "
                    }
                    span("price") {
                        insert(itemPrice)
                    }
                }
            }
            a(classes = "remove-icon") {
                i("fa fa-trash-o")
            }

        }
    }
}