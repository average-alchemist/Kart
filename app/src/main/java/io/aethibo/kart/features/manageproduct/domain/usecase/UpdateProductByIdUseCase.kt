package io.aethibo.kart.features.manageproduct.domain.usecase

import io.aethibo.kart.core.extensions.Result
import io.aethibo.kart.core.extensions.resultOfEither
import io.aethibo.kart.features.shared.data.remote.model.request.ProductRequest
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository

fun interface UpdateProductByIdUseCase : suspend (Int, ProductRequest) -> Result<Product>

suspend fun updateProductById(
   id: Int,
   product: ProductRequest,
   productsRepository: ProductsRepository
): Result<Product> =
   resultOfEither {
      productsRepository.updateProduct(id, product)
   }