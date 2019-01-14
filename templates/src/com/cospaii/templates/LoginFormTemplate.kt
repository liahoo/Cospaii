package com.cospaii.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import io.ktor.http.HttpMethod
import kotlinx.html.*
import sun.security.rsa.RSAKeyFactory
import sun.security.rsa.RSAKeyPairGenerator
import java.security.KeyPairGenerator

class LoginFormTemplate(
) : Template<FORM> {
    var funOnClick: String? = null
    override fun FORM.apply() {
        div("single-input-item") {
            input {
                name = "username"
                type = InputType.email
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
                funOnClick?.let { onClick = it }
                +R.getString("Login")
            }
        }
    }
}