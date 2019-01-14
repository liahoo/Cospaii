package com.cospaii.dao

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DbHelper {
    fun connect(): Database {
        return Database.connect(
            url = "jdbc:dao://localhost:3306/cospaii",
            driver = "com.dao.jdbc.Driver",
            user = "cospaii",
            password = "DeYpm411"
        )
    }
    fun findProductById(id: String?): ProductEntity? {
        return id?.let { ProductEntity.findById(it) }
    }
}