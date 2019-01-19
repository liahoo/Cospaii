package com.cospaii

import com.cospaii.dao.DbHandler
import com.cospaii.pages.*
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.html.respondHtmlTemplate
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.respondRedirect
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
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
            DbHandler.findProductById(call.parameters["Id"])?.let { prod ->
                call.respondHtmlTemplate(ProductPage(prod)) {}
            } ?: call.respondRedirect("/static/404.html")
        }

        get("/Category/{Id}") {

        }

        get("/Admin") {
            call.respondHtmlTemplate(AdminIndexPage()){

            }
        }

        get("/Admin/Login") {

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

