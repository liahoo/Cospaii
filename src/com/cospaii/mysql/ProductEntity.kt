package com.cospaii.mysql

import org.jetbrains.exposed.dao.*


class ProductEntity(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, ProductEntity>(Products)
    var name by Products.name
    var store by Products.store
    var category_id by Products.category_id
    var category_name by Products.category_name
    var href by Products.href
    var score by Products.score
    var img_src by Products.img_src
    var all_img_src by Products.all_img_src
    var click_url by Products.click_url
    var detail_url by Products.detail_url
    var origin_price_usd by Products.origin_price_usd
    var discount by Products.discount
    var sales_price_usd by Products.sales_price_usd
    var out_of_stock_date by Products.out_of_stock_date
}