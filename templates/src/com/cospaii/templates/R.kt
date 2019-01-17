package com.cospaii.templates

import java.util.*

object R {
    var locale = Locale.getDefault()
    val invalid_username_or_password: String = "Invalid username or password!"
    val data_input: String = "Data input"
    val create_category: String = "Create new Category"

    private fun getResources() = ResourceBundle.getBundle("strings", locale)
    fun getString(key: String): String {
        try {
            return getResources().getString(key)
        } catch (e: Exception) {
//            e.printStackTrace()
        }
        return key
    }
}