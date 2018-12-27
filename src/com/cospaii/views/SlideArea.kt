package com.cospaii.views

import com.cospaii.models.SlideItem
import com.fascode.templates.R
import com.fascode.templates.SlideItemTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class SlideArea: Template<FlowContent> {
    val slideItems = arrayOf(
        SlideItem("Title 1", "", "Secondary 1", "Third 1", R.getString("See More"), "#" ),
        SlideItem("Title 2", "slide-item_2", "Secondary 1", "Third 1", R.getString("See More"), "#"),
        SlideItem("Title 3", "slide-item_3", "Secondary 1", "Third 1", R.getString("See More"), "#"),
        SlideItem("Title 4", "slide-item_4", "Secondary 1", "Third 1", R.getString("See More"), "#")

    )
    override fun FlowContent.apply() {
        div("slider-area-wrap") {
            div("home-slider-carousel owl-carousel") {
                slideItems.forEach {slideItem ->
                    insert(SlideItemTemplate()) {
                        slideClassName = slideItem.className
                        item {
                            h2 { +slideItem.primary }
                            h3 { +slideItem.secondary }
                            h4 { +slideItem.third }
                            a(href=slideItem.href, classes = "btn") { +slideItem.textButton }
                        }
                    }
                }
            }
        }
    }


}