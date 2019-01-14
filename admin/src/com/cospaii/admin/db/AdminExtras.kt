package com.cospaii.admin.db

import org.jetbrains.exposed.dao.IntIdTable

object AdminExtras: IntIdTable("admin_extras") {
    val username = varchar("username", 32)
    val access_token = varchar("access_token", 64)
    val expire_time = datetime("expire_time")
}