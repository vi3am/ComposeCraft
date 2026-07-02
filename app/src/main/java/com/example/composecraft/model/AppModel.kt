package com.example.composecraft.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Category
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composecraft.navigation.AppRoute

data class AppModel(
    val icon: ImageVector,
    val title: String,
    val subtitle: String,
    val trailingIcon: ImageVector,
    val route: AppRoute,
)
data class AppNavModel(
    val title: String,
    val route: AppRoute,
)
val listAppRoute = listOf(
    AppModel(
        Icons.Default.Category,
        "About",
        "View details and examples",
        Icons.AutoMirrored.Filled.ArrowForward,
        AppRoute.About
    ),
    AppModel(
        Icons.Default.Category,
        "Notification",
        "View details and examples",
        Icons.AutoMirrored.Filled.ArrowForward,
        AppRoute.NotificationPermissionScreen
    ),
)

val listAppNavBar = listOf(
    AppNavModel("Home", AppRoute.Home),
    AppNavModel("Notification", AppRoute.Notification),
    AppNavModel("Setting", AppRoute.Setting),
)
