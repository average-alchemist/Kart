package io.aethibo.kart.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aethibo.kart.BuildConfig
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
   private const val INTERCEPTOR_LOGGING_NAME = "INTERCEPTOR_LOGGING"

   @Provides
   @Named(INTERCEPTOR_LOGGING_NAME)
   fun provideHttpLoggingInterceptor(): Interceptor {
      return if (BuildConfig.DEBUG) {
         HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
         }
      } else {
         noOpInterceptor()
      }
   }

   private fun noOpInterceptor(): Interceptor {
      return Interceptor { chain ->
         var request = chain.request()
         request = request.newBuilder()
            .addHeader("test-header", "Hello, world!")
            .build()

         chain.proceed(request)
      }
   }

   @Provides
   @Singleton
   fun provideOkHttpClient(
      @Named(INTERCEPTOR_LOGGING_NAME) loggingInterceptor: Interceptor
   ): OkHttpClient {
      return OkHttpClient
         .Builder()
         .apply {
            addNetworkInterceptor(loggingInterceptor)
         }
         .build()
   }

   @OptIn(ExperimentalSerializationApi::class)
   @Provides
   @Singleton
   fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
      val json = Json {
         ignoreUnknownKeys = true
         coerceInputValues = true
      }
      val contentType = "application/json".toMediaType()

      return Retrofit
         .Builder()
         .addConverterFactory(json.asConverterFactory(contentType))
         .baseUrl(BuildConfig.DUMMY_API_URL)
         .client(okHttpClient)
         .build()
   }
}