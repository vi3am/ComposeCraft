package com.example.composecraft.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composecraft.navigation.AppRoute
import com.example.composecraft.showcase.components.bottomnavigationbar.BottomNavigationBarEx

@Composable
fun SettingScreen(
    onNavigate: (route: AppRoute) -> Unit,
) {
    Scaffold(
        bottomBar = {BottomNavigationBarEx(
            onNavigate = onNavigate
        )}
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("SettingScreen Screen")
        }
    }
}