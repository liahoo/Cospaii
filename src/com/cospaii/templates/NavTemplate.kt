package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class NavTemplate: Template<DIV> {
    val navMenu = Placeholder<UL>()
    override fun DIV.apply() {
        div("main-menu-wrap") {
            nav("mainmenu"){
                ul("main-navbar clearfix"){
                    insert(navMenu)
                }
            }
        }
    }

}