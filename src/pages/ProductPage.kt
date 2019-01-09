package com.cospaii.pages

import com.cospaii.area.FooterArea
import com.cospaii.area.HeaderArea
import com.cospaii.dao.ProductEntity
import com.cospaii.templates.HeadTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class ProductPage(var prod: ProductEntity): Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +prod.name }
            insert(HeadTemplate()) {}
        }
        body {
            insert(HeaderArea()) {}
            p{
                +prod.name
            }
            insert(FooterArea()) {}
        }
    }
}