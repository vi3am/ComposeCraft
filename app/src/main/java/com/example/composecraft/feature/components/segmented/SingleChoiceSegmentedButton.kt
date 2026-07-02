package com.example.composecraft.feature.components.segmented

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SingleChoiceSegmentedEx(modifier: Modifier = Modifier){
    var selectedIndex by remember { mutableIntStateOf(0) }
    val opts = listOf("Option 1", "Option 2", "Option 3")

    SingleChoiceSegmentedButtonRow(modifier = Modifier.padding(16.dp).then(modifier)) {
        opts.forEachIndexed { index, option ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = opts.size
                ),
                label = { Text(option) },
            )
        }

    }
}

@Composable
fun SegmentedButtonScreen(){
    Scaffold() { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            SingleChoiceSegmentedEx(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun SegmentedButtonScreenPre(){
    SegmentedButtonScreen()
}
