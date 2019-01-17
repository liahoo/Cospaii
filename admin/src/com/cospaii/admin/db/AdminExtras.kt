package com.cospaii.admin.db

import org.jetbrains.exposed.dao.IntIdTable

object AdminExtras: IntIdTable("admin_extras") {
    val username = varchar("username", 32)
    val login_time = datetime("login_time")
}