package com.cospaii.templates

import java.util.*

object R {
    var locale = Locale.getDefault()
    val invalid_username_or_password: String = "Invalid username or password!"
    val data_input: String = "Data input"
    val create_category: String = "Create new Category"
    val email_or_username: String = "Email or Username"
    val remember_me: String = "Remember me"
    val forget_pwd: String = "Forget Password"
    val login: String = getString("Login")
    val submit: String = getString("Submit")
    val categories: String = getString("Categories")
    val add_category: String = getString("Add Category")
    val admin_console: String = getString("Admin Console")
    val edit: String = getString("Edit")
    val delete: String = getString("Delete")

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