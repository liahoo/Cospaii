package com.cospaii.templates

import io.ktor.html.*
import kotlinx.html.*

class CategoryItemGroupTemplate: Template<UL> {
    val category = Placeholder<A>()
    val subCategory = PlaceholderList<UL, ExpandableItemTemplate>()
    override fun UL.apply() {
        if(!subCategory.isEmpty()) {
            li("category-item-parent dropdown-show") {
                a(classes = "category-item arrow-toggle") {
                    insert(category)
                }
                ul(classes="mega-menu-wrap dropdown-nav") {
                    each(subCategory) { mid_item ->
                        insert(ExpandableItemTemplate()) {
                            insert(mid_item)
                        }
                    }
                }
            }
        } else {
            li("category-item-parent") {
                a(classes = "category-item") {
                    insert(category)
                }
            }
        }
    }
}