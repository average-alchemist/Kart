package io.aethibo.kart.features.product.presentation

import io.aethibo.kart.features.shared.domain.model.Product

data class ProductUiState(
   val isLoading: Boolean = false,
   val product: Product? = null,
   val isError: Boolean = false
)