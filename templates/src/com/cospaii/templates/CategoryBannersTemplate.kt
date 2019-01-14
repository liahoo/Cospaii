package com.cospaii.templates

import io.ktor.html.Template
import io.ktor.html.TemplatePlaceholder
import io.ktor.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div

class CategoryBannersTemplate: Template<HtmlBlockTag> {
    val bannerLeft = TemplatePlaceholder<LinkableTemplate>()
    val bannerMidTopLeft = TemplatePlaceholder<LinkableTemplate>()
    val bannerMidTopRight = TemplatePlaceholder<LinkableTemplate>()
    val bannerMidBottom = TemplatePlaceholder<LinkableTemplate>()
    val bannerRight = TemplatePlaceholder<LinkableTemplate>()
    override fun HtmlBlockTag.apply() {
        div("category-banner-area") {
            div("container"){
                div("row row-5"){
                    div("col-md-3"){
                        insert(LinkableTemplate(showText = false), bannerLeft)
                    }
                    div("col-md-9") {
                        div("row row-5"){
                            div("col-md-8"){
                                div("row row-5") {
                                    div("col-md-6 mt-10 mt-sm-0 mt-lg-0") {
                                        insert(LinkableTemplate(showText = false), bannerMidTopLeft)
                                    }
                                    div("col-md-6 mt-10 mt-sm-0 mt-lg-0") {
                                        insert(LinkableTemplate(showText = false), bannerMidTopRight)
                                    }
                                }
                                div("row row-5") {
                                    div("col-md-12 mt-10"){
                                        insert(LinkableTemplate(showText = false), bannerMidBottom)
                                    }
                                }
                            }
                            div("col-md-4 mt-10 mt-sm-0 mt-lg-0"){
                                insert(LinkableTemplate(showText = false), bannerRight)
                            }
                        }
                    }
                }
            }
        }
    }

}