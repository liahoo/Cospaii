package com.cospaii.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class BreadCrumbTemplate: Template<FlowContent> {
    val crumb = PlaceholderList<UL, A>()

    override fun FlowContent.apply() {
        div("page-breadcrumb-wrap"){
            div("container") {
                div("row") {
                    div("col-lg-12"){
                        div("page-breadcrumb"){
                            ul("nav") {
                                each(crumb) { c ->
                                    li {
                                        a {
                                            insert(c)
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
}