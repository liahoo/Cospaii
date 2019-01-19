package com.cospaii.admin.pages

import com.cospaii.admin.areas.CategoryItemArea
import com.cospaii.dao.Categories
import com.cospaii.dao.CategoryEntity
import com.cospaii.services.CategoryService
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class CategoriesPage: Template<HTML> {
    var categories = CategoryService.getCategoryItems()
    var colNames = Categories.columns.map { it.name }
    override fun HTML.apply() {
        insert(BasePage()) {
            content {
                div {
                    id = "page-content-wrapper"
                    div("container") {
                        div("row") {
                            h1 {
                                +R.categories
                            }
                            div("cart-table table-responsive") {
                                table("table table-bordered"){
                                    thead {
                                        tr {
                                            colNames.forEach {name ->
                                                th {
                                                    +name
                                                }
                                            }
                                            th {
                                                +R.edit
                                            }
                                            th{
                                                +R.delete
                                            }
                                        }
                                    }
                                    tbody {
                                        categories.forEach { topCategory ->
                                            insert(CategoryItemArea(colNames, topCategory)){}
                                            topCategory.children?.forEach { midCategory ->
                                                insert(CategoryItemArea(colNames, midCategory)){}
                                                midCategory.children?.forEach { btmCategory ->
                                                    insert(CategoryItemArea(colNames, btmCategory)){}
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        div("row") {
                            a(classes = "btn", href = "/Category/Create") {
                                +R.add_category
                            }
                        }
                    }
                }
            }
        }
    }
}