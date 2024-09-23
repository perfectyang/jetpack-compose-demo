package com.perfectyang.demoinjectdi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.perfectyang.demoinjectdi.page.Home.HomeScreen
import com.perfectyang.demoinjectdi.page.Setting.SettingScreen
import com.perfectyang.demoinjectdi.ui.theme.DemoInjectDiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoInjectDiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppRoute(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun AppRoute(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "Setting"
    ) {

        composable(route = "Home") {
            HomeScreen()
        }
        composable(route = "Setting") {
            SettingScreen()
        }
    }

}
