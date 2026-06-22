package com.example.composecraft.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.composecraft.appViewModel.AppViewModel
import com.example.composecraft.screens.AboutScreen
import com.example.composecraft.screens.HomeScreen

@Composable
fun AppNav(viewModel: AppViewModel) {
    val backStack = rememberNavBackStack(AppRoute.Home)

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (isLoading) {
            CircularProgressIndicator()
        } else
            NavDisplay(
                backStack = backStack,
                onBack = {
                    backStack.removeLastOrNull()
                },
                entryProvider = entryProvider {
                    entry<AppRoute.Home> {
                        HomeScreen(
                            onNavigate = { route ->
                                backStack.add(route)
                            }
                        )
                    }
                    entry<AppRoute.About> {
                        AboutScreen(
                            onBack = {
                                backStack.removeLastOrNull()
                            }
                        )
                    }
                }
            )

    }
}