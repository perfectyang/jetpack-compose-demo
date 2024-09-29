package com.perfectyang.personbank.router

sealed class Screens(val route: String) {
    object ScreenAuthRoute: Screens("Auth")
    object ScreenLoginRoute: Screens("login")
    object ScreenRegisterRoute: Screens("register")

    object ScreenAppRoute: Screens("App")
    object ScreenSettingRoute: Screens("Setting")
    object ScreenUserRoute: Screens("Users")
    object ScreenHomeRoute: Screens("Home")

    object ScreenAddEditRoute: Screens("addEdit")
}
