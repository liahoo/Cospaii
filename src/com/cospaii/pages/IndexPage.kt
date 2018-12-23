package com.cospaii.pages

import com.fascode.templates.HeadTemplate
import com.fascode.templates.HeaderTemplate
import com.fascode.templates.SearchRowTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class IndexPage: Template<HTML> {
    val headArea = HeadTemplate()
    override fun HTML.apply() {
        head {
            title { +"Home" }
            insert(headArea) {}
        }
        body {
            insert(HeaderTemplate()){}
        }
    }
}