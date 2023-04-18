package io.aethibo.kart.features.products.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aethibo.kart.core.functional.onFailure
import io.aethibo.kart.core.functional.onSuccess
import io.aethibo.kart.features.products.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
   ViewModel() {

   private val _state: MutableStateFlow<ProductsUiState> = MutableStateFlow(ProductsUiState())
   val state: StateFlow<ProductsUiState> = _state.asStateFlow()

   init {
      onIntent(ProductsIntents.GetProducts)
   }

   fun onIntent(intent: ProductsIntents) {
      when (intent) {
         ProductsIntents.GetProducts -> getProducts()
      }
   }

   private fun getProducts() {
      _state.update { oldValue -> oldValue.copy(isLoading = true) }

      viewModelScope.launch {
         getProductsUseCase()
            .onSuccess { products ->
               _state.update { oldValue ->
                  oldValue.copy(
                     isLoading = false,
                     result = products,
                     isError = false
                  )
               }
            }
            .onFailure {
               _state.update { oldValue -> oldValue.copy(isLoading = false, isError = true) }
            }
      }
   }
}