package com.cospaii.admin.areas

import com.cospaii.templates.CategoriesTemplate
import com.cospaii.templates.LoginTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div

class LoginArea: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        div("page-content-wrapper") {
            div("container") {
                div("row") {
                    insert(LoginTemplate("/LoginCheck", "Admin Login")) {}
                }
            }
        }
    }
}