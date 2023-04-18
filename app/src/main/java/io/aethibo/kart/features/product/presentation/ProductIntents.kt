package io.aethibo.kart.features.product.presentation

sealed interface ProductIntents {
   class GetProductById(val id: Int) : ProductIntents
   class DeleteProductById(val id: Int) : ProductIntents
}