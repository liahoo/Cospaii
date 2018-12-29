package com.cospaii.views

import com.cospaii.models.TabPane
import com.fascode.templates.SingleProductTemplate
import com.fascode.templates.TabMenuTemplate
import com.fascode.templates.TabPaneTemplate
import io.ktor.html.*
import kotlinx.html.*

class ProductArea: Template<FlowContent>{
    var appTabPanes: Array<TabPane>? = null
    override fun FlowContent.apply() {
        div {
            id="product-area-wrapper"
            div(classes="container") {
                div(classes="row") {
                    div(classes="col-lg-12") {
                        div(classes="product-content-wrap") {
                            nav(classes = "product-teb-menu") {
                                insert(TabMenuTemplate()) {
                                    appTabPanes?.forEach { appTab ->
                                        tab {
                                            if(appTabPanes?.indexOf(appTab) == 0) {
                                                classes = setOf("active")
                                            }
                                            id = appTab.tabId
                                            href = appTab.href
                                            +appTab.name
                                        }
                                    }
                                }
                            }
                            div(classes = "tab-content") {
                                id="productContent"
                                appTabPanes?.forEach { tabPane ->
                                    insert(TabPaneTemplate()) {
                                        isActive = (appTabPanes?.indexOf(tabPane) == 0)
                                        tabPaneId = tabPane.id
                                        products {
                                            tabPane.products?.forEach {prod ->
                                                insert(SingleProductTemplate()) {
                                                    prodTitle {
                                                        href = prod.href
                                                        +(prod.name)
                                                    }
                                                    prodImage {
                                                        src = prod.imgSrc
                                                        alt = prod.name
                                                    }
                                                    prodPrice {
                                                        +prod.price
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
                            }
                        }
                    }
                }
            }
        }
    }
}