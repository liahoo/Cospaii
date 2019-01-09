package com.cospaii.area

import com.cospaii.services.CartService
import com.cospaii.services.CategoryService
import com.cospaii.services.Menu
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HtmlBlockTag
import kotlinx.html.header
import kotlinx.html.id

class HeaderArea: Template<HtmlBlockTag> {
    override fun HtmlBlockTag.apply() {
        header {
            id = "header-area"
//            insert(HeaderTopArea()) {}
            insert(HeaderMiddleArea()) {
                cartItems = CartService.getCartItems()
            }
            insert(HeaderNavigationArea()) {
                categories = CategoryService.getHeaderCategories()
                navItems = Menu.mainMenu
            }
        }
    }
}