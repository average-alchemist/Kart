package io.aethibo.kart.features.product.domain.usecase

import io.aethibo.kart.core.extensions.Result
import io.aethibo.kart.core.extensions.resultOfEither
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository

fun interface GetProductByIdUseCase : suspend (Int) -> Result<Product>

suspend fun getProductById(
   id: Int,
   productsRepository: ProductsRepository
): Result<Product> =
   resultOfEither {
      productsRepository.getProductById(id)
   }