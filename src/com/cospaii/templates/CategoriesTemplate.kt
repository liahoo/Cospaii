package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class CategoriesTemplate: Template<DIV> {
    val catMenu = Placeholder<UL>()
    override fun DIV.apply() {
        div(classes="categories-list-wrap") {
            button(classes = "btn btn-category d-none d-lg-inline-block") {
                i("fa fa-bars")
                text(R.getString("Categories"))
            }
            ul("category-list-menu") {
                insert(catMenu)
            }
        }
    }
}