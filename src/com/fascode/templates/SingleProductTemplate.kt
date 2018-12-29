package com.fascode.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.TemplatePlaceholder
import io.ktor.html.insert
import kotlinx.html.*

class SingleProductTemplate: Template<FlowContent> {
    val prodTitle = Placeholder<A>()
    val prodImage = Placeholder<IMG>()
    val prodPrice = Placeholder<FlowContent>()
    val prodRating = TemplatePlaceholder<RatingTemplate>()
    override fun FlowContent.apply() {
        div(classes = "single-product-item") {
            figure(classes = "product-thumb") {
                a(href = "single-product.html") {
                    img {
                        insert(prodImage)
                    }
                    a(href = "#", classes = "btn btn-round btn-cart") {
                        title = "Quick View"
                        attributes["data-toggle"] = "modal"
                        attributes["data-target"] = "#quickView"
                        i(classes = "fa fa-eye")
                    }
                }
            }
            div(classes = "product-details") {
                h2(classes = "product-title") {
                    a {
                        insert(prodTitle)
                    }
                }
                insert(RatingTemplate(), prodRating)
                span(classes = "product-price") { insert(prodPrice) }

                div(classes = "product-meta") {
                    a(href = "#", classes = "btn btn-round btn-cart") {
                        title = "Add to Cart"
                        i(classes = "fa fa-shopping-cart")
                    }
                    a(href = "wishlist.html", classes = "btn btn-round btn-cart") {
                        title = "Add to Wishlist"
                        i(classes = "fa fa-heart")
                    }
                    a(href = "compare.html", classes = "btn btn-round btn-cart") {
                        title = "Add to Compare"
                        i(classes = "fa fa-exchange")
                    }
                }
            }

        }
    }
}