package com.cospaii.com.fascode.templates

import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class CategoryListTemplate: Template<DIV> {
    val item = PlaceholderList<UL, FlowContent>()
    override fun DIV.apply() {
        div("categories-list-wrap") {
            div("slicknav_menu") {

            }
            button(classes = "btn btn-category d-none d-lg-inline-block") {
                i("fa fa-bars")
            }
            ul("category-list-menu") {
                each(item) {
                    li {
                        insert(it)
                    }
                }
            }
        }
    }

}