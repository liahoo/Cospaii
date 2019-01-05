package com.cospaii.mysql

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object DbHelper {
    fun connect(): Database {
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/test",
            driver = "com.mysql.jdbc.Driver",
            user = "cospaii",
            password = "DeYpm411"
        )
    }
    fun init() {
        connect()
        transaction {
            SchemaUtils.create(Products)
        }
    }
    fun findProductById(id: String?): ProductEntity? {
        return id?.let { ProductEntity.findById(it) }
    }
}