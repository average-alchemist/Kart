package io.aethibo.kart.features.manageproduct.domain.usecase

import io.aethibo.kart.core.extensions.Result
import io.aethibo.kart.core.extensions.resultOfEither
import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository

fun interface AddProductUseCase : suspend (ProductRequest) -> Result<Product>

suspend fun addProduct(
   product: ProductRequest,
   productsRepository: ProductsRepository
): Result<Product> =
   resultOfEither {
      productsRepository.addProduct(product)
   }