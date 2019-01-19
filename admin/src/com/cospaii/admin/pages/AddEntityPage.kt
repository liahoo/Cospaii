package com.cospaii.admin.pages

import com.cospaii.admin.areas.AdminHeaderArea
import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.autoIncSeqName
import org.jetbrains.exposed.sql.isAutoInc

abstract class AddEntityPage: Template<HTML> {
    abstract var textTitle: String
    abstract var table: Table
    abstract var hrefFormAction: String
    override fun HTML.apply() {
        insert(BasePage()) {
            content {
                div {
                    id = "page-content-wrapper"
                    div("container") {
                        div("row justify-content-center") {
                            div("col-lg-8") {
                                h2 {
                                    +textTitle
                                }
                                form(action = hrefFormAction, method = FormMethod.post) {
                                    table.columns.forEach { col ->
                                        if (!col.columnType.isAutoInc) {
                                            div("single-input-item") {
                                                label {
                                                    attributes.put("for", col.name)
                                                    +col.name
                                                }
                                                input {
                                                    id = col.name
                                                    name = col.name
                                                    type = InputType.text
                                                    required = !col.columnType.nullable
                                                }
                                            }
                                        }
                                    }
                                    div("single-input-item") {
                                        button(classes = "btn") {
                                            +R.submit
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}