package io.aethibo.kart.core.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

/**
 * Contract for information needed on every Kart navigation destination
 */
interface KartDestination {
   val route: String
}

object Products : KartDestination {
   override val route: String = "products_route"
}

object ProductDetail : KartDestination {
   override val route: String = "product_detail_route"
   const val productIdArg = "product_id"
   val routeWithArgs = "${route}/{${productIdArg}}"
   val arguments = listOf(
      navArgument(productIdArg) { type = NavType.IntType }
   )
   val deepLinks = listOf(
      navDeepLink { uriPattern = "kart://$route/{$productIdArg}" }
   )
}