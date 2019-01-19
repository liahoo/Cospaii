package com.cospaii.templates

import io.ktor.html.Template
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img

class LogoTemplate: Template<FlowContent> {
    var logoImageSrc = "/assets/img/logo.png"
    override fun FlowContent.apply() {
        div("col-4 col-md-2 col-xl-3 m-auto text-center text-lg-left") {
            a(href = "/", classes = "logo-wrap d-block") {
                img(src=logoImageSrc, classes = "img-fluid", alt = "Logo")
            }
        }
    }
}