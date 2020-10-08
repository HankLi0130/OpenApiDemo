package tw.hankli

interface ProductService {

    fun create(productRequest: ProductRequest): ProductResponse

    fun fetch(productParam: ProductParam): ProductResponse

    fun update(productParam: ProductParam, productRequest: ProductRequest): ProductResponse

    fun delete(productParam: ProductParam): Boolean
}