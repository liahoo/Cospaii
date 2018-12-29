package com.cospaii.models

class TabPane(val id: String,
              val tabId: String,
              val name: String,
              val products: Array<ProductItem>?
) {
    val href: String
        get() =  "#$id"
}