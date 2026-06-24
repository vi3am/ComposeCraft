package com.example.composecraft.model

import com.example.composecraft.navigation.AppRoute

data class AppModel(
    val title : String,
    val route: AppRoute
)

val listAppRoute = listOf(
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
    AppModel("About", AppRoute.About),
)

val listAppNavBar= listOf(
    AppModel("Home", AppRoute.Home),
    AppModel("Notification", AppRoute.Notification),
    AppModel("Setting", AppRoute.Setting),
)
