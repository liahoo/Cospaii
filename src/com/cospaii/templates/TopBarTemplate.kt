package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class TopBarTemplate: Template<FlowContent> {
    var email : String? = null
    var phone :String? = null
    val menu = Placeholder<UL>()
    override fun FlowContent.apply() {
        div("container") {
            div("row") {
                div("col-md-5 col-lg-6") {
                    div("preheader-contact-info d-flex align-items-center justify-content-between justify-content-md-start") {
                        div("single-contact-info") {
                            email?.let{str ->
                                span("contact-icon") {
                                    i("fa fa-envelope")
                                }
                                a(classes = "contact-text", href = "mailto:$str") {
                                    strong { text(str) }
                                }
                            }
                        }
                        div("single-contact-info") {
                            phone?.let {num ->
                                span("contact-icon") {
                                    i("fa fa-phone")
                                }
                                a(classes = "contact-text", href = "tel:$num") {
                                    strong { text(num) }
                                }
                            }
                        }
                    }

                }
                div("col-md-7 col-lg-6 mt-xs-10") {
                    div("site-setting-menu") {
                        ul("nav justify-content-center justify-content-md-end") {
                            insert(menu)
                        }
                    }
                }
            }
        }
    }

}