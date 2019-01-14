package com.cospaii.services

import com.cospaii.models.CartItem

object CartService {
    fun getCartItems(): List<CartItem> {
        return listOf(
            CartItem("items 1", "$100", 2, "assets/img/product-1.jpg", "/detail/1"),
            CartItem("items 2", "$100", 1, "assets/img/product-2.jpg", "/detail/2"),
            CartItem("items 3", "$100", 3, "assets/img/product-3.jpg", "/detail/3")
        )
    }
}