package io.aethibo.kart.features.shared.data.remote.api

import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.data.remote.model.response.ProductResponse
import io.aethibo.kart.features.shared.data.remote.model.response.ProductsResponse
import retrofit2.http.*

interface DummyApiService {
   @GET("products")
   suspend fun getProducts(): ProductsResponse

   @GET("products/{id}")
   suspend fun getProductById(@Path("id") productId: Int): ProductResponse

   @POST("products/add")
   suspend fun addProduct(@Body productRequest: ProductRequest): ProductResponse

   @PATCH("products/{id}")
   suspend fun updateProductById(@Path("id") productId: Int, @Body productRequest: ProductRequest): ProductResponse

   @DELETE("products/{id}")
   suspend fun deleteProductById(@Path("id") productId: Int): ProductResponse
}