package io.aethibo.kart.features.products.domain.usecase

import io.aethibo.kart.core.extensions.Result
import io.aethibo.kart.core.extensions.resultOfEither
import io.aethibo.kart.features.shared.domain.model.Products
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository

fun interface GetProductsUseCase : suspend () -> Result<Products>

suspend fun getProducts(productsRepository: ProductsRepository): Result<Products> =
   resultOfEither {
      productsRepository.getProducts()
   }