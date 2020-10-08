package tw.hankli

import com.papsign.ktor.openapigen.annotations.Request

@Request("Product Request")
data class ProductRequest(
    val name: String,
    val price: Double
)