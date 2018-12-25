package com.fascode.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class SlickNavTemplate :Template<DIV>{
    val slick_nav_menu = Placeholder<UL>()
    override fun DIV.apply() {
        div("slicknav_menu") {
            a(classes = "slicknav_btn slicknav_collapsed", href = "#") {
                attributes.put("aria-haspopup", "true")
                tabIndex = "0"
                role = "button"
                span("slicknav_menutxt")
                span("slicknav_icon slicknav_no-text") {
                    span("slicknav_icon-bar")
                    span("slicknav_icon-bar")
                    span("slicknav_icon-bar")
                }
            }
            nav("slicknav_nav slicknav_hidden") {
                attributes.put("aria-hidden", "true")
                role = "menu"
                style = "display: none;"
                ul("main-navbar clearfix") {
                    insert(slick_nav_menu)
                }
            }
        }
    }
}