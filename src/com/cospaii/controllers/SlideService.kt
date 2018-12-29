package com.cospaii.controllers

import com.cospaii.models.SlideItem
import com.fascode.templates.R

object SlideService {
    fun getSlideItems(): Array<SlideItem> {
        return arrayOf(
            SlideItem("Title 1", "", "Secondary 1", "Third 1", R.getString("See More"), "#" ),
            SlideItem("Title 2", "slide-item_2", "Secondary 1", "Third 1", R.getString("See More"), "#"),
            SlideItem("Title 3", "slide-item_3", "Secondary 1", "Third 1", R.getString("See More"), "#"),
            SlideItem("Title 4", "slide-item_4", "Secondary 1", "Third 1", R.getString("See More"), "#")
        )
    }
}