package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class TabPaneTemplate: Template<FlowContent> {
    var isActive : Boolean = false
    var tabPaneId: String = "new-products"
    val eachProduct = PlaceholderList<FlowContent, SingleProductTemplate>()
    override fun FlowContent.apply() {
        div(classes="tab-pane fade") {
            if(isActive) {
                classes= setOf("tab-pane fade show active")
            }
            id = tabPaneId
            role = "tabpanel"
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
}