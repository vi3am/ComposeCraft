package com.example.composecraft.feature.components.Carousel

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composecraft.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselCardEx() {
    val carouselState = rememberCarouselState { carouselList.count() }
    HorizontalMultiBrowseCarousel(
        state = carouselState,
        //preferredItemWidth : (for HorizontalMultiBrowseCarousel):
        // Suggests the ideal width for items in a multi-browse carousel, letting the
        // component display multiple items if space permits.
        preferredItemWidth = 200.dp,
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) { i ->
        val item = carouselList[i]
        AsyncImage(
            model = item.image,
            contentDescription = "A scenic photo",
            modifier = Modifier.fillMaxWidth().height(200.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.placeholder),
            contentScale = ContentScale.Crop
        )

    }
}


data class CarouselModel(
    val id: Int,
    val title: String,
    val image: String
)

val carouselList = listOf(
    CarouselModel(
        id = 1,
        title = "Mountain View",
        image = "https://images.unsplash.com/photo-1501785888041-af3ef285b470"
    ),
    CarouselModel(
        id = 2,
        title = "City Lights",
        image = "https://images.unsplash.com/photo-1492684223066-81342ee5ff30"
    ),
    CarouselModel(
        id = 3,
        title = "Ocean Breeze",
        image = "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
    ),
    CarouselModel(
        id = 4,
        title = "Forest Path",
        image = "https://images.unsplash.com/photo-1441974231531-c6227db76b6e"
    ),
    CarouselModel(
        id = 5,
        title = "Desert Dunes",
        image = "https://images.unsplash.com/photo-1509316785289-025f5b846b35"
    ),
    CarouselModel(
        id = 6,
        title = "Snow Mountains",
        image = "https://images.unsplash.com/photo-1486915309851-b0cc1f8a0084"
    ),
    CarouselModel(
        id = 7,
        title = "Sunset Beach",
        image = "https://images.unsplash.com/photo-1501973801540-537f08ccae7b"
    ),
    CarouselModel(
        id = 8,
        title = "Modern City",
        image = "https://images.unsplash.com/photo-1480714378408-67cf0d13bc1b"
    ),
    CarouselModel(
        id = 9,
        title = "Green Valley",
        image = "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee"
    ),
    CarouselModel(
        id = 10,
        title = "Night Sky",
        image = "https://images.unsplash.com/photo-1506318137071-a8e063b4bec0"
    )
)

@Preview
@Composable
fun CarouselCardPreview() {
    CarouselCardEx()
}

