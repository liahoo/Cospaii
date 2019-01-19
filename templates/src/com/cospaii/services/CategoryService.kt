package com.cospaii.services

import com.cospaii.dao.Categories
import com.cospaii.dao.CategoryEntity
import com.cospaii.models.CategoryItem
import com.cospaii.models.Linkable
import com.cospaii.models.MenuItem
import com.cospaii.models.PopularCategoryItem
import com.cospaii.templates.R
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object CategoryService {
    fun getPopularCategories(): Array<PopularCategoryItem>? {
        return Array(4) {index ->
            PopularCategoryItem(R.getString("Category ${'A'+index}"), arrayOf(
                Linkable(name = R.getString("Sub Category ${'A' + index}-1"), href = "/SubCat1"),
                Linkable(name = R.getString("Sub Category ${'A' + index}-2"), href = "/SubCat2"),
                Linkable(name = R.getString("Sub Category ${'A' + index}-3"), href = "/SubCat2")
            ))
        }
    }

    fun getCategoryItems(): ArrayList<CategoryItem> {
        val cat1 = arrayListOf<CategoryEntity>()
        val cat2 = arrayListOf<CategoryEntity>()
        val cat3 = arrayListOf<CategoryEntity>()
        transaction {
            CategoryEntity.all().sortedBy {
                it.index
            }.forEach {
                when (it.level) {
                    1 -> cat1.add(it)
                    2 -> cat2.add(it)
                    3 -> cat3.add(it)
                }
            }
        }
        val topItemList = arrayListOf<CategoryItem>()
        cat1.forEach { topEntity ->
            val topItem = CategoryItem(entity = topEntity)
            cat2.filter {
                it.parentId == topEntity.id.value
            }.takeIf {
                it.count() > 0
            }?.sortedBy {
                it.index
            }?.let {
                val midItemList = arrayListOf<CategoryItem>()
                it.forEach { midEntity ->
                    val midItem = CategoryItem(entity = midEntity)
                    cat3.filter {
                        it.parentId == midEntity.id.value
                    }.takeIf {
                        it.count() > 0
                    }?.sortedBy {
                        it.index
                    }?.let {
                        val btmItemList = arrayListOf<CategoryItem>()
                        it.forEach { btmEntity ->
                            btmItemList.add(CategoryItem(btmEntity))
                        }
                        midItem.children = btmItemList
                    }
                    midItemList.add(midItem)
                }
                topItem.children = midItemList
            }
            topItemList.add(topItem)
        }
        return topItemList
    }
    fun getHeaderCategories(): ArrayList<MenuItem> {
        val cat1 = mutableListOf<CategoryEntity>()
        val cat2 = mutableListOf<CategoryEntity>()
        val cat3 = mutableListOf<CategoryEntity>()
        transaction {
            CategoryEntity.all().sortedBy {
                it.index
            }.forEach {
                when (it.level) {
                    1 -> cat1.add(it)
                    2 -> cat2.add(it)
                    3 -> cat3.add(it)
                }
            }
        }

        val topItemList = arrayListOf<MenuItem>()
        cat1.forEach { topEntity ->
            val topItem = MenuItem(
                name = topEntity.name,
                href = topEntity.href,
                imgSrc = topEntity.imgSrc
            )
            cat2.filter {
                it.parentId == topEntity.id.value
            }.takeIf {
                it.count() > 0
            }?.sortedBy {
                it.index
            }?.let {
                val midItemList = arrayListOf<MenuItem>()
                it.forEach { midEntity ->
                    val midItem = MenuItem(
                        name = midEntity.name,
                        href = midEntity.href,
                        imgSrc = midEntity.imgSrc
                    )
                    cat3.filter {
                        it.parentId == midEntity.id.value
                    }.takeIf {
                        it.count() > 0
                    }?.sortedBy {
                        it.index
                    }?.let {
                        val btmItemList = arrayListOf<MenuItem>()
                        it.forEach { btmEntity ->
                            btmItemList.add(MenuItem(
                                name = btmEntity.name,
                                href = btmEntity.href,
                                imgSrc = btmEntity.imgSrc
                            ))
                        }
                        midItem.children = btmItemList
                    }
                    midItemList.add(midItem)
                }
                topItem.children = midItemList
            }
            topItemList.add(topItem)
        }
        return topItemList
    }
}