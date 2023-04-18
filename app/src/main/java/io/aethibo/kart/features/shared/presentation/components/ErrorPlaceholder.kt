package io.aethibo.kart.features.shared.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.aethibo.kart.R
import io.aethibo.kart.core.ui.Error01
import io.aethibo.kart.core.ui.KartTheme

@Composable
fun ErrorPlaceholder(onErrorClick: () -> Unit, modifier: Modifier = Modifier) {
   Column(
      modifier = modifier
         .fillMaxSize()
         .padding(horizontal = 24.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      ErrorContent()
      Spacer(modifier = Modifier.size(24.dp))
      ErrorOptions(onErrorClick)
   }
}

@Composable
fun ErrorContent() {
   Icon(
      painter = painterResource(id = R.drawable.ic_close),
      contentDescription = stringResource(R.string.error_fetching_products),
      tint = Error01
   )
   Spacer(modifier = Modifier.size(16.dp))
   Text(
      text = stringResource(R.string.error_fetching_products),
      textAlign = TextAlign.Center,
   )
}

@Composable
fun ErrorOptions(onErrorClick: () -> Unit) {
   Text(
      text = stringResource(R.string.what_to_do_now),
      style = TextStyle(fontSize = 12.sp)
   )
   Spacer(modifier = Modifier.height(8.dp))
   Button(
      modifier = Modifier,
      onClick = { onErrorClick() },
      colors = ButtonDefaults.buttonColors(containerColor = Error01),
      content = {
         Text(
            text = stringResource(R.string.fetch_products),
            color = Color.White
         )
      },
   )
}

@Preview
@Composable
fun ErrorPlaceholderPreview() {
   KartTheme {
      ErrorPlaceholder(onErrorClick = {})
   }
}