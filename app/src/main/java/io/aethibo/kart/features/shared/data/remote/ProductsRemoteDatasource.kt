package io.aethibo.kart.features.shared.data.remote

import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.data.remote.model.response.ProductResponse
import io.aethibo.kart.features.shared.data.remote.model.response.ProductsResponse

interface ProductsRemoteDatasource {
   suspend fun getProducts(): ProductsResponse
   suspend fun getProductById(productId: Int): ProductResponse
   suspend fun addProduct(productRequest: ProductRequest): ProductResponse
   suspend fun updateProductById(productId: Int, productRequest: ProductRequest): ProductResponse
   suspend fun deleteProductById(productId: Int): ProductResponse
}