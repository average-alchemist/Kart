package io.aethibo.kart.features.shared.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aethibo.kart.features.manageproduct.domain.usecase.AddProductUseCase
import io.aethibo.kart.features.manageproduct.domain.usecase.UpdateProductByIdUseCase
import io.aethibo.kart.features.manageproduct.domain.usecase.addProduct
import io.aethibo.kart.features.manageproduct.domain.usecase.updateProductById
import io.aethibo.kart.features.product.domain.usecase.DeleteProductByIdUseCase
import io.aethibo.kart.features.product.domain.usecase.GetProductByIdUseCase
import io.aethibo.kart.features.product.domain.usecase.deleteProductById
import io.aethibo.kart.features.product.domain.usecase.getProductById
import io.aethibo.kart.features.products.domain.usecase.GetProductsUseCase
import io.aethibo.kart.features.products.domain.usecase.getProducts
import io.aethibo.kart.features.shared.data.remote.api.DummyApiService
import io.aethibo.kart.features.shared.data.repository.ProductsRepositoryImpl
import io.aethibo.kart.features.shared.domain.repository.ProductsRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [ProductsModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object ProductsModule {

   @Provides
   @Singleton
   fun provideProductsApi(retrofit: Retrofit): DummyApiService {
      return retrofit.create(DummyApiService::class.java)
   }

   @Provides
   fun provideGetProductsUseCase(productsRepository: ProductsRepository): GetProductsUseCase {
      return GetProductsUseCase {
         getProducts(productsRepository)
      }
   }

   @Provides
   fun provideGetProductByIdUseCase(productsRepository: ProductsRepository): GetProductByIdUseCase {
      return GetProductByIdUseCase { productId ->
         getProductById(productId, productsRepository)
      }
   }

   @Provides
   fun provideAddProductUseCase(productsRepository: ProductsRepository): AddProductUseCase {
      return AddProductUseCase { product ->
         addProduct(product, productsRepository)
      }
   }

   @Provides
   fun provideUpdateProductByIdUseCase(productsRepository: ProductsRepository): UpdateProductByIdUseCase {
      return UpdateProductByIdUseCase { productId, product ->
         updateProductById(productId, product, productsRepository)
      }
   }

   @Provides
   fun provideDeleteProductByIdUseCase(productsRepository: ProductsRepository): DeleteProductByIdUseCase {
      return DeleteProductByIdUseCase { productId ->
         deleteProductById(productId, productsRepository)
      }
   }

   @Module
   @InstallIn(SingletonComponent::class)
   interface BindsModule {

      @Binds
      @Singleton
      fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
   }
}