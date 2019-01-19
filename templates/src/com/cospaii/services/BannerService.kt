package com.cospaii.services

import com.cospaii.models.Linkable

object BannerService {
    enum class CategoryBannerPlace {
        Left,
        MidTopLeft,
        MidTopRight,
        MidBottom,
        Right
    }
    fun getBannerForIndexOne(): Linkable? {
        return Linkable("Banner", "shop.html", "assets/img/banner-home-one.jpg")
    }
    fun getCategoryBanners(): Map<CategoryBannerPlace, Linkable>? {
        return mapOf(
            CategoryBannerPlace.Left to Linkable(
                href = "single-product-sale.html",
                imgSrc = "assets/img/banner-masonry-1.jpg",
                imgAlt = "Banner"
            ),
            CategoryBannerPlace.MidTopLeft to Linkable(
                href = "single-product-sale.html",
                imgSrc = "assets/img/banner-masonry-2.jpg",
                imgAlt = "Banner"
            ),
            CategoryBannerPlace.MidTopRight to Linkable(
                href = "single-product-sale.html",
                imgSrc = "assets/img/banner-masonry-3.jpg",
                imgAlt = "Banner"
            ),
            CategoryBannerPlace.MidBottom to Linkable(
                href = "single-product-sale.html",
                imgSrc = "assets/img/banner-masonry-4.jpg",
                imgAlt = "Banner"
            ),
            CategoryBannerPlace.Right to Linkable(
                href = "single-product-sale.html",
                imgSrc = "assets/img/banner-masonry-5.jpg",
                imgAlt = "Banner"
            )
        )
    }
    fun getBannersForFooter(): Array<Linkable>? {
        return arrayOf(
            Linkable(href = "#", imgSrc = "assets/img/logo-1.png"),
            Linkable(href = "#", imgSrc = "assets/img/logo-2.png"),
            Linkable(href = "#", imgSrc = "assets/img/logo-3.png"),
            Linkable(href = "#", imgSrc = "assets/img/logo-4.png"),
            Linkable(href = "#", imgSrc = "assets/img/logo-5.png"),
            Linkable(href = "#", imgSrc = "assets/img/logo-6.png")
        )
    }
}