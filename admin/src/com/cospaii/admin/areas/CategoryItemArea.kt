package com.cospaii.admin.areas

import com.cospaii.dao.Categories
import com.cospaii.models.CategoryItem
import io.ktor.html.Template
import kotlinx.html.*

class CategoryItemArea(val colNames: List<String>,
                       val category: CategoryItem
): Template<TBODY> {
    override fun TBODY.apply() {
        tr {
            colNames.forEach { eachName ->
                td {
                    Categories.columns.find { col ->
                        col.name.equals(eachName)
                    }?.let {
                        +(category.entity.readValues[it]?.toString() ?: "")
                    }
                }
            }
            td {
                a(href = "/Category/Edit/${category.entity.id.value}") {

                }
            }
            td {
                a(href = "#") {
                    i("fa fa-trash-o") { }
                }
            }
        }

    }
}