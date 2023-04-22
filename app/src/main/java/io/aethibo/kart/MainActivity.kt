package io.aethibo.kart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.aethibo.kart.core.navigation.KartNavHost
import io.aethibo.kart.core.ui.KartTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         KartApp()
      }
   }
}

@Composable
fun KartApp() {
   KartTheme {
      val navController = rememberNavController()
      Scaffold { innerPadding ->
         KartNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
         )
      }
   }
}