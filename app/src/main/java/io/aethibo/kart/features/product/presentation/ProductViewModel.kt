package io.aethibo.kart.features.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.aethibo.kart.core.functional.onFailure
import io.aethibo.kart.core.functional.onSuccess
import io.aethibo.kart.features.product.domain.usecase.DeleteProductByIdUseCase
import io.aethibo.kart.features.product.domain.usecase.GetProductByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
   private val getProductByIdUseCase: GetProductByIdUseCase,
   private val deleteProductByIdUseCase: DeleteProductByIdUseCase
) : ViewModel() {

   private val _state: MutableStateFlow<ProductUiState> = MutableStateFlow(ProductUiState())
   val state: StateFlow<ProductUiState> = _state.asStateFlow()

   fun onIntent(productIntents: ProductIntents) {
      when (productIntents) {
         is ProductIntents.GetProductById -> getProductById(productIntents.id)
         is ProductIntents.DeleteProductById -> deleteProductById(productIntents.id)
      }
   }

   private fun getProductById(id: Int) {
      _state.update { oldValue -> oldValue.copy(isLoading = true, isError = false) }

      viewModelScope.launch {
         getProductByIdUseCase(id)
            .onSuccess { product ->
               _state.update { oldValue ->
                  oldValue.copy(
                     isLoading = false,
                     product = product,
                     isError = false
                  )
               }
            }
            .onFailure {
               _state.update { oldValue ->
                  oldValue.copy(
                     isLoading = false,
                     product = null,
                     isError = true
                  )
               }
            }
      }
   }

   private fun deleteProductById(id: Int) {
      _state.update { oldValue -> oldValue.copy(isLoading = true, isError = false) }

      viewModelScope.launch {
         deleteProductByIdUseCase(id)
            .onSuccess { product ->
               _state.update { oldValue ->
                  oldValue.copy(
                     isLoading = false,
                     product = product,
                     isError = false
                  )
               }
            }
            .onFailure {
               _state.update { oldValue ->
                  oldValue.copy(
                     isLoading = false,
                     product = null,
                     isError = true
                  )
               }
            }
      }
   }
}