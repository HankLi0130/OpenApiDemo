package tw.hankli

import com.papsign.ktor.openapigen.route.info
import com.papsign.ktor.openapigen.route.path.normal.*
import com.papsign.ktor.openapigen.route.response.respond
import com.papsign.ktor.openapigen.route.route

const val PRODUCT = "/product"

fun NormalOpenAPIRoute.products(service: ProductService) {

    route(PRODUCT).post<Unit, ProductResponse, ProductRequest>(
        info("Create Product")
    ) { _, request ->   // parameter, request
        val response = service.create(request)
        respond(response)
    }

    route(PRODUCT).get<ProductParam, ProductResponse>(
        info("Fetch Product")
    ) { param ->
        val response = service.fetch(param)
        respond(response)
    }

    route(PRODUCT).put<ProductParam, ProductResponse, ProductRequest>(
        info("Update Product")
    ) { param, request ->
        val response = service.update(param, request)
        respond(response)
    }

    route(PRODUCT).delete<ProductParam, Boolean>(
        info("Delete Product")
    ) { param ->
        val response = service.delete(param)
        respond(response)
    }
}