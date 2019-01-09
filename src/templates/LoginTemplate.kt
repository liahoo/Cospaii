package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import io.ktor.http.HttpMethod
import kotlinx.html.*

class LoginTemplate(
    val fill_action: String,
    val fill_title: String
) : Template<FlowContent> {
    override fun FlowContent.apply() {
        div("col-lg-5"){
            div("login-reg-form-wrap  pr-lg-50"){
                h2 {
                    +fill_title
                }
                form(method=FormMethod.post) {
                    action = fill_action
                    div("single-input-item") {
                        input {
                            type = InputType.email
                            placeholder = "Email or Username"
                            required = true
                        }
                    }
                    div("single-input-item") {
                        input {
                            type = InputType.password
                            placeholder = R.getString("Password")
                            required = true
                        }
                    }
                    div("single-input-item") {
                        div("login-reg-form-meta d-flex align-items-center justify-content-between") {
                            div("remember-meta") {
                                div("custom-control custom-checkbox") {
                                    input(type = InputType.checkBox, classes = "custom-control-input") {
                                        id = "rememberMe"
                                    }
                                    label("custom-control-label") {
                                        attributes.put("for", "rememberMe")
                                        +R.getString("Remember Me")
                                    }
                                }
                            }
                            a(href = "#", classes = "forget-pwd") {
                                +R.getString("Forget Password?")
                            }
                        }
                    }
                    div("single-input-item") {
                        button(classes = "btn") {
                            +R.getString("Login")
                        }
                    }
                }
            }

        }
    }

}