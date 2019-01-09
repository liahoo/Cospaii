package com.cospaii.admin.pages

import com.cospaii.admin.areas.LoginArea
import com.cospaii.area.HeaderTopArea
import com.cospaii.templates.HeadTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class LoginPage: Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +"Admin Login" }
            insert(HeadTemplate()) {}
        }
        body {
            insert(LoginArea()){}
        }
    }
}