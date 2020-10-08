package tw.hankli

import java.util.*

class ProductServiceImp : ProductService {

    private val storage = mutableListOf<Product>()

    override fun create(productRequest: ProductRequest): ProductResponse {

        // Handle params from the request
        val id = UUID.randomUUID().toString()
        val name = productRequest.name
        val price = productRequest.price

        // Do something about product
        val product = Product(id, name, price)
        storage.add(product)

        // Return response
        return ProductResponse(id, name, price)
    }

    override fun fetch(productParam: ProductParam): ProductResponse {

        // Handle params from the param
        val id = productParam.productId

        // Do something about product
        val product = storage.find { product -> product.id == id }

        // Return response
        return product?.let { ProductResponse(it.id, it.name, it.price) } ?: ProductResponse("", "", 0.0)
    }

    override fun update(productParam: ProductParam, productRequest: ProductRequest): ProductResponse {

        // Handle params from the param
        val id = productParam.productId

        // Do something about product
        val product = storage.find { product -> product.id == id }
        product?.run {
            this.name = productRequest.name
            this.price = productRequest.price
        }

        // Return response
        return product?.let { ProductResponse(it.id, it.name, it.price) } ?: ProductResponse("", "", 0.0)
    }

    override fun delete(productParam: ProductParam): Boolean {

        // Handle params from the param
        val id = productParam.productId

        // Do something about product
        val product = storage.find { product -> product.id == id }

        // Return response
        return product?.run { storage.remove(this) } ?: false
    }
}