package com.cospaii

import com.cospaii.mysql.DbHelper
import com.cospaii.pages.AccountPage
import com.cospaii.pages.IndexPage
import com.cospaii.pages.ProductPage
import com.cospaii.pages.WishListPage
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.html.respondHtmlTemplate
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.respondRedirect
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.coroutines.launch
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.li
import kotlinx.html.ul

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    launch {

    }
    routing {
        get("/") {
            call.respondHtmlTemplate(IndexPage()){

            }
        }

        get("/MyAccount") {
            call.respondHtmlTemplate(AccountPage()) {

            }
        }

        get("/WishList") {
            call.respondHtmlTemplate(WishListPage()) {

            }
        }

        get("/Product/{Id}") {
            DbHelper.findProductById(call.parameters["Id"])?.let {prod ->
                call.respondHtmlTemplate(ProductPage(prod)) {}
            } ?: call.respondRedirect("/static/404.html")
        }

        get("/Category/{Id}") {

        }
        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        static("/html") {
            resources("static")
        }
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/assets") {
            resources("assets")
        }
    }
}

