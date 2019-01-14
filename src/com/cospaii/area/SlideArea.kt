package com.cospaii.area

import com.cospaii.models.SlideItem
import com.cospaii.templates.SlideItemTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class SlideArea: Template<FlowContent> {
    var slideItems: Array<SlideItem> = emptyArray()
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