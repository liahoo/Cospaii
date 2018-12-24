package com.cospaii.models

data class CartItem(
    val title: String,
    val price: String,
    val quantity: Int,
    val imgSrc: String,
    val hrefDetail: String
){}