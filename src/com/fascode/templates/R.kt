package com.fascode.templates

import java.util.*

object R {
    var locale = Locale.JAPANESE
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