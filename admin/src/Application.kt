package com.cospaii.admin

import com.cospaii.admin.db.*
import com.cospaii.admin.pages.LoginPage
import com.cospaii.templates.R
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm
import io.jsonwebtoken.Jwts
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.html.*
import io.ktor.http.Cookie
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.request.receive
import kotlinx.html.*
import io.ktor.sessions.*
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.date.GMTDate
import io.ktor.util.hex
import io.ktor.util.toLocalDateTime
import io.ktor.util.url
import io.netty.handler.codec.base64.Base64Encoder
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import sun.misc.BASE64Decoder
import sun.misc.BASE64Encoder
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import java.util.Date

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    DbAdmin.init()
    val cospaiiConfig = environment.config.config("cospaii")
    val sessionCookieConfig = cospaiiConfig.config("session.cookie")
    val key: String = sessionCookieConfig.property("key").getString()
    val sessionkey = hex(key)
    val secretAuthKey = hex(sessionCookieConfig.property("secretAuthKey").getString())
    val secretEncryptKey = hex(sessionCookieConfig.property("secretEncryptKey").getString())
    val sessionTransformer = SessionTransportTransformerEncrypt(secretEncryptKey, secretAuthKey)
    install(Sessions) {
        cookie<LoginSession>(LoginSession.sessionName) {
//            cookie.domain = "admin.cospaii.com"
            cookie.path = "/"
//            transform(sessionTransformer)
        }
        cookie<AccessToken>("ACCESS_TOKEN") {
//            cookie.domain = "admin.cospaii.com"
            cookie.path = "/"
            transform(sessionTransformer)
        }
    }
    install(Authentication) {
        form("adminLoginAuth") {
            userParamName = "username"
            passwordParamName = "password"
            challenge = FormAuthChallenge.Redirect{ "Login Failed" }
            validate { userPasswordCredential ->
                transaction {
                    AdminEntity.find {
                        Admins.username.eq(userPasswordCredential.name) and
                                Admins.password.eq(BASE64Encoder().encode(userPasswordCredential.password.toByteArray()))
                    }.takeIf { it.count() > 0 }?.first()
                }
            }
        }
        session<LoginSession>("sessionAuth") {
            challenge = SessionAuthChallenge.Redirect { "/Login" }
            validate {
                val loginSession = sessions.get<LoginSession>()
                // Is AccessToken passed?
                if(loginSession?.access_token?.let {
                    sessionTransformer.transformRead(it)?.equals(loginSession.username)
                } == true) {
                    loginSession
                }else {
                    null
//                    request.cookies["CLIENT_TOKEN"]?.let {
//                        loginSession?.uid?.equals(sessionTransformer.transformRead(it)) ?: false
//                    }?.let {
//                        loginSession
//                    }
                }
            }

        }
    }
    routing {
        get("/Login") {
            call.respondHtmlTemplate(LoginPage()){
            }
        }
        authenticate("sessionAuth") {
            get("/") {
                call.principal<LoginSession>()?.let { loginSession ->
                    val nickname = loginSession.nickname
                    call.respondHtml {
                        body {
                            div {
                                h2 {
                                    +("Hello $nickname")
                                }
                            }
                        }
                    }
                }
            }
        }
        authenticate("adminLoginAuth") {
            post("/LoginCheck") {
                call.principal<AdminEntity>()?.let { adm ->
                    val createTime = DateTime()
                    val serverToken = createTime.millis.toString()
                    val clientToken = BASE64Encoder().encode(serverToken.toByteArray())
                    val accessToken = sessionTransformer.transformWrite(adm.username)

                    transaction {
                        AdminExtras.deleteWhere { AdminExtras.username.eq(adm.username) }
                        AdminExtras.insert {
                            it[username] = adm.username
                            it[create_time] = createTime
                            it[auth_token] = serverToken
                        }
                    }
                    call.response.cookies.appendExpired(name = "CLIENT_TOKEN", path = "/")
                    call.response.cookies.append(Cookie(
                        name = "CLIENT_TOKEN",
                        path = "/",
                        value = clientToken,
                        expires = GMTDate(createTime.plusDays(30).millis))
                    )
                    call.sessions.clear(LoginSession.sessionName)
                    call.sessions.set(LoginSession(
                        uid = adm.id.value,
                        username = adm.username,
                        nickname = adm.nickname,
                        access_token = accessToken)
                    )
                    call.respondRedirect("/")
                } ?: call.respond("Invalid Username or Password!")
            }
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

data class LoginSession(val uid: Int, val username: String, val access_token: String, val nickname: String? ): Principal{
    companion object {
        val sessionName = "LOGIN_SESSION"
    }
}
data class AccessToken(val token: String): Principal{
    companion object {
        val sessionName = "CLIENT_TOKEN"
    }
}