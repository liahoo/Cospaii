package com.fascode.templates

import io.ktor.html.Template
import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script

class HeadTemplate: Template<HEAD> {
    override fun HEAD.apply() {
        meta(charset = "charset")
        meta {
            httpEquiv = "X-UA-Compatible"
        }
        meta(name = "viewport", content = "width=device-width, initial-scale=1")
        meta(name = "description", content = "meta description")
        link(rel = "shortcut icon", href = "assets/img/favicon.ico", type = "image/x-icon")
        link(rel = "stylesheet", href = "https://fonts.googleapis.com/css?family=Poppins:300,400,400i,500,600,700")
        link(rel = "stylesheet", href = "assets/css/vendor/bootstrap.min.css")
        link(rel = "stylesheet", href = "assets/css/vendor/font-awesome.css")
        link(rel = "stylesheet", href = "assets/css/plugins.css")
        link(rel = "stylesheet", href = "assets/css/style.css")
        script(src = "assets/js/vendor/modernizr-2.8.3.min.js"){}
        script(src = "http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"){}
        script(src = "http://oss.maxcdn.com/respond/1.4.2/respond.min.js"){}
        script(src = "assets/js/vendor/jquery-3.3.1.min.js"){}
        script(src = "assets/js/vendor/jquery-migrate-1.4.1.min.js"){}
        script(src = "assets/js/vendor/popper.min.js"){}
        script(src = "assets/js/vendor/bootstrap.min.js"){}
        script(src = "assets/js/ajax-mail.js"){}
        script(src = "assets/js/plugins.js"){}
        script(src = "assets/js/active.js"){}
    }
}