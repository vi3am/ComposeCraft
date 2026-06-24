package com.example.composecraft.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.composecraft.showcase.components.bottomnavigationbar.BottomNavigationBarEx
import com.example.composecraft.showcase.components.dialogs.AlertDialogEx
import com.example.composecraft.showcase.components.navigationdrawer.DrawerNav
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onNavigate: (route: AppRoute) -> Unit,
) {
    var openAlertDialog by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    DrawerNav(drawerState = drawerState) {
        Scaffold(
            topBar = {
                AppBars(
                    title = "Compose-Craft",
                    onTitleClick = { openAlertDialog = !openAlertDialog },
                    onClick ={
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            },
            bottomBar = { BottomNavigationBarEx(onNavigate = onNavigate) }

        ) { padding ->
            if (openAlertDialog) {
                AlertDialogEx(
                    onDismissRequest = {
                        openAlertDialog = false
                    },
                    onConfirm = {
                        openAlertDialog = false
                    },
                    dialogTitle = "Notification",
                    dialogText = "Hello Compose!",
                    icon = Icons.Default.Notifications
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                Box {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
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
//            .background(Color(0xFF144B5C).copy(0.1f))
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Column() {
          Text(
              text = item.title,
              fontWeight = FontWeight.Normal,
              fontSize = 18.sp,
              color = Color.Black
          )
          Text(
              text = item.title,
              fontWeight = FontWeight.Normal,
              style = MaterialTheme.typography.bodyMedium,
              color = Color.Gray
          )
      }
        IconButton(onClick = onClick) {
            Icon(imageVector = Icons.Default.ArrowLeft, contentDescription = "Back")
        }
    }
    HorizontalDivider()
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onNavigate = {},
    )
}
