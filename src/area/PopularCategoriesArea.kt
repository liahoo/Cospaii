package com.cospaii.area

import com.cospaii.models.Linkable
import com.cospaii.models.PopularCategoryItem
import com.cospaii.templates.LinkableTemplate
import com.cospaii.templates.R
import io.ktor.html.PlaceholderList
import io.ktor.html.Template
import io.ktor.html.each
import io.ktor.html.insert
import kotlinx.html.*

class PopularCategoriesArea: Template<HtmlBlockTag> {
    var category : Array<PopularCategoryItem>? = null
    override fun HtmlBlockTag.apply() {
        section {
            id = "popular-category"
            div("container"){
                div("row"){
                    div("col-lg-6"){
                        div("section-title"){
                            h2 {
                                +R.getString("Popular Categories")
                            }
                        }
                    }
                }
                div("popular-cate-wrap"){
                    div("row"){
                        category?.forEach { item ->
                            div("col-lg-6"){
                                div {
                                    val index = category?.indexOf(item) ?: 0
                                    if(0 == index){
                                        classes = setOf("single-popular-category")
                                    }else{
                                        classes = setOf("single-popular-category pop-cat-${index+1}")
                                    }
                                    dl("popular-cat-list"){
                                        dt {
                                            +(item.parent ?: "")
                                        }
                                        item.children?.forEach { subItem ->
                                            dd {
                                                insert(LinkableTemplate(showImage = false)){
                                                    linkable = subItem
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
    }
}