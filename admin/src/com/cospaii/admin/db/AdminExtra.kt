package com.cospaii.admin.db

import io.ktor.auth.Principal
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity

class AdminExtra(id: EntityID<Int>): IntEntity(id), Principal {
    companion object : EntityClass<Int, AdminExtra>(Admins)
    var username by AdminExtras.username
    var authToken by AdminExtras.auth_token
    var create_time by AdminExtras.create_time
}