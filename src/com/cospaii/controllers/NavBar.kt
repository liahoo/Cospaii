package com.cospaii.controllers

import com.fascode.templates.R

object NavBar {
    val home = Pair(R.getString("Home"), "/")
    val phone = Pair(R.getString("Phone"), "/Phone")
    val tablet = Pair(R.getString("Tablet"), "/Tablet")
    val laptop = Pair(R.getString("Laptop"), "/Laptop")
    val clothes = Pair(R.getString("Clothes"), "/Clothes")
    val mens = Pair(R.getString("Mens"), "/Clothes/Mens")
    val ladies = Pair(R.getString("Ladies"), "/Clothes/Mens")
    val kids = Pair(R.getString("Kids"), "/Clothes/Kids")
    val toys = Pair(R.getString("Toys"), "/Toys")
    val wallets = Pair(R.getString("Wallets"), "/Wallets")
    val electronics = Pair(R.getString("Electronics"), "/Electronics")
    val clothesChildren = arrayOf(mens, ladies, kids)
    val electronicsChildren = arrayOf(phone, tablet, laptop)
}