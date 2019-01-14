package com.cospaii.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID

class CategoryEntity(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, CategoryEntity>(Categories)
    var name by Categories.name
    var href by Categories.href
    var img_src by Categories.img_src
    var level by Categories.level
}