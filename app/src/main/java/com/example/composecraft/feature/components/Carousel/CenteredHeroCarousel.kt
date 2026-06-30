package com.example.composecraft.feature.components.Carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecraft.feature.components.Card.CardsEx


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenteredHeroCarousel() {
    HorizontalCenteredHeroCarousel(
        state = rememberCarouselState { 5 },
//        maxItemWidth = TODO(),
        itemSpacing = 16.dp,
//        flingBehavior = TODO(),
//        userScrollEnabled = TODO(),
//        minSmallItemWidth = TODO(),
//        maxSmallItemWidth = TODO(),
        contentPadding = PaddingValues( 16.dp),
    ) {item ->
        CardsEx(
            modifier = Modifier.size(300.dp).fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text("Carouse ${item}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCenteredHeroCarousel() {
    CenteredHeroCarousel()

}