package io.aethibo.kart.features.product.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.aethibo.kart.R
import io.aethibo.kart.core.ui.KartTheme
import io.aethibo.kart.features.shared.presentation.components.DotsIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductThumbnail(images: List<String>, modifier: Modifier = Modifier) {
   val pagerState = rememberPagerState()
   Column(horizontalAlignment = Alignment.CenterHorizontally) {
      HorizontalPager(pageCount = images.size, state = pagerState) { pagePosition ->
         AsyncImage(
            model = images[pagePosition],
            contentDescription = stringResource(id = R.string.product_image_description),
            contentScale = ContentScale.Fit,
            modifier = modifier
               .fillMaxWidth()
               .height(410.dp)
         )
      }
      DotsIndicator(
         totalDots = images.size,
         selectedIndex = pagerState.currentPage,
         selectedColor = MaterialTheme.colorScheme.error,
         unSelectedColor = MaterialTheme.colorScheme.secondary,
         modifier = Modifier.padding(top = 16.dp)
      )
   }
}

@Preview
@Composable
fun ProductImageSliderPreview() {
   KartTheme {
      ProductThumbnail(images = listOf("https://images.unsplash.com/photo-1681066471028-dec0c78b729c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1976&q=80"))
   }
}