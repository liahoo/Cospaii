package com.cospaii.models

import com.cospaii.dao.CategoryEntity

class CategoryItem(val entity: CategoryEntity,
                   var children: List<CategoryItem>? = null) {
}