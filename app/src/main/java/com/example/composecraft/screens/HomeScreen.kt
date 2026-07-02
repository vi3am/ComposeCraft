package com.example.composecraft.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Category
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecraft.model.AppModel
import com.example.composecraft.model.listAppRoute
import com.example.composecraft.navigation.AppRoute
import com.example.composecraft.feature.components.AppBars
import com.example.composecraft.feature.components.bottomnavigationbar.BottomNavigationBarEx
import com.example.composecraft.feature.components.dialogs.AlertDialogEx
import com.example.composecraft.feature.components.navigationdrawer.DrawerNav
import com.example.composecraft.feature.components.tabs.TabNavigationEx
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onNavigate: (route: AppRoute) -> Unit,
) {
    var openAlertDialog by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    DrawerNav(
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                AppBars(
                    title = "Compose-Craft",
                    onTitleClick = { openAlertDialog = !openAlertDialog },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigationBarEx(
                    onNavigate = onNavigate
                )
            }

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
                    .fillMaxSize().padding(padding)

            ) {
                TabNavigationEx(
                    onNavigate = onNavigate,
                    modifier = Modifier.weight(1f)
                )
            }


        }
    }
}


@Composable
fun Applist(modifier: Modifier = Modifier, item: AppModel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(12.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Icon(
            imageVector = item.trailingIcon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(20.dp)
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
