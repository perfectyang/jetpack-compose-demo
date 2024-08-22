package com.perfectyang.nav.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.perfectyang.nav.page.PageC


fun NavGraphBuilder.AuthGraph(navController: NavController) {
    navigation(startDestination = Screens.ScreenLoginRoute.route, route = Screens.ScreenAuthRoute.route) {
        composable(Screens.ScreenLoginRoute.route) {
            PageC(navController = navController)
        }
    }
}