package com.perfectyang.personbank.router

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.perfectyang.personbank.page.AddEdit.AddEditScreen
import com.perfectyang.personbank.page.Home.HomeScreen
import com.perfectyang.personbank.page.Setting.SettingScreen


fun NavGraphBuilder.AppGrap(
    modifier: Modifier,
    navController: NavController,
) {
    navigation(startDestination = Screens.ScreenHomeRoute.route, route= Screens.ScreenAppRoute.route) {
        composable(Screens.ScreenHomeRoute.route) {
            HomeScreen(modifier, navController = navController)
        }
        composable(Screens.ScreenSettingRoute.route) {
            SettingScreen(modifier, navController = navController)
        }
        composable(Screens.ScreenAddEditRoute.route) {
            AddEditScreen(modifier, navController = navController)
        }
    }

}
