package com.cospaii.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.div

class ProductsCarouselTemplate: Template<FlowContent> {
    val eachProduct = PlaceholderList<FlowContent, SingleProductTemplate>()
    override fun FlowContent.apply() {
        div(classes = "products-wrapper") {
            div(classes = "product-carousel owl-carousel") {
                each(eachProduct) {
                    insert(SingleProductTemplate()) {
                        insert(it)
                    }
                }
            }
        }

    }
}