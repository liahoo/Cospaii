package com.cospaii.admin.pages

import com.cospaii.area.LoginArea
import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class LoginPage: Template<HTML> {
    var textTitle = R.getString("Admin Login")
    override fun HTML.apply() {
        head {
            title { +textTitle }
            insert(HeadTemplate()) {}
        }
        body {
            insert(LoginArea()){
                displayTitle = textTitle
                formAction = "/LoginCheck"
            }
        }
    }
}