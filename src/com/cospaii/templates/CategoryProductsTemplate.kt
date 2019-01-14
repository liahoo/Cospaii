package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class CategoryProductsTemplate: Template<HtmlBlockTag> {
    val linkCategary = TemplatePlaceholder<LinkableTemplate>()
    val eachProduct = PlaceholderList<FlowContent, SingleProductTemplate>()
//    var prodList : Array<ProductItem>? = null
    override fun HtmlBlockTag.apply() {
        div("col-lg-6"){
            div("category-product-wrap"){
                h4("cate-pro-title"){
                    insert(LinkableTemplate(showText = true, showImage = false), linkCategary)
                }
                figure("cat-banner"){
                    insert(LinkableTemplate(showText = false, showImage = true), linkCategary)
                }
                div(classes = "products-wrapper") {
                    div(classes = "cat-pro-carousel owl-carousel") {
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
}