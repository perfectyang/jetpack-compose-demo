package com.perfectyang.personbank.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun RouterIndex(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.ScreenAuthRoute.route) {
        AuthGraph(
            modifier,
            navController = navController,
        )
        AppGrap(
            modifier,
            navController = navController,
        )
    }


}