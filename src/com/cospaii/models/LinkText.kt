package com.cospaii.models

class LinkText(override val name: String,
               override var href: String = "#",
               override val imgSrc: String? = null
): Linkable {}