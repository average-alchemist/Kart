package io.aethibo.kart.features.shared.data.repository

import io.aethibo.kart.features.shared.data.mapper.toDomain
import io.aethibo.kart.features.shared.data.remote.api.DummyApiService
import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.model.Products
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val apiService: DummyApiService) :
   ProductsRepository {

   override suspend fun getProducts(): Products {
      return apiService.getProducts().toDomain()
   }

   override suspend fun getProductById(id: Int): Product {
      return apiService.getProductById(id).toDomain()
   }

   override suspend fun addProduct(product: ProductRequest): Product {
      return apiService.addProduct(product).toDomain()
   }

   override suspend fun updateProduct(id: Int, product: ProductRequest): Product {
      return apiService.updateProductById(id, product).toDomain()
   }

   override suspend fun deleteProduct(id: Int): Product {
      return apiService.deleteProductById(id).toDomain()
   }
}