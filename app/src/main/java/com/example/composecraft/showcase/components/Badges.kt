package com.example.composecraft.showcase.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Badges(
    content: @Composable () -> Unit,
    badgeCount: Int
) {
    BadgedBox(
        badge = {
            Badge {
                Text(
                    text = badgeCount.toString()
                )
            }

        }
    ) {
        content()
    }
}