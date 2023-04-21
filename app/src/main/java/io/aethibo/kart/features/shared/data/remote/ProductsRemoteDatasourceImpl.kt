package io.aethibo.kart.features.shared.data.remote

import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.data.remote.model.response.ProductResponse
import io.aethibo.kart.features.shared.data.remote.model.response.ProductsResponse
import io.aethibo.kart.features.shared.data.utils.NetworkingRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import javax.inject.Inject

class ProductsRemoteDatasourceImpl @Inject constructor(private val client: HttpClient) :
   ProductsRemoteDatasource {

   override suspend fun getProducts(): ProductsResponse {
      return client.get {
         url { path(NetworkingRoutes.PRODUCTS) }
      }.body()
   }

   override suspend fun getProductById(productId: Int): ProductResponse {
      return client.get {
         url { path(NetworkingRoutes.PRODUCTS, productId.toString()) }
      }.body()
   }

   override suspend fun addProduct(productRequest: ProductRequest): ProductResponse {
      return client.post {
         url { path(NetworkingRoutes.ADD_PRODUCT) }
         setBody(productRequest)
      }.body()
   }

   override suspend fun updateProductById(
      productId: Int,
      productRequest: ProductRequest
   ): ProductResponse {
      return client.patch {
         url { path(NetworkingRoutes.PRODUCTS, productId.toString()) }
         setBody(productRequest)
      }.body()
   }

   override suspend fun deleteProductById(productId: Int): ProductResponse {
      return client.delete {
         url { path(NetworkingRoutes.PRODUCTS, productId.toString()) }
      }.body()
   }
}