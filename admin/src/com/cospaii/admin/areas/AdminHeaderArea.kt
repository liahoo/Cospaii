package com.cospaii.admin.areas

import com.cospaii.templates.LogoTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.div
import kotlinx.html.header

class AdminHeaderArea: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        header {
            div("header-middle-area") {
                div("container") {
                    div("row") {
                        insert(LogoTemplate()) {}
                    }
                }
            }
        }
    }
}