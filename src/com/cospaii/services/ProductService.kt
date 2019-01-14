package com.cospaii.services

import com.cospaii.models.CategoryProducts
import com.cospaii.templates.Linkable
import com.cospaii.models.ProductItem

object ProductService {
    fun getProductsByCategory(categoryName: String): Array<ProductItem> {
        return arrayOf(
            ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
            ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
            ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
            ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
            ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
        )
    }
    fun getCategoryProducts(): Array<CategoryProducts>? {
        return arrayOf(
            CategoryProducts(
                Linkable("Phone", "/Phone", "assets/img/cat-pro-1.jpg", "Category", null), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            )),
            CategoryProducts(
                Linkable("Tablet", "/Tablet", "assets/img/cat-pro-2.jpg", "Category", null), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            )),
            CategoryProducts(
                Linkable("Clothes", "/Clothes", "assets/img/cat-pro-3.jpg", "Category", null), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            )),
            CategoryProducts(
                Linkable(
                    "Electronics",
                    "/Electronics",
                    "assets/img/cat-pro-4.jpg",
                    "Category",
                    null
                ), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            )),
            CategoryProducts(
                Linkable("Bags", "/Bags", "assets/img/cat-pro-5.jpg", "Category", null), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            )),
            CategoryProducts(
                Linkable("Toys", "/Toys", "assets/img/cat-pro-6.jpg", "Category", null), arrayOf(
                ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
            ))
        )
    }
}