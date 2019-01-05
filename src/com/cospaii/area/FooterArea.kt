package com.cospaii.area

import com.cospaii.controllers.BannerService
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class FooterArea: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        footer {
            insert(BrandLogoArea()){
                item = BannerService.getBannersForFooter()
            }
            insert(FooterBottomArea()){}
        }
        a(classes = "scrolltotop") {
            i("fa fa-angle-up")
        }
    }
}