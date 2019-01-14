package com.cospaii.services

import com.cospaii.models.ProductItem
import com.cospaii.models.TabPane

object TabService {
    fun getTabPanes(): Array<TabPane> {
        return arrayOf(
            TabPane(
                "new-products", "new-product-tab", "New", arrayOf(
                    ProductItem("Samsung 1", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                    ProductItem("Samsung 2", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                    ProductItem("Samsung 3", "$19.99", "4.6", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                    ProductItem("Samsung 4", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                    ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-5.jpg")
                )
            ),
            TabPane(
                "sales-products", "sales-product-tab", "Sales", arrayOf(
                    ProductItem("Huawei Mate20", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-1.jpg"),
                    ProductItem("Honor 8X Max", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-3.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-6.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-5.jpg"),
                    ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-4.jpg")
                )
            ),
            TabPane(
                "time-sales", "time-sale", "Time sale", arrayOf(
                    ProductItem("Huawei Mate20", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                    ProductItem("Honor 8X Max", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-6.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-5.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-3.jpg")
                )
            ),
            TabPane(
                "hot-products", "hot-product-tab", "Hot Product", arrayOf(
                    ProductItem("Huawei Mate20", "$69.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-5.jpg"),
                    ProductItem("Honor 8X Max", "$29.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-4.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-6.jpg"),
                    ProductItem("Huawei Mate20", "$19.99", "4.7", "/phone/huawei-mate20/", "assets/img/product-2.jpg"),
                    ProductItem("Samsung 5", "$19.99", "4.8", "/phone/huawei-mate20/", "assets/img/product-1.jpg")
                )
            )
        )
    }
}