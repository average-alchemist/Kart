package io.aethibo.kart.features.product.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.aethibo.kart.core.ui.KartTheme
import io.aethibo.kart.features.shared.domain.model.Product

@Composable
fun ProductContent(product: Product, modifier: Modifier = Modifier) {
   Column {
      ProductThumbnail(image = product.thumbnail, modifier = modifier)
      ProductDetailContent(
         product.category,
         product.title,
         product.rating,
         product.description,
         modifier = modifier
      )
   }
}

@Preview
@Composable
fun ProductContentScreenPreview() {
   val product = Product(
      brand = "Samsung",
      category = "Smartphones",
      description = "",
      discountPercentage = 0.0,
      id = 1,
      images = listOf("https://images.unsplash.com/photo-1681066471028-dec0c78b729c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1976&q=80"),
      price = 1299,
      rating = 4.2,
      stock = 42,
      thumbnail = "",
      title = "Galaxy S23 Pro Max"
   )
   KartTheme {
      ProductContent(product = product)
   }
}