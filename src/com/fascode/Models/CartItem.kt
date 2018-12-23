package com.fascode.Models

data class CartItem(
    val title: String,
    val price: String,
    val quantity: Int,
    val imgSrc: String,
    val hrefDetail: String
){}