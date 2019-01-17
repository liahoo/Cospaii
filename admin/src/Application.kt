package com.cospaii.admin

import com.cospaii.admin.db.*
import com.cospaii.admin.pages.DataEditPage
import com.cospaii.admin.pages.LoginPage
import com.cospaii.templates.R
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.html.*
import io.ktor.http.Cookie
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.request.uri
import kotlinx.html.*
import io.ktor.sessions.*
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.date.GMTDate
import io.ktor.util.hex
import io.ktor.util.url
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import sun.misc.BASE64Encoder
import java.net.URLDecoder
import java.net.URLEncoder

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
        cookie<ClientToken>(ClientToken.sessionName) {
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
            challenge = SessionAuthChallenge.Redirect { "/Login?cb=${URLEncoder.encode(request.uri.toString(), "UTF-8")}" }
            validate {
                val loginSession = sessions.get<LoginSession>()
                // Is ClientToken passed?
                loginSession?.access_token?.let {
                    sessionTransformer.transformRead(it)?.split(",")?.takeIf {it.size >= 2}?.let {
                        try {
                            AuthenticatedUser(it[0].toInt(), it[1], it[2].toInt(), loginSession.nickname)
                        }catch (e: NumberFormatException){
                            null
                        }
                    }
                }
            }

        }
    }
    routing {
        get("/Login") {
            call.respondHtmlTemplate(LoginPage()){
                if(call.request.queryParameters["err"] == "1")
                textError = R.getString(R.invalid_username_or_password)
            }
        }
        authenticate("sessionAuth") {
            get("/") {
                call.principal<AuthenticatedUser>()?.let { user ->
                    val nickname = user.nickname
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
            get("/Category") {
                call.principal<AuthenticatedUser>()?.let { user ->
                    val nickname = user.nickname
                    call.respondHtmlTemplate(DataEditPage()) {
                        textTitle = R.getString(R.create_category)
                    }
                }
            }
            post("/Category"){

            }
        }
        authenticate("adminLoginAuth") {
            post("/LoginCheck") {
                call.principal<AdminEntity>()?.let { adm ->
                    val now = DateTime()
                    val accessToken = sessionTransformer.transformWrite(adm.id.toString() + "," + adm.username + "," + adm.role.toString())
                    transaction {
                        AdminExtras.deleteWhere { AdminExtras.username.eq(adm.username) }
                        AdminExtras.insert {entry->
                            entry[username] = adm.username
                            entry[login_time] = now
                        }
                    }
                    // Write session to cookie for this time login
                    call.sessions.clear(LoginSession.sessionName)
                    call.sessions.set(LoginSession(
                        nickname = adm.nickname,
                        access_token = accessToken)
                    )
                    call.parameters["cache_days"]?.toInt()?.takeIf { it > 0 }?.let {cache_days ->
                        val clientToken = sessionTransformer.transformWrite(now.millis.toString())
                        call.response.cookies.appendExpired(name = "CLIENT_TOKEN", path = "/")
                        call.response.cookies.append(Cookie(
                            name = "CLIENT_TOKEN",
                            path = "/",
                            value = clientToken,
                            expires = GMTDate(now.plusDays(cache_days).millis))
                        )
                    }
                    call.respondRedirect(URLDecoder.decode(call.parameters["cb"] ?: "/", "UTF-8"))
                } ?: call.respondRedirect(call.request.uri + "?err=1")
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
data class AuthenticatedUser(val uid: Int, val username: String, val role: Int, val nickname: String?): Principal

data class LoginSession(val access_token: String, val nickname: String? ): Principal{
    companion object {
        val sessionName = "LOGIN_SESSION"
    }
}
data class ClientToken(val token: String): Principal{
    companion object {
        val sessionName = "CLIENT_TOKEN"
    }
}