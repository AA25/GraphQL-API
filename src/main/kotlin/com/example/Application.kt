package com.example

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

/**
 * Entry Point of the application. This function is referenced in the resources/application.conf
 *
 * This is essentially the controller
 **/
fun Application.module() {
    routing {
        get("/"){
            call.respondText("Hello World")
        }
        get("/hello"){
            call.respondText("Hello Ktor")
        }
    }
}

