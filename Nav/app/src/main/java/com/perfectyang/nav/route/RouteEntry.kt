package com.perfectyang.nav.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun RouteEntry(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ScreenAuthRoute.route) {
        AuthGraph(navController)
        AppRoute(navController)
    }
}