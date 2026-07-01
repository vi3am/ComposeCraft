package com.example.composecraft.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute : NavKey {
    @Serializable
    data object Home : AppRoute, NavKey

    @Serializable
    data object About : AppRoute, NavKey

    @Serializable
    data object Notification : AppRoute, NavKey

    @Serializable
    data object Setting : AppRoute, NavKey

    data object NotificationPermissionScreen: AppRoute, NavKey
}