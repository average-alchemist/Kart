package io.aethibo.kart.core.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.aethibo.kart.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   @Provides
   @Singleton
   fun provideKtorClient(): HttpClient {
      return HttpClient(Android) {
         defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            url(BuildConfig.DUMMY_API_URL)
            header("X-Custom-Header", "Hello, world!")
         }
         install(HttpTimeout) {
            socketTimeoutMillis = 30_000
            requestTimeoutMillis = 30_000
            connectTimeoutMillis = 30_000
         }
         install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
         }
         install(ContentNegotiation) {
            json(Json {
               prettyPrint = true
               isLenient = true
               ignoreUnknownKeys = true
               encodeDefaults = true
            })
         }
      }
   }
}