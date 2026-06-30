package com.example.composecraft.feature.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Badges(
    badgeCount: Int? = null,
    hasBadge: Boolean = false,
    content: @Composable () -> Unit,
) {
    BadgedBox(
        badge = {
            when {
                badgeCount != null ->
                    Badge {
                        Text(badgeCount.toString())
                    }
                hasBadge -> Badge()
            }

        }
    ) {
        content()
    }
}