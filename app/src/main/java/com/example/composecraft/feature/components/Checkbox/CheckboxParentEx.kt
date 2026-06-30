package com.example.composecraft.feature.components.Checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckboxParentEx() {
    val childCheckedStates = remember {
        mutableStateListOf(false, false, false)
    }

    // Compute the parent state based on children's states
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Parent TriStateCheckbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckedStates.forEachIndexed { index, _ ->
                        childCheckedStates[index] = newState
                    }
                }
            )
            Text("Parent StateCheckBox")
        }
        childCheckedStates.forEachIndexed { index, isChecked ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { childCheckedStates[index] = !isChecked }
                )
                Text("Child CheckBox")
            }
        }
        if (childCheckedStates.all { it }) {
            Text("All options selected")
        }


    }

}



@Preview(showBackground = true)
@Composable
fun PreviewCheckboxParentEx() {
    CheckboxParentEx()
}