package com.fascode.templates

import io.ktor.html.*
import kotlinx.html.*

class CategoryItemTemplate: Template<UL> {
    val category = Placeholder<A>()
//    val mid_item = Placeholder<UL>()
    val subCategory = PlaceholderList<UL, CategorySubItemTemplate>()
    override fun UL.apply() {
        li("category-item-parent dropdown-show"){
            a(classes="category-item") {
                if(!subCategory.isEmpty()){
                    classes = setOf("category-item","arrow-toggle")
                }
                insert(category)
            }
            ul("mega-menu-wrap dropdown-nav"){
//                insert(mid_item)
                each(subCategory) { mid_item ->
                    insert(CategorySubItemTemplate()){
                        insert(mid_item)
                    }
                }
            }
        }
    }
}