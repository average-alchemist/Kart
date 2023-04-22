package io.aethibo.kart.features.products.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.aethibo.kart.R

@Composable
fun GenericFooter() {
   Column {
      Text(
         modifier = Modifier.padding(16.dp),
         text = stringResource(R.string.list_footer),
         textAlign = TextAlign.Center,
      )
   }
}