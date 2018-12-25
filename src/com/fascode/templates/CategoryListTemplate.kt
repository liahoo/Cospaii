package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class CategoryListTemplate: Template<DIV> {
    val cat_menu = Placeholder<UL>()
    override fun DIV.apply() {
        div("col-10 col-lg-3") {
            div("categories-list-wrap") {
                button(classes = "btn btn-category d-none d-lg-inline-block") {
                    i("fa fa-bars")
                    text(R.getString("Categories"))
                }
                ul("category-list-menu") {
                    insert(cat_menu)
                }
            }
        }
    }

}