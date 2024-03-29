/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package http.api

import http.routes.registerCustomerRoutes
import http.routes.registerOrderRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)



fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }

    registerCustomerRoutes()
    registerOrderRoutes()
}