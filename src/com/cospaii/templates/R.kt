package com.cospaii.templates

import java.util.*

object R {
    var locale = Locale.getDefault()
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