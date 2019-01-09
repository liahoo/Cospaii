package com.cospaii.area

import io.ktor.html.Template
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.p

class FooterBottomArea: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div("footer-bttom-area") {
            div("container") {
                div("row") {
                    div("col-md-6 m-auto text-center order-last order-md-first") {
                        p {
                            +"Copyright © 2018.Cospaii.com All rights reserved."
                        }
                    }
                }
            }
        }
    }
}