package io.aethibo.kart.features.product.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.aethibo.kart.features.product.presentation.components.ProductContent
import io.aethibo.kart.features.shared.presentation.components.ErrorPlaceholder
import io.aethibo.kart.features.shared.presentation.components.LoadingPlaceholder

@Composable
fun ProductScreen(id: Int?, viewModel: ProductViewModel = hiltViewModel()) {

   val state by viewModel.state.collectAsStateWithLifecycle()

   LaunchedEffect(key1 = id) {
      id?.let { viewModel.onIntent(ProductIntents.GetProductById(id)) }
   }

   ProductScreen(
      state = state,
      onErrorClick = { productId ->
         viewModel.onIntent(ProductIntents.GetProductById(productId))
      }
   )
}

@Composable
fun ProductScreen(
   state: ProductUiState,
   onErrorClick: (Int) -> Unit,
) {
   when {
      state.isLoading -> LoadingPlaceholder()
      state.product != null -> ProductContent(state.product)
      state.isError -> ErrorPlaceholder(onErrorClick = { state.product?.id?.let(onErrorClick) })
   }
}
