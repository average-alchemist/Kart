package io.aethibo.kart.features.shared.domain.repository

import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.model.Products

interface ProductsRepository {
   suspend fun getProducts(): Products
   suspend fun getProductById(id: Int): Product
   suspend fun addProduct(product: ProductRequest): Product
   suspend fun updateProduct(id: Int, product: ProductRequest): Product
   suspend fun deleteProduct(id: Int): Product
}