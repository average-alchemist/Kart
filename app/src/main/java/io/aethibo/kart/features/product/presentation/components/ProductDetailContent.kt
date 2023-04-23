package io.aethibo.kart.features.product.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.aethibo.kart.R
import io.aethibo.kart.core.ui.KartTheme

@Composable
fun ProductDetailContent(
   category: String,
   title: String,
   rating: Double,
   description: String,
   price: String,
   modifier: Modifier = Modifier,
   onAddToCartClick: () -> Unit,
) {
   Column(
      modifier = modifier
         .fillMaxWidth()
         .padding(16.dp),
   )
   {
      Text(
         text = category.uppercase(),
         color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
         fontSize = 13.sp,
      )
      Text(text = title, fontSize = 32.sp, fontWeight = FontWeight.Bold)
      Text(
         text = stringResource(R.string.current_user_rating, rating.toString()),
         fontStyle = FontStyle.Italic,
         fontSize = 13.sp,
      )
      Spacer(modifier = Modifier.height(16.dp))
      Text(
         text = description,
         color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
      )
      Spacer(modifier = Modifier.weight(1f))
      Row(
         modifier = Modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically
      ) {
         Column(horizontalAlignment = Alignment.Start) {
            Text(
               text = stringResource(R.string.total_price),
               color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(text = "$$price", fontSize = 32.sp, fontWeight = FontWeight.Bold)
         }
         Button(onClick = onAddToCartClick) {
            Text(text = stringResource(R.string.add_to_cart))
         }
      }
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
         description = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum blandit rutrum gravida. Nulla maximus eleifend eros, vitae viverra sem bibendum eu. Praesent eu ultrices ex. Mauris venenatis nunc non vestibulum mattis.
         """.trimIndent(),
         price = "$1299",
         onAddToCartClick = {},
      )
   }
}