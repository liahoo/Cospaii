package com.cospaii.com.fascode.templates

import io.ktor.html.Template
import io.ktor.html.TemplatePlaceholder
import io.ktor.html.insert
import kotlinx.html.FlowContent
import kotlinx.html.UL
import kotlinx.html.div
import kotlinx.html.li

class NavTemplate: Template<FlowContent> {
    val categories = TemplatePlaceholder<CategoryListTemplate>()
    val mainMenu = TemplatePlaceholder<MainMenuTemplate>()
    override fun FlowContent.apply() {
        div("container") {
            div("row") {
                div("col-10 col-lg-3") {
                    insert(CategoryListTemplate(), categories)
                }
                div("col-2 col-lg-9 d-none d-lg-block") {
                    insert(MainMenuTemplate(), mainMenu)
                }
            }

        }
    }

}