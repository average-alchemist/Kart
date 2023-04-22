package io.aethibo.kart.features.product.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.aethibo.kart.core.navigation.ProductDetail
import io.aethibo.kart.features.product.presentation.ProductScreen

fun NavGraphBuilder.productDetailScreen() {
   composable(
      route = ProductDetail.routeWithArgs,
      arguments = ProductDetail.arguments,
      deepLinks = ProductDetail.deepLinks
   ) { navBackStackEntry ->
      val productId = navBackStackEntry.arguments?.getInt(ProductDetail.productIdArg)
      ProductScreen(productId)
   }
}