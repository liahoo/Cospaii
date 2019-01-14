package com.cospaii.admin.db

import org.jetbrains.exposed.dao.IntIdTable

object Admins: IntIdTable("admins") {
    val username = varchar("username", 32)
    val password = varchar("password", 64)
    val nickname = varchar("nickname", 50)
    val role = integer("role")
}