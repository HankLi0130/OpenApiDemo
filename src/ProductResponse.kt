package tw.hankli

import com.papsign.ktor.openapigen.annotations.Response

@Response("Product Response")
data class ProductResponse(
    var id: String,
    var name: String,
    var price: Double
)