package com.perfectyang.helo.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.perfectyang.helo.components.EditCardInfo
import com.perfectyang.helo.compositionLocal.LocalUserViewModel
import com.perfectyang.helo.page.LoginScreeen
import com.perfectyang.helo.viewModel.UserViewModel


@Composable
fun NavRouteMap(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalUserViewModel provides UserViewModel(LocalContext.current)) {
        val userViewModel = LocalUserViewModel.current

        NavHost(navController = navController, startDestination = Route.Login) {
            composable(Route.MainFrame) {
                MainFrame(
                    backLogin={
                        navController.popBackStack(Route.Login, true)
                    },
                    addEdit = {
                        navController.navigate(Route.AddEdit)
                    },
                    navController
                )
            }
            composable(Route.Login) {
                LoginScreeen(){
                    navController.navigate(Route.MainFrame) {
                        popUpTo(Route.Login) {inclusive = true}
                    }
                }
            }

            composable(Route.AddEdit) {
                EditCardInfo() {
                    navController.popBackStack()
                }
            }

        }
    }


}

