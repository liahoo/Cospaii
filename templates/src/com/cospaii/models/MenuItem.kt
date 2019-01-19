package com.cospaii.models

class MenuItem(override val name: String,
               override var href: String = "#",
               override val imgSrc: String? = null,
               var children: ArrayList<MenuItem>? = null
): ILinkable {
    val hasChildren: Boolean
        get() = !children.isNullOrEmpty()
}