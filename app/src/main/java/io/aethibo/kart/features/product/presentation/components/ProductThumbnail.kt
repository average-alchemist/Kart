package io.aethibo.kart.features.product.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.aethibo.kart.core.ui.KartTheme

@Composable
fun ProductThumbnail(image:String, modifier: Modifier = Modifier) {
   AsyncImage(
      model = image,
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = modifier
         .fillMaxWidth()
         .height(410.dp)
   )
}

@Preview
@Composable
fun ProductImageSliderPreview() {
   KartTheme {
      ProductThumbnail(image = "https://images.unsplash.com/photo-1681066471028-dec0c78b729c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1976&q=80")
   }
}