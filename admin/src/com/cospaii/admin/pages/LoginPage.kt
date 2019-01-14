package com.cospaii.admin.pages

import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.LoginFormTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*
import kotlinx.html.dom.document
import java.security.interfaces.RSAPublicKey
import javax.crypto.Cipher

class LoginPage: Template<HTML> {
    var textTitle = R.getString("Admin Login")
    var textError: String? = null
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
                                textError?.let {
                                    p("") {
                                        +it
                                    }
                                }
                                form(action = "/LoginCheck", method = FormMethod.post) {
                                    id = "loginForm"
                                    div("single-input-item") {
                                        input {
                                            name = "username"
                                            type = InputType.text
                                            placeholder = "Email or Username"
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
                                        button(classes = "btn") {
                                            +R.getString("Login")
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