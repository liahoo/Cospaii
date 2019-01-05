package com.cospaii.models

class PopularCategoryItem(
    override val parent: String? = null,
    override val children: Array<Linkable>? = null
): IGroupItem<String, Array<Linkable>> {
}