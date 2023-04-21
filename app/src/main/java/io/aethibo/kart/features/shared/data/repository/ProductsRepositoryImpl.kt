package io.aethibo.kart.features.shared.data.repository

import io.aethibo.kart.features.shared.data.mapper.toDomain
import io.aethibo.kart.features.shared.data.remote.ProductsRemoteDatasource
import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.model.Products
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
   private val productsRemoteDatasource: ProductsRemoteDatasource,
) : ProductsRepository {

   override suspend fun getProducts(): Products {
      return productsRemoteDatasource.getProducts().toDomain()
   }

   override suspend fun getProductById(id: Int): Product {
      return productsRemoteDatasource.getProductById(id).toDomain()
   }

   override suspend fun addProduct(product: ProductRequest): Product {
      return productsRemoteDatasource.addProduct(product).toDomain()
   }

   override suspend fun updateProduct(id: Int, product: ProductRequest): Product {
      return productsRemoteDatasource.updateProductById(id, product).toDomain()
   }

   override suspend fun deleteProduct(id: Int): Product {
      return productsRemoteDatasource.deleteProductById(id).toDomain()
   }
}