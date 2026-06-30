package com.example.composecraft.feature.components.Carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecraft.feature.components.Card.CardsEx

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiBrowseCarouselEx(){
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState{10},
        preferredItemWidth = 250.dp,
//        modifier = TODO(),
        itemSpacing = 8.dp,
//        flingBehavior = TODO(),
    ){item ->
//        CardsEx {
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center,
//            ){
//                Text("Carouse ${item}")
//            }
//        }
    }
}


@Preview
@Composable
fun PreviewHorizontalMultiBrowseCarouselEx(){
    MultiBrowseCarouselEx()
}