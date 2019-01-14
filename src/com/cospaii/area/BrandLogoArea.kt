package com.cospaii.area

import com.cospaii.templates.Linkable
import com.cospaii.templates.LinkableTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div

class BrandLogoArea: Template<HtmlBlockTag> {
    var item : Array<Linkable>? = null
    override fun HtmlBlockTag.apply() {
        div("brand-logo-area"){
            div("container") {
                div("row") {
                    div("col-lg-12"){
                        div("brand-logo-carousel owl-carousel"){
                            item?.forEach {
                                div("single-brand-item") {
                                    insert(LinkableTemplate(showText = false, showImage = true)){
                                        linkable = it
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}