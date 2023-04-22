package io.aethibo.kart.features.products.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.aethibo.kart.core.navigation.Products
import io.aethibo.kart.features.products.presentation.ProductsScreen

fun NavGraphBuilder.productsScreen(
   onProductClick: (productId: Int) -> Unit,
   onCommercialItemClick: () -> Unit,
   onCategoryItemClick: (category: String) -> Unit,
) {
   composable(route = Products.route) {
      ProductsScreen(
         onProductClick = onProductClick,
         onCommercialItemClick = onCommercialItemClick,
         onCategoryItemClick = onCategoryItemClick,
      )
   }
}