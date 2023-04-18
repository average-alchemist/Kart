package io.aethibo.kart.features.products.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import io.aethibo.kart.R

@Composable
fun SearchProductItem() {
   var searchFieldText by remember { mutableStateOf(TextFieldValue("")) }

   OutlinedTextField(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(12.dp),
      leadingIcon = {
         Icon(
            painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(R.string.search_content_description)
         )
      },
      value = searchFieldText,
      label = { Text(text = stringResource(R.string.search_for_product)) },
      onValueChange = { searchFieldText = it }
   )
}