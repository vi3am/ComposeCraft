package com.example.composecraft.feature.components.bottomnavigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecraft.model.listAppNavBar
import com.example.composecraft.navigation.AppRoute
import com.example.composecraft.feature.components.Badges

@Composable
fun BottomNavigationBarEx(onNavigate: (AppRoute) -> Unit) {
    var selectedItem by rememberSaveable { mutableStateOf(0) }
    NavigationBar() {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onNavigate(
                        listAppNavBar[index].route
                    )
                },
                icon = {
                    Badges(
                        badgeCount = item.badgeCount,
                        hasBadge = item.hasNews
                    ) {
                        Icon(
                            imageVector = if (selectedItem == index) item.selectedlcon
                            else item.unselectedlcon,
                            contentDescription = item.title
                        )

                    }
                }
            )
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedlcon: ImageVector,
    val unselectedlcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        selectedlcon = Icons.Filled.Home,
        unselectedlcon = Icons.Outlined.Home,
        hasNews = false
    ),
    BottomNavigationItem(
        title = "Notifications",
        selectedlcon = Icons.Filled.Notifications,
        unselectedlcon = Icons.Outlined.Notifications,
        hasNews = true,
        badgeCount = 5
    ),
    BottomNavigationItem(
        title = "Settings",
        selectedlcon = Icons.Filled.Settings,
        unselectedlcon = Icons.Outlined.Settings,
        hasNews = true
    )
)

@Preview
@Composable
private fun PreviewNavigationBarEx() {
    NavigationBar(
        content = {}
    )
}