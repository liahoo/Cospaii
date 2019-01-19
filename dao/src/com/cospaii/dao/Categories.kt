package com.cospaii.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.sql.Column

object Categories: IdTable<String>("category_master") {
    override val id : Column<EntityID<String>> = varchar("id", 16).primaryKey().entityId()
    val index = integer("index")
    val name = varchar("name", 50)
    val href = varchar("href", 50)
    val img_src = varchar("img_src", 50).nullable()
    val level = integer("level")
    val parent_id = varchar("parent_id", 16).nullable()
}