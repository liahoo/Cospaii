package com.cospaii.controllers

import com.cospaii.models.MenuCategory
import com.fascode.templates.R

object MenuController {
    val email = ""
    val langSelected : String = "English"
    val langs: Array<String> = arrayOf("English", "日本語", "中文")
    val currencySelected: String = "USD"
    val currencies: Array<String> = arrayOf("USD", "JPY", "RMB")
    val categories = arrayOf(
        MenuCategory(R.getString("pc"), "/pc", null, arrayOf(
            MenuCategory(R.getString("note_pc"), "/pc/note", null, arrayOf(
                MenuCategory(R.getString("Note PC"), "/pc/note/cables"),
                MenuCategory(R.getString("Cables"), "/pc/note/cables"),
                MenuCategory(R.getString("Power"), "/pc/note/cpu"),
                MenuCategory(R.getString("Sticker"), "/pc/note/cpu"),
                MenuCategory(R.getString("All"), "/pc/note/all")
                )),
            MenuCategory(R.getString("desktop_pc"), "/pc/desktop", null, arrayOf(
                MenuCategory(R.getString("CPU"), "/pc/desktop/cpu"),
                MenuCategory(R.getString("SSD"), "/pc/desktop/ssd"),
                MenuCategory(R.getString("Mouse"), "/pc/desktop/mouse"),
                MenuCategory(R.getString("Keyboard"), "/pc/desktop/mouse"),
                MenuCategory(R.getString("All"), "/pc/desktop/parts")
            )),
            MenuCategory(R.getString("tablet"), "/pc/tablet", null, arrayOf(
                MenuCategory(R.getString("Android"), "/pc/tablet/android"),
                MenuCategory(R.getString("Windows"), "/pc/tablet/windows"),
                MenuCategory(R.getString("Cases"), "/pc/tablet/cases"),
                MenuCategory(R.getString("Keyboard"), "/pc/tablet/keyboard"),
                MenuCategory(R.getString("All"), "/pc/tablet")
            )))
        ),
        MenuCategory(R.getString("Clothes"), "/clothes", null, arrayOf(
            MenuCategory(R.getString("Mens"), "/clothes/mens", null, arrayOf(
                MenuCategory(R.getString("Jacket"), "/clothes/mens/jacket"),
                MenuCategory(R.getString("Pajama"), "/clothes/mens/pajama"),
                MenuCategory(R.getString("Trousers"), "/clothes/mens/trousers"),
                MenuCategory(R.getString("Shirt"), "/clothes/mens/shirt"),
                MenuCategory(R.getString("All"), "/clothes/mens")
            )),
            MenuCategory(R.getString("Ladies"), "/clothes/ladies", null, arrayOf(
                MenuCategory(R.getString("Jacket"), "/clothes/ladies/jacket"),
                MenuCategory(R.getString("Pajama"), "/clothes/ladies/pajama"),
                MenuCategory(R.getString("Trousers"), "/clothes/ladies/trousers"),
                MenuCategory(R.getString("Shirt"), "/clothes/ladies/shirt"),
                MenuCategory(R.getString("All"), "/clothes/ladies/")
            )),
            MenuCategory(R.getString("Kids"), "/clothes/kids", null, arrayOf(
                MenuCategory(R.getString("Jacket"), "/clothes/kids/jacket"),
                MenuCategory(R.getString("Pajama"), "/clothes/kids/pajama"),
                MenuCategory(R.getString("Trousers"), "/clothes/kids/trousers"),
                MenuCategory(R.getString("Shirt"), "/clothes/kids/shirt"),
                MenuCategory(R.getString("All"), "/clothes/kids/")
            )))
        ),
        MenuCategory(R.getString("Headset"), "/headset"),
        MenuCategory(R.getString("Toys"), "/toys"),
        MenuCategory(R.getString("Garden"), "/garden"),
        MenuCategory(R.getString("Office"), "/garden")
    )
}