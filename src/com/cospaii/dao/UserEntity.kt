package com.cospaii.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity

class UserEntity(id: EntityID<Int>): IntEntity(id){
    companion object : EntityClass<Int, UserEntity>(Users)
    var username by Users.username
    var password by Users.password
    var age by Users.age
    var gender by Users.gender
    var nickname by Users.nickname
    var role by Users.role
}