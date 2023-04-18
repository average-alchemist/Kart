package io.aethibo.kart.features.products.presentation

import io.aethibo.kart.features.shared.domain.model.Products

data class ProductsUiState(
   val isLoading: Boolean = false,
   val result: Products = Products(),
   val isError: Boolean = false
)
