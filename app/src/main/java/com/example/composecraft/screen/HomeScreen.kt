package com.example.composecraft.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecraft.model.AppModel
import com.example.composecraft.model.listAppRoute
import com.example.composecraft.navigation.AppRoute
import com.example.composecraft.showcase.components.AppBars

@Composable
fun HomeScreen(
    onNavigate: (route: AppRoute) -> Unit,
) {
    Scaffold(
        topBar = {
            AppBars(
                title = "Compose-Craft",
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {

            Box {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(listAppRoute) { item ->
                        Applist(
                            item = item,
                            onClick = {
                                onNavigate(item.route)
                            })
                    }
                }
            }
        }

    }
}


@Composable
fun Applist(modifier: Modifier = Modifier, item: AppModel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color(0xFF144B5C).copy(0.1f))
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = item.title,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onNavigate = {},
    )
}
