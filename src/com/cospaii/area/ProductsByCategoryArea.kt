package com.cospaii.area

import com.cospaii.templates.CategoryProductsTemplate
import io.ktor.html.*
import kotlinx.html.*

class ProductsByCategoryArea: Template<HtmlBlockTag> {
//    val linkCatTitle = TemplatePlaceholder<LinkableTemplate>()
//    val linkCatBanner = TemplatePlaceholder<LinkableTemplate>()
    val productsByCategory = PlaceholderList<DIV, CategoryProductsTemplate>()
    override fun HtmlBlockTag.apply() {
        section {
            id="productsby-category"
            div("container") {
                div("productby-cate-content") {
                    div("row"){
                        each(productsByCategory) {
                            insert(CategoryProductsTemplate()) {
                                insert(it)
                            }
                        }
                    }
                }
            }
        }
    }

}