package com.cospaii.controllers

import com.fascode.templates.R

object NavBar {
    val home = Pair(R.getString("home"), "/")
    val phone = Pair(R.getString("phone"), "/phone")
    val tablet = Pair(R.getString("tablet"), "/tablet")
    val laptop = Pair(R.getString("laptop"), "/laptop")
    val clothes = Pair(R.getString("clothes"), "/clothes")
    val mens = Pair(R.getString("mens"), "/clothes/mens")
    val ladies = Pair(R.getString("ladies"), "/clothes/mens")
    val kids = Pair(R.getString("kids"), "/clothes/kids")
    val toys = Pair(R.getString("toys"), "/toys")
    val wallets = Pair(R.getString("wallets"), "/wallets")
    val electronics = Pair(R.getString("electronics"), "/electronics")
    val clothesChildren = arrayOf(mens, ladies, kids)
    val electronicsChildren = arrayOf(phone, tablet, laptop)
}