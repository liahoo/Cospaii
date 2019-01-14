package com.cospaii.pages

import com.cospaii.area.*
import com.cospaii.services.*
import com.cospaii.templates.CategoryBannersTemplate
import com.cospaii.templates.HeadTemplate
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*
import com.cospaii.services.BannerService.CategoryBannerPlace.*
import com.cospaii.services.BannerService

class IndexPage: Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +"Home" }
            insert(HeadTemplate()) {}
        }
        body {
            insert(HeaderArea()){}
            insert(SlideArea()){
                slideItems = SlideService.getSlideItems()
            }
            insert(ProductArea()) {
                appTabPanes = TabService.getTabPanes()
            }
            BannerService.getBannerForIndexOne()?.let {
                insert(BannerArea()) {
                    imageAlt = it.name
                    imageSrc = it.imgSrc
                    linkTo = it.href
                }
            }

            insert(ProductsByCategoryArea()){
                ProductService.getCategoryProducts()?.forEach {catProds ->
                    productsByCategory {
                        linkCategary {
                            linkable = catProds.category
                        }
                        catProds.products?.forEach { prod ->
                            eachProduct {
                                prodPrice {
                                    +prod.price
                                }
                                prodTitle {
                                    href = prod.href
                                    +prod.name
                                }
                                prodImage {
                                    src = prod.imgSrc
                                }
                                prodRating {
                                    score {
                                        +prod.score
                                    }
                                }
                            }
                        }
                    }
                }
            }
            insert(CategoryBannersTemplate()) {
                BannerService.getCategoryBanners()?.forEach { key, banner ->
                    when(key) {
                        Left -> bannerLeft { linkable = banner }
                        Right -> bannerRight { linkable = banner }
                        MidTopLeft -> bannerMidTopLeft { linkable = banner }
                        MidTopRight -> bannerMidTopRight { linkable = banner }
                        MidBottom -> bannerMidBottom { linkable = banner }
                    }
                }
            }
            insert(PopularCategoriesArea()) {
                category = CategoryService.getPopularCategories()
            }
            insert(FooterArea()){

            }
        }
    }
}