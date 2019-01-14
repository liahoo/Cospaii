package com.cospaii.admin.db

import io.ktor.auth.Principal
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity

class AdminExtra(id: EntityID<Int>): IntEntity(id), Principal {
    companion object : EntityClass<Int, AdminExtra>(Admins)
    var username by AdminExtras.username
    var accessToken by AdminExtras.access_token
    var nickname by Admins.nickname
    var role by Admins.role
}