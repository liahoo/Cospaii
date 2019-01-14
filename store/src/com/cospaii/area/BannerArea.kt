package com.cospaii.area

import io.ktor.html.Template
import kotlinx.html.*

class BannerArea: Template<FlowContent> {
    var linkTo: String? = "#"
    var imageSrc: String? = ""
    var imageAlt: String? = "Banner"
    override fun FlowContent.apply() {
        div("banner-area") {
            div("container") {
                div("row") {
                    div("col-lg-12") {
                        a {
                            linkTo?.let{
                                href = it
                            }
                            img {
                                imageAlt?.let { alt = it }
                                imageSrc?.let { src = it }
                            }
                        }
                    }
                }
            }
        }
    }
}