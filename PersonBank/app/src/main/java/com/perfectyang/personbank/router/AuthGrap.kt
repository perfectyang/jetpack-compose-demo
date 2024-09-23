package com.perfectyang.personbank.router

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.perfectyang.personbank.page.Login.LoginScreen


fun NavGraphBuilder.AuthGraph(modifier: Modifier, navController: NavController) {
    // 这里是总入口路由, 子路由可以多级定义
    navigation(startDestination = Screens.ScreenLoginRoute.route, route = Screens.ScreenAuthRoute.route) {
        composable(Screens.ScreenLoginRoute.route) {
            LoginScreen(
                modifier,
                navController = navController,
            )
        }
    }
}
