package com.cospaii.admin.db

import org.jetbrains.exposed.dao.IntIdTable

object AdminExtras: IntIdTable("admin_extras") {
    val username = varchar("username", 32)
    val auth_token = varchar("auth_token", 64)
    val create_time = datetime("create_time")
}