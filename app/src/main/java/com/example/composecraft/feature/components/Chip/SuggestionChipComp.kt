package com.example.composecraft.feature.components.Chip

import android.util.Log
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SuggestionChipExample() {
    SuggestionChip(
        onClick = { Log.d("Suggestion chip", "hello world") },
        label = { Text("Suggestion chip") }
    )
}

@Preview(showBackground = true)
@Composable
fun SuggestionChipPreview() {
    SuggestionChipExample()
}

//Elevated chip
//All the examples in this document use the base composables that take a flat appearance. If you want a chip that has an elevated appearance, use one of the three following composables:
//
//ElevatedAssistChip
//ElevatedFilterChip
//ElevatedSuggestionChip