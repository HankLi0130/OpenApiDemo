package tw.hankli

import com.papsign.ktor.openapigen.OpenAPIGen
import com.papsign.ktor.openapigen.openAPIGen
import com.papsign.ktor.openapigen.route.apiRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {}
    }

    // Configuration
    install(OpenAPIGen) {
        info {
            version = "1.0.0"
            title = "Demo API"
            description = "Ktor using OpenAPI"
            contact {
                name = "HankLi"
                email = "HankLi0130@gmail.com"
            }
        }
        server("http://localhost:8080/") {
            description = "Local server"
        }
    }

    // Regular routing
    routing {
        get("/openapi.json") {
            call.respond(application.openAPIGen.api.serialize())
        }
        get("/") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.json", true)
        }
    }

    val service = ProductServiceImp()

    // OpenAPI routing
    apiRouting {
        this.products(service)
    }
}

