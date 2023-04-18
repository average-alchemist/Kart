package io.aethibo.kart.features.product.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.aethibo.kart.features.product.presentation.ProductUiState

@Module
@InstallIn(ViewModelComponent::class)
object ProductModule {

   @Provides
   fun provideInitialProductUiState(): ProductUiState = ProductUiState()
}