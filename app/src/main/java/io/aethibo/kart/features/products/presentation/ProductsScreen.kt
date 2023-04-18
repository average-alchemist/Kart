package io.aethibo.kart.features.products.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.aethibo.kart.features.products.presentation.components.ProductsContent
import io.aethibo.kart.features.shared.presentation.components.ErrorPlaceholder
import io.aethibo.kart.features.shared.presentation.components.LoadingPlaceholder

@Composable
fun ProductsScreen(
   viewModel: ProductsViewModel = hiltViewModel(),
   onProductClick: (productId: Int) -> Unit,
   onCommercialItemClick: () -> Unit,
   onCategoryItemClick: (category: String) -> Unit,
) {
   val state by viewModel.state.collectAsStateWithLifecycle()

   ProductsScreen(
      state = state,
      onProductClick = onProductClick,
      onCommercialItemClick = onCommercialItemClick,
      onCategoryItemClick = onCategoryItemClick,
      onErrorClick = {
         viewModel.onIntent(ProductsIntents.GetProducts)
      }
   )
}

@Composable
fun ProductsScreen(
   state: ProductsUiState,
   onProductClick: (Int) -> Unit,
   onCommercialItemClick: () -> Unit,
   onCategoryItemClick: (category: String) -> Unit,
   onErrorClick: () -> Unit,
   modifier: Modifier = Modifier
) {
   when {
      state.isLoading -> LoadingPlaceholder(modifier)
      state.result.products.isNotEmpty() -> {
         ProductsContent(
            products = state.result.products,
            onProductClick = onProductClick,
            modifier = modifier,
            onCommercialItemClick = onCommercialItemClick,
            onCategoryItemClick = onCategoryItemClick
         )
      }

      state.isError -> ErrorPlaceholder(
         modifier = modifier,
         onErrorClick = onErrorClick
      )
   }
}