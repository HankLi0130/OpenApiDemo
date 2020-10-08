package tw.hankli

import com.papsign.ktor.openapigen.annotations.Path
import com.papsign.ktor.openapigen.annotations.parameters.PathParam

@Path("$PRODUCT/{productId}")
data class ProductParam(
    @PathParam("Product Id") val productId: String
)