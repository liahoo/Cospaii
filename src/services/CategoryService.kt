package com.cospaii.services

import com.cospaii.models.Linkable
import com.cospaii.models.MenuItem
import com.cospaii.models.PopularCategoryItem
import com.cospaii.templates.R

object CategoryService {
    fun getPopularCategories(): Array<PopularCategoryItem>? {
        return Array(4) {index ->
            PopularCategoryItem(R.getString("Category ${'A'+index}"), arrayOf(
                Linkable(name = R.getString("Sub Category ${'A'+index}-1"), href = "/SubCat1"),
                Linkable(name = R.getString("Sub Category ${'A'+index}-2"), href = "/SubCat2"),
                Linkable(name = R.getString("Sub Category ${'A'+index}-3"), href = "/SubCat2")
            ))
        }
    }

    fun getHeaderCategories(): Array<MenuItem> {
        return Menu.categories
    }
}