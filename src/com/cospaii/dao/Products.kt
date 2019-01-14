package com.cospaii.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.sql.Column

object Products: IdTable<String>("products") {
    override val id : Column<EntityID<String>> = varchar("id", 16).primaryKey().entityId()
    val name = varchar("name", 50)
    val description = varchar("description", 1024)
    val store = varchar("store", 32)
    val category_id = varchar("category_id", 16)
    val category_name = varchar("category_name", 50)
    val origin_price_usd = double("origin_price_usd").nullable()
    val sales_price_usd = double("sales_price_usd").nullable()
    val score = integer("score").nullable()
    val href = varchar("href", 1024).nullable()
    val img_src = varchar("img_src", 1024).nullable()
    val all_img_src = varchar("all_img_src", 1024).nullable()
    val detail_url = varchar("detail_url", 1024).nullable()
    val click_url = varchar("click_url", 1024).nullable()
    val out_of_stock_date = datetime("out_of_stock_date").nullable()
    val discount = varchar("discount", 8).nullable()
}