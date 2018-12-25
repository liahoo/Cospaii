package com.cospaii.models

class MenuCategory(
    val name: String,
    var href: String = "#",
    val imgSrc: String? = null,
    var subCategories: Array<MenuCategory>? = null
) {}