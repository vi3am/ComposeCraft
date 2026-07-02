package com.example.composecraft.feature.components.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecraft.model.listAppRoute
import com.example.composecraft.navigation.AppRoute
import com.example.composecraft.screens.Applist
import kotlinx.coroutines.launch

@Composable
fun TabNavigationEx(modifier: Modifier = Modifier, onNavigate: (AppRoute) -> Unit) {
    val pagerState = rememberPagerState(pageCount = { tabslist.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        PrimaryTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = pagerState.currentPage,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabslist.forEachIndexed { index, model ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(text = model.title, style = MaterialTheme.typography.titleSmall)
                        model.icon?.let {
                            Icon(imageVector = it, contentDescription = null)
                        }
                    }
                }
            }
        }
        HorizontalDivider()
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when (page) {
                TabIndex.HOME.index -> AppHome(
                    onNavigate = onNavigate
                )
                TabIndex.OVERVIEW.index -> Overview()
                TabIndex.SETTINGS.index -> SettingsScreen()
            }
        }
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = null,
            modifier = Modifier.padding(bottom = 8.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(text = "Settings Content", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun AppHome(onNavigate: (AppRoute) -> Unit) {
    Box {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
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

@Composable
fun Overview() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(5) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "${it + 1}. This is content overview",
                fontSize = 16.sp
            )
            HorizontalDivider()
        }
    }
}

enum class TabIndex(val index: Int) {
    HOME(0),
    OVERVIEW(1),
    SETTINGS(2)
}

data class TabModel(
    val title: String,
    val icon: ImageVector? = null
)

val tabslist = listOf(
    TabModel(
        "Home",
        Icons.Outlined.Home
    ),
    TabModel(
        "Overview",
        Icons.Outlined.Visibility
    ),
    TabModel(
        "Settings",
        Icons.Outlined.Settings
    ),
)


@Preview(showBackground = true)
@Composable
fun PreviewTabnavigation() {
    TabNavigationEx(
        onNavigate = {}
    )
}
