package com.cospaii.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class CategoryEntity(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, CategoryEntity>(Categories)
    var index by Categories.index
    var name by Categories.name
    var href by Categories.href
    var imgSrc by Categories.img_src
    var level by Categories.level
    var parentId by Categories.parent_id
}