package com.perfectyang.nav.route

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.perfectyang.nav.page.PageA
import com.perfectyang.nav.page.PageB


fun NavGraphBuilder.AppRoute(navController: NavController) {
    navigation(startDestination = Screens.ScreenHomeRoute.route, route= Screens.ScreenAppRoute.route) {
        composable(Screens.ScreenHomeRoute.route) {
            PageA(navController = navController)
        }
        composable(Screens.ScreenMineRoute.route) {
            PageB(navController = navController)
        }
    }

}