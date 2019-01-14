package com.cospaii.dao

import org.jetbrains.exposed.dao.IntIdTable

object Users: IntIdTable("users") {
    val username = varchar("username", 32)
    val password = varchar("password", 32)
    val nickname = varchar("nickname", 50)
    val gender = integer("gender")
    val role = integer("role")
    val age = integer("age")
}