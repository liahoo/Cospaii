package com.cospaii.com.fascode.templates

import io.ktor.html.Template
import kotlinx.html.*

class MainMenuTemplate: Template<DIV> {
    override fun DIV.apply() {
        div("main-menu-wrap") {
            nav("mainmenu"){
                ul("main-navbar clearfix"){

                }
            }
        }
    }

}