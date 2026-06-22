package com.example.composecraft.showcase.components.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardsEx(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = Modifier
            .size(250.dp)
            .then(modifier),
        shape = RoundedCornerShape(16.dp),
        // elevation: Adds a shadow to the component that makes it appear elevated above the background.
        elevation = CardDefaults.cardElevation(
            1.dp,
        ),
        content = content
    )
//    {
    content
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ){
//            Text("Card Box")
//        }
//    }
}

@Preview
@Composable
fun PrevCardsEx() {
//    CardsEx()
}