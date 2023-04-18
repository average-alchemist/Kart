package io.aethibo.kart.features.products.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.aethibo.kart.features.products.presentation.ProductsUiState

@Module
@InstallIn(ViewModelComponent::class)
object ProductsModule {

   @Provides
   fun provideInitialProductsUiState(): ProductsUiState = ProductsUiState()
}