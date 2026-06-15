package com.example.composecraft.showcase.components

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun Badges(
    content: @Composable () -> Unit,
    badgeCount: Int
) {
    BadgedBox(
        badge = {
            if (badgeCount > 0) {
                Badge {
                    Text(
                        text = badgeCount.toString()
                    )
                }
            }

        }
    ) {
        content()
    }
}