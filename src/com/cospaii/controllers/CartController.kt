package com.cospaii.controllers

import com.cospaii.models.CartItem

object CartController {
    val cartItems : Array<CartItem> = arrayOf(
    CartItem("item 1", "$100", 2, "assets/img/product-1.jpg", "/detail/1"),
    CartItem("item 2", "$100", 1, "assets/img/product-2.jpg", "/detail/2"),
    CartItem("item 3", "$100", 3, "assets/img/product-3.jpg", "/detail/3"))
}