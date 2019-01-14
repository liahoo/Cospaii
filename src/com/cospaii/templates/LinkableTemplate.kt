package com.cospaii.templates

import io.ktor.html.Template
import kotlinx.html.*

class LinkableTemplate(var showImage: Boolean = true,
                       var showText: Boolean = true): Template<HtmlBlockTag> {
    var linkable: Linkable? = null
//    val phLinkable = Placeholder<Linkable>()
    override fun HtmlBlockTag.apply() {
//        phLinkable {
//            a(href = this@phLinkable.href) {
//                this@phLinkable.classes?.let { cls ->
//                    classes = setOf(cls)
//                }
//                this@phLinkable.imgSrc?.let { img_src ->
//                    img(alt = (this@phLinkable.imgAlt ?: this@phLinkable.name), src = img_src)
//                } ?: +this@phLinkable.name
//            }
//        }
        linkable?.let {lnk ->
            a(href = lnk.href) {
                lnk.classes?.let { cls ->
                    classes = setOf(cls)
                }
                if(showImage) {
                    lnk.imgSrc?.let { img_src ->
                        img(alt = (lnk.imgAlt ?: lnk.name), src = img_src)
                    }
                }
                if(showText) {
                    lnk.name?.let { +it }
                }
            }
        }
    }

}