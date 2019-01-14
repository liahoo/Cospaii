package com.cospaii.area

import com.cospaii.templates.LoginFormTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class LoginArea: Template<HtmlBlockTag> {
    var displayTitle = R.getString("User Login")
    var formAction = "/LoginCheck"
    override fun HtmlBlockTag.apply() {
        div("page-content-wrapper") {
            div("container") {
                div("row") {
                    div("col-lg-12") {
                        div("login-reg-form-wrap  pr-lg-50") {
                            h2 {
                                +displayTitle
                            }
                            form(action = formAction, method = FormMethod.post) {
                                insert(LoginFormTemplate()) {}
                            }
                        }
                    }
                }
            }
        }
    }
}