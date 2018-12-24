package com.cospaii.com.fascode.templates

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class SlickNavSingleItemTemplate: Template<UL> {
    val item = Placeholder<A>()
    override fun UL.apply() {
        li {
            a {
                role = "menuitem"
                insert(item)
            }
        }
    }
}