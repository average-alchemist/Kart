package io.aethibo.kart.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.aethibo.kart.features.product.presentation.navigation.productDetailScreen
import io.aethibo.kart.features.products.presentation.navigation.productsScreen

@Composable
fun KartNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
   NavHost(
      navController = navController,
      startDestination = Products.route,
      modifier = modifier
   ) {
      productsScreen(
         onProductClick = { productId -> navController.navigate("${ProductDetail.route}/$productId") },
         onCommercialItemClick = {},
         onCategoryItemClick = { category -> }
      )
      productDetailScreen()
   }
}