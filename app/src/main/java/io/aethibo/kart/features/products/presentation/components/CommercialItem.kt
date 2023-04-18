package io.aethibo.kart.features.products.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.aethibo.kart.R

@Composable
fun CommercialItem(onCommercialItemClick: () -> Unit) {
   Box(
      modifier = Modifier
         .fillMaxWidth()
         .height(200.dp)
         .clip(RoundedCornerShape(12.dp)),
   ) {
      AsyncImage(
         model = stringResource(R.string.commercial_placeholder_image),
         contentDescription = null,
         contentScale = ContentScale.FillWidth
      )

      Column(
         modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(24.dp)
      ) {
         Text(
            text = stringResource(R.string.new_collection),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
         )

         Button(onClick = onCommercialItemClick) {
            Text(text = stringResource(R.string.shop_now))
         }
      }
   }
}