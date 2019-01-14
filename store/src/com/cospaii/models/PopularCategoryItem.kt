package com.cospaii.models

import com.cospaii.templates.Linkable

class PopularCategoryItem(
    override val parent: String? = null,
    override val children: Array<Linkable>? = null
): IGroupItem<String, Array<Linkable>> {
}