package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class NavMenuTemplate: Template<DIV> {
    val main_menu = Placeholder<UL>()
    override fun DIV.apply() {
        div("main-menu-wrap") {
            nav("mainmenu"){
                ul("main-navbar clearfix"){
                    insert(main_menu)
                }
            }
        }
    }

}