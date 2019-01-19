package com.cospaii.admin.pages

import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.LogoTemplate
import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class BasePage: Template<HTML> {
    var textTitle: String = ""
    val content = Placeholder<BODY>()

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
            insert(content)
        }
    }
}