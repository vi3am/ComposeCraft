package com.example.composecraft.showcase.components.Chip

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilterChipComp() {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Filter chip") },
        leadingIcon = {
            if (!selected) {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        },

        trailingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized Settings",
                Modifier.size(FilterChipDefaults.IconSize)
            )
        },
        shape = RoundedCornerShape(16.dp),
//        colors = TODO(),
    )
}

@Preview
@Composable
fun previewFilterChip() {
    FilterChipComp()
}