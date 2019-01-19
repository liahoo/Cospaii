package com.cospaii.dao

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DbHandler {
    fun connect(): Database {
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/cospaii",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "cospaii",
            password = "DeYpm411"
        )
    }
}