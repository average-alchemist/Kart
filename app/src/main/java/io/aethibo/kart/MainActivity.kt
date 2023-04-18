package io.aethibo.kart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import io.aethibo.kart.core.ui.KartTheme
import io.aethibo.kart.features.products.presentation.ProductsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         KartTheme {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background
            ) {
               ProductsScreen(
                  onProductClick = { productId ->

                  },
                  onCommercialItemClick = {

                  },
                  onCategoryItemClick = { category ->

                  }
               )
            }
         }
      }
   }
}