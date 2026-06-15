package com.example.composecraft.showcase.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBars() {
    CenterAlignedTopAppBar(
        title = { Text("AppBar Example") },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
    )
}