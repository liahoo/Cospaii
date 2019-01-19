package com.cospaii.admin.pages

import com.cospaii.services.CategoryService
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class IndexPage: Template<HTML> {
    override fun HTML.apply() {
        insert(BasePage()) {
            textTitle = R.admin_console
            content {
                div {
                    id = "page-content-wrapper"
                    div("container") {
                        div("row justify-content-center") {
                            h2 {
                                +textTitle
                            }
                            div {
                                a(href = "/Categories") {
                                    +R.categories
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}