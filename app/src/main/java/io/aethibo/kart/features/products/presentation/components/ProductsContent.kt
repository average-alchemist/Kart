package io.aethibo.kart.features.products.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.aethibo.kart.core.ui.KartTheme
import io.aethibo.kart.features.shared.domain.model.Product

@Composable
fun ProductsContent(
   products: List<Product>,
   onProductClick: (productId: Int) -> Unit,
   onCommercialItemClick: () -> Unit,
   onCategoryItemClick: (category: String) -> Unit,
   modifier: Modifier = Modifier
) {
   LazyColumn(
      modifier = modifier.fillMaxSize(),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      content = {
         item { SearchProductItem() }
         item { CommercialItem(onCommercialItemClick = onCommercialItemClick) }
         item { CategoryList(onCategoryItemClick = onCategoryItemClick) }
         items(items = products) { product ->
            ProductItem(product, onProductClick)
         }
         item { GenericFooter() }
      }
   )
}

@Preview
@Composable
fun ProductsContentPreview() {
   val products = listOf(
      Product(
         brand = "Samsung",
         category = "Smartphone",
         description = "Some pretty cool phone",
         discountPercentage = 0.5,
         id = 1,
         images = emptyList(),
         price = 1299,
         rating = 4.3,
         stock = 499,
         thumbnail = "",
         title = "Galaxy S23"
      )
   )
   KartTheme {
      ProductsContent(
         products = products,
         onProductClick = {},
         onCommercialItemClick = {},
         onCategoryItemClick = {})
   }
}