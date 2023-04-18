package io.aethibo.kart.features.shared.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
   @SerialName("limit")
   val limit: Int,
   @SerialName("products")
   val products: List<ProductResponse>,
   @SerialName("skip")
   val skip: Int,
   @SerialName("total")
   val total: Int
)