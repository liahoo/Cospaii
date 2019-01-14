package com.cospaii.admin.db

import io.ktor.auth.Principal
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity

class AdminEntity(id: EntityID<Int>): IntEntity(id), Principal {
    companion object : EntityClass<Int, AdminEntity>(Admins)
    var username by Admins.username
    var password by Admins.password
    var nickname by Admins.nickname
    var role by Admins.role
}