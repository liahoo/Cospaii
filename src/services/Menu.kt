package com.cospaii.services

import com.cospaii.models.MenuItem
import com.cospaii.templates.R

object Menu {
    val email = ""
    val langSelected : String = "English"
    val langs: Array<String> = arrayOf("English", "日本語", "中文")
    val currencySelected: String = "USD"
    val currencies: Array<String> = arrayOf("USD", "JPY", "RMB")
    val categories = arrayOf(
        MenuItem(
            R.getString("PC"), "/pc", null, arrayOf(
            MenuItem(
                R.getString("Note PC"), "/pc/note", null, arrayOf(
                MenuItem(R.getString("Note PC"), "/pc/note/cables"),
                MenuItem(R.getString("Cables"), "/pc/note/cables"),
                MenuItem(R.getString("Power"), "/pc/note/cpu"),
                MenuItem(R.getString("Sticker"), "/pc/note/cpu"),
                MenuItem(R.getString("All"), "/pc/note/all")
                )),
            MenuItem(
                R.getString("Desktop"), "/pc/desktop", null, arrayOf(
                MenuItem(R.getString("CPU"), "/pc/desktop/cpu"),
                MenuItem(R.getString("SSD"), "/pc/desktop/ssd"),
                MenuItem(R.getString("Mouse"), "/pc/desktop/mouse"),
                MenuItem(R.getString("Keyboard"), "/pc/desktop/mouse"),
                MenuItem(R.getString("All"), "/pc/desktop/parts")
            )),
            MenuItem(
                R.getString("Tablet"), "/pc/Tablet", null, arrayOf(
                MenuItem(R.getString("Android"), "/pc/Tablet/android"),
                MenuItem(R.getString("Windows"), "/pc/Tablet/windows"),
                MenuItem(R.getString("Cases"), "/pc/Tablet/cases"),
                MenuItem(R.getString("Keyboard"), "/pc/Tablet/keyboard"),
                MenuItem(R.getString("All"), "/pc/Tablet")
            )))
        ),
        MenuItem(
            R.getString("Clothes"), "/Clothes", null, arrayOf(
            MenuItem(
                R.getString("Mens"), "/Clothes/Mens", null, arrayOf(
                MenuItem(R.getString("Jacket"), "/Clothes/Mens/jacket"),
                MenuItem(R.getString("Pajama"), "/Clothes/Mens/pajama"),
                MenuItem(R.getString("Trousers"), "/Clothes/Mens/trousers"),
                MenuItem(R.getString("Shirt"), "/Clothes/Mens/shirt"),
                MenuItem(R.getString("All"), "/Clothes/Mens")
            )),
            MenuItem(
                R.getString("Ladies"), "/Clothes/Ladies", null, arrayOf(
                MenuItem(R.getString("Jacket"), "/Clothes/Ladies/jacket"),
                MenuItem(R.getString("Pajama"), "/Clothes/Ladies/pajama"),
                MenuItem(R.getString("Trousers"), "/Clothes/Ladies/trousers"),
                MenuItem(R.getString("Shirt"), "/Clothes/Ladies/shirt"),
                MenuItem(R.getString("All"), "/Clothes/Ladies/")
            )),
            MenuItem(
                R.getString("Kids"), "/Clothes/Kids", null, arrayOf(
                MenuItem(R.getString("Jacket"), "/Clothes/Kids/jacket"),
                MenuItem(R.getString("Pajama"), "/Clothes/Kids/pajama"),
                MenuItem(R.getString("Trousers"), "/Clothes/Kids/trousers"),
                MenuItem(R.getString("Shirt"), "/Clothes/Kids/shirt"),
                MenuItem(R.getString("All"), "/Clothes/Kids/")
            )))
        ),
        MenuItem(R.getString("Headset"), "/headset"),
        MenuItem(R.getString("Toys"), "/Toys"),
        MenuItem(R.getString("Garden"), "/garden"),
        MenuItem(R.getString("Office"), "/garden")
    )
    val mainMenu = arrayOf(
        MenuItem(R.getString("Home"), "/"),
        MenuItem(
            R.getString("On Sale"), "/Sale", null, arrayOf(
            MenuItem(
                R.getString("Electronics"), "/Hot/Electronics/", null, arrayOf(
                MenuItem(R.getString("Phone"), "/pc/note/cables"),
                MenuItem(R.getString("Tablet"), "/pc/note/cables"),
                MenuItem(R.getString("Power"), "/pc/note/cpu"),
                MenuItem(R.getString("SSD"), "/pc/note/cpu")
            )),
            MenuItem(
                R.getString("Clothes"), "/Popular/Clothes/", null, arrayOf(
                MenuItem(R.getString("Mens"), "/Popular/Clothes/Mens"),
                MenuItem(R.getString("Ladies"), "/Popular/Clothes/Ladies"),
                MenuItem(R.getString("Kids"), "/Popular/Clothes/Kids"),
                MenuItem(R.getString("Others"), "/Popular/Clothes/Others")
            ))
        )),
        MenuItem(
            R.getString("New Products"), "/Sale", null, arrayOf(
            MenuItem(
                R.getString("Electronics"), "/Hot/Electronics/", null, arrayOf(
                MenuItem(R.getString("Phone"), "/Hot/Electronics/Phone"),
                MenuItem(R.getString("Tablet"), "/Hot/Electronics/Tablet"),
                MenuItem(R.getString("Laptop"), "/Hot/Electronics/Power"),
                MenuItem(R.getString("Other"), "/Hot/Electronics/Other")
            )),
            MenuItem(
                R.getString("Clothes"), "/Popular/Clothes/", null, arrayOf(
                MenuItem(R.getString("Mens"), "/Popular/Clothes/Mens"),
                MenuItem(R.getString("Ladies"), "/Popular/Clothes/Ladies"),
                MenuItem(R.getString("Kids"), "/Popular/Clothes/Kids"),
                MenuItem(R.getString("Others"), "/Popular/Clothes/Others")
            )))
        ),
        MenuItem(
            R.getString("Hot Products"), "/Hot", null, arrayOf(
            MenuItem(
                R.getString("Electronics"), "/Hot/Electronics/", null, arrayOf(
                MenuItem(R.getString("Phone"), "/Hot/Electronics/Phone"),
                MenuItem(R.getString("Tablet"), "/Hot/Electronics/Tablet"),
                MenuItem(R.getString("Laptop"), "/Hot/Electronics/Power"),
                MenuItem(R.getString("Other"), "/Hot/Electronics/Other")
            )),
            MenuItem(
                R.getString("Clothes"), "/Popular/Clothes/", null, arrayOf(
                MenuItem(R.getString("Mens"), "/Popular/Clothes/Mens"),
                MenuItem(R.getString("Ladies"), "/Popular/Clothes/Ladies"),
                MenuItem(R.getString("Kids"), "/Popular/Clothes/Kids"),
                MenuItem(R.getString("Others"), "/Popular/Clothes/Others")
            )))
        ),
        MenuItem(R.getString("About US"), "/about")
    )
}