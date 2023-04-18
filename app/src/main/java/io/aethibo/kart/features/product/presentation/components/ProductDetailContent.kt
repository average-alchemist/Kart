package io.aethibo.kart.features.product.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.aethibo.kart.core.ui.KartTheme

@Composable
fun ProductDetailContent(
   category: String,
   title: String,
   rating: Double,
   description: String,
   modifier: Modifier = Modifier
) {
   Column(
      modifier = modifier
         .fillMaxWidth()
         .padding(16.dp)
   )
   {
      Text(text = category)
      Text(text = title)
      Text(text = rating.toString())
      Text(text = description)
   }
}

@Preview
@Composable
fun ProductDetailContentPreview() {
   KartTheme {
      ProductDetailContent(
         category = "smartphone",
         title = "Samsung",
         rating = 4.69,
         description = "Something cool",
      )
   }
}