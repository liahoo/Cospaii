package com.cospaii.pages

import com.cospaii.controllers.CartService
import com.cospaii.controllers.SlideService
import com.cospaii.controllers.TabService
import com.cospaii.views.*
import com.fascode.templates.HeadTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class IndexPage: Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +"Home" }
            insert(HeadTemplate()) {}
        }
        body {
            header {
                id = "header-area"
                insert(HeaderTopArea()) {
                }
                insert(HeaderMiddleArea()) {
                    cartItems = CartService.getCartItems()
                }
                insert(HeaderNavigationArea()) {
                }
            }
            insert(SlideArea()){
                slideItems = SlideService.getSlideItems()
            }
            insert(ProductArea()) {
                appTabPanes = TabService.getTabPanes()
            }
        }
    }
}