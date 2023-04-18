package io.aethibo.kart.features.shared.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.aethibo.kart.R
import io.aethibo.kart.core.ui.KartTheme

@Composable
fun LoadingPlaceholder(modifier: Modifier = Modifier) {
   Column(
      modifier = modifier
         .fillMaxSize()
         .padding(horizontal = 24.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      CircularProgressIndicator()
      Spacer(modifier = Modifier.height(16.dp))
      Text(
         text = stringResource(R.string.loading_placeholder),
         textAlign = TextAlign.Center,
         style = TextStyle(fontWeight = FontWeight.Light)
      )
   }
}

@Preview
@Composable
fun LoadingPlaceholderPreview() {
   KartTheme {
      LoadingPlaceholder()
   }
}