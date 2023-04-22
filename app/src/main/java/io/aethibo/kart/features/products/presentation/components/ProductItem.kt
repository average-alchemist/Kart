package io.aethibo.kart.features.products.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.aethibo.kart.core.ui.KartTheme
import io.aethibo.kart.features.shared.domain.model.Product

@Composable
fun ProductItem(product: Product, onProductClick: (Int) -> Unit, modifier: Modifier = Modifier) {
   Card(
      modifier = modifier
         .fillMaxWidth()
         .clickable { onProductClick(product.id) },
   ) {
      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
         horizontalArrangement = Arrangement.spacedBy(16.dp),
         verticalAlignment = Alignment.CenterVertically
      ) {
         Surface(shape = RoundedCornerShape(12.dp), modifier = Modifier.size(100.dp, 100.dp)) {
            AsyncImage(
               contentScale = ContentScale.Crop,
               model = product.thumbnail,
               contentDescription = null,
            )
         }
         Column(
            modifier = Modifier
               .fillMaxWidth()
               .padding(end = 16.dp),
            verticalArrangement = Arrangement.Center
         ) {
            Text(
               text = "${product.category} - ${product.brand}".uppercase(),
               style = MaterialTheme.typography.labelSmall,
               color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
            Text(
               text = product.title,
               style = MaterialTheme.typography.titleLarge,
               maxLines = 1,
               overflow = TextOverflow.Ellipsis
            )
            Text(
               text = "$${product.price}",
               style = MaterialTheme.typography.displaySmall,
               fontWeight = FontWeight.Bold
            )
         }
      }
   }
}

@Preview(name = "Product item")
@Preview(name = "Product item * Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProductItemPreview() {
   val product = Product(
      brand = "Samsung",
      category = "Smartphone",
      description = "Some pretty cool phone",
      discountPercentage = 0.5,
      id = 1,
      images = emptyList(),
      price = 1299,
      rating = 4.3,
      stock = 499,
      thumbnail = "",
      title = "Galaxy S23"
   )
   KartTheme {
      ProductItem(product = product, onProductClick = {})
   }
}