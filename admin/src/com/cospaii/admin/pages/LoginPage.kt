package com.cospaii.admin.pages

import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.LogoTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class LoginPage: Template<HTML> {
    var textTitle = R.getString("Admin Login")
    var textError: String? = null
    var hrefForgotPwd: String? = "/forgot_password"
    var hrefFormAction: String = "/Login"
    override fun HTML.apply() {
        head {
            title { +textTitle }
            insert(HeadTemplate()) {}
        }
        body {
            header {
                div("header-middle-area") {
                    div("container") {
                        div("row") {
                            insert(LogoTemplate()) {}
                        }
                    }
                }
            }
            div {
                id = "page-content-wrapper"
                div("container") {
                    div("row justify-content-center") {
                        div("col-lg-5") {
                            h2 {
                                +textTitle
                            }
                            textError?.let {
                                div("alert alert-danger alert-dismissible fade show"){
                                    strong {
                                        +it
                                    }
                                }
                            }
                            form(action = hrefFormAction, method = FormMethod.post) {
                                id = "loginForm"
                                div("single-input-item") {
                                    input {
                                        name = "username"
                                        type = InputType.text
                                        placeholder = R.getString(R.email_or_username)
                                        required = true
                                    }
                                }
                                div("single-input-item") {
                                    input {
                                        name = "password"
                                        type = InputType.password
                                        placeholder = R.getString("Password")
                                        required = true
                                    }
                                }
                                div("single-input-item") {
                                    div("d-flex align-items-center justify-content-between") {
                                        div("remember-meta") {
                                            div("custom-control custom-checkbox") {
                                                input(classes = "custom-control-input", type = InputType.checkBox) {
                                                    id = "rememberMe"
                                                }
                                                label("custom-control-label") {
                                                    attributes.put("for", "rememberMe")
                                                    +R.remember_me
                                                }
                                            }
                                        }
                                        a(classes = "forget-pwd", href = hrefForgotPwd) {
                                            +R.forget_pwd
                                        }
                                    }
                                }

                                div("single-input-item") {
                                    button(classes = "btn") {
                                        +R.login
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