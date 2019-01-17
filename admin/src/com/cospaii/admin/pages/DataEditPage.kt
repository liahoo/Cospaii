package com.cospaii.admin.pages

import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class DataEditPage: Template<HTML> {
    var textTitle = R.getString(R.data_input)
    override fun HTML.apply() {
        head {
            title { +textTitle }
            insert(HeadTemplate()) {}
        }
        body {
            div("page-content-wrapper") {
                div("container") {
                    div("row") {
                        div("col-lg-12") {
                            div("login-reg-form-wrap  pr-lg-50") {
                                h2 {
                                    +textTitle
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}