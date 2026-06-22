package com.example.composecraft.showcase.components.Chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AssistChipComp() {
    AssistChip(
        onClick = {},
        label = { Text("Assist chip") },
        modifier = TODO(),
        enabled = true,
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        },
//        trailingIcon = ,
//        shape = ,
//        colors = TODO(),
//        elevation = TODO(),
//        border = TODO(),
//        interactionSource = TODO()
    )
}

@Preview(showBackground = true)
@Composable
fun previewAssistChip(){
    AssistChipComp()
}
