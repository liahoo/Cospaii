package com.fascode.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class TabPaneTemplate: Template<FlowContent> {
    var isActive : Boolean = false
    var tabPaneId: String = "new-products"
    val products = PlaceholderList<FlowContent, SingleProductTemplate>()
    override fun FlowContent.apply() {
        div(classes="tab-pane fade") {
            if(isActive) {
                classes= setOf("tab-pane fade show active")
            }
            id = tabPaneId
            role = "tabpanel"
            div(classes = "products-wrapper") {
                div(classes = "product-carousel owl-carousel") {
                    each(products) {
                        insert(SingleProductTemplate()) {
                            insert(it)
                        }
                    }
                }
            }
        }
    }
}