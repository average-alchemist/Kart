package io.aethibo.kart.features.products.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.aethibo.kart.R

@Composable
fun CategoryList(onCategoryItemClick: (category: String) -> Unit) {
   val categories = listOf("No filter", "Technology", "Household", "Fashion", "Cooking")
   Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
         Text(
            text = stringResource(R.string.categories),
            style = MaterialTheme.typography.titleMedium
         )
         Text(
            text = stringResource(R.string.view_all),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
         )
      }
      LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
         items(categories) { category ->
            SuggestionChip(
               shape = RoundedCornerShape(12.dp),
               onClick = { onCategoryItemClick(category) }, label = {
                  Text(text = category, modifier = Modifier.padding(horizontal = 8.dp))
               })
         }
      }
   }
}