package com.cospaii.admin.db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import com.cospaii.dao.*
import org.jetbrains.exposed.dao.EntityID
import sun.misc.BASE64Encoder

object DbAdmin {
    fun connect(): Database {
        return Database.connect(
            url = "jdbc:mysql://localhost:3306/cospaii",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "cospaii",
            password = "DeYpm411"
        )
    }
    fun init() {
        connect()
        transaction {
//            SchemaUtils.drop(Categories, Admins)
            initTable<Categories>(Categories) {
            }

            initTable(AdminExtras) {
            }
            initTable<Admins>(Admins) {
                it.insertAndGetId {entity ->
                    entity[username] = "admin"
                    entity[password] = BASE64Encoder().encode("admin".toByteArray())
                    entity[nickname] = "Super Admin"
                    entity[role] = 0
                }
                it.insertAndGetId {entity ->
                    entity[username] = "liahoo"
                    entity[password] = BASE64Encoder().encode("zxcv1234".toByteArray())
                    entity[nickname] = "Super Admin"
                    entity[role] = 1
                }
            }
        }
    }

    fun <TTable : Table> initTable(table: TTable, init: ((TTable) -> Unit)?) {
        if (!table.exists()) {
            SchemaUtils.create(table)
            init?.invoke(table)
        } else {
//            SchemaUtils.createMissingTablesAndColumns(table)
        }
    }
    fun findProductById(id: String?): ProductEntity? {
        return id?.let { ProductEntity.findById(it) }
    }
}