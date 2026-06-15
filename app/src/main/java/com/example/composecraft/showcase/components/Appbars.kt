package com.example.composecraft.showcase.components

import android.R.attr.navigationIcon
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBars(
    titile: String,
    navigationIcon: @Composable () -> Unit = {},
    actionsIcon: @Composable RowScope.() -> Unit = {}

) {
    CenterAlignedTopAppBar(
        title = { Text(
            text = titile
        ) },
        navigationIcon = navigationIcon,
        actions = actionsIcon
    )
}

@Preview (showBackground = true)
@Composable
fun preview(){
    AppBars(
        titile = "AppBarr",
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actionsIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
               Badges(
                   content = {
                       Icon(Icons.Filled.Notifications, contentDescription = null)
                   },
                   badgeCount = 99
               )
            }
        }
    )
}