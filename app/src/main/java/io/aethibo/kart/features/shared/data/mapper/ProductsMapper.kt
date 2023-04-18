package io.aethibo.kart.features.shared.data.mapper

import io.aethibo.kart.features.shared.data.remote.model.response.ProductResponse
import io.aethibo.kart.features.shared.data.remote.model.response.ProductsResponse
import io.aethibo.kart.features.shared.domain.model.Product
import io.aethibo.kart.features.shared.domain.model.Products

fun ProductResponse.toDomain(): Product = Product(
   brand = brand,
   category = category,
   description = description,
   discountPercentage = discountPercentage,
   id = id,
   images = images,
   price = price,
   rating = rating,
   stock = stock,
   thumbnail = thumbnail,
   title = title
)

fun ProductsResponse.toDomain(): Products = Products(
   limit = limit,
   products = products.toDomain(),
   skip = skip,
   total = total
)

fun List<ProductResponse>.toDomain(): List<Product> = map { it.toDomain() }