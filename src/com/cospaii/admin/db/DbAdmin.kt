package com.cospaii.admin.db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import com.cospaii.dao.*

object DbAdmin {
    fun connect(): Database {
        return Database.connect(
            url = "jdbc:dao://localhost:3306/cospaii",
            driver = "com.dao.jdbc.Driver",
            user = "cospaii",
            password = "DeYpm411"
        )
    }
    fun init() {
        connect()
        transaction {
            val isNewCategoryMaster = !Categories.exists()
            initTable(Products, Users, Categories)
            if(isNewCategoryMaster){
                initCategoryMaster()
            }
        }
    }

    private fun initCategoryMaster() {
        CategoryEntity.new("1") {
            name = "Home"
            href = "/Category/Home"
            level = 0
//            img_src = "assert"
        }
    }

    private fun initTable(vararg tables: Table){
        tables.forEach { table ->
            if(!table.exists()) {
                SchemaUtils.create(table)
            } else {
//                when(table.tableName) {
//                    Categories.tableName -> SchemaUtils.createMissingTablesAndColumns(table)
//                }
            }

        }
    }
    fun findProductById(id: String?): ProductEntity? {
        return id?.let { ProductEntity.findById(it) }
    }
}