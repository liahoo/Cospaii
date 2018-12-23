package com.fascode.templates

import com.fascode.templates.MenuTemplate
import io.ktor.html.*
import kotlinx.html.*

class TopBarTemplate(val mailto: String = "support@cospaii.com",
                     val telno: String = "(81)90-6659-8766",
                     val langSelected : String = "English",
                     val langs: Array<String> = arrayOf("English", "日本語", "中文"),
                     val currencySelected: String = "USD",
                     val currencies: Array<String> = arrayOf("USD", "JPY", "RMB")
): Template<FlowContent> {
    override fun FlowContent.apply() {
        div("container") {
            div("row") {
                div("col-md-5 col-lg-6") {
                    div("preheader-contact-info d-flex align-items-center justify-content-between justify-content-md-start") {
                        div("single-contact-info") {
                            span("contact-icon") {
                                i("fa fa-envelope")
                            }
//                                email.apply(addr)
                            a(classes = "contact-text", href = "mailto: $mailto") {
                                strong {
                                    +mailto
                                }
                            }
                        }
                        div("single-contact-info") {
                            span("contact-icon") {
                                i("fa fa-phone")
                            }
                            a(classes = "contact-text", href = "tel:$telno") {
                                strong {
                                    +telno
                                }
                            }
                        }
                    }

                }
                div("col-md-7 col-lg-6 mt-xs-10") {
                    insert(MenuTemplate(langSelected, langs, currencySelected, currencies)) {

                    }
                }
            }
        }
    }

}