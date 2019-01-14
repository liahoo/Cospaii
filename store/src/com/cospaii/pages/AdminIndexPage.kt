package com.cospaii.pages

import com.cospaii.area.HeaderArea
import com.cospaii.templates.HeadTemplate
import com.cospaii.templates.R
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class AdminIndexPage: Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +R.getString("Admin") }
            insert(HeadTemplate()){}
        }
        body {
            h2 { +R.getString("Admin") }

        }
    }
}