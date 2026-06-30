package com.example.composecraft.feature.components.navigationdrawer

import android.R.attr.thickness
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composecraft.R

@Composable
fun DrawerNav(
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.85f),
                drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                drawerContainerColor = MaterialTheme.colorScheme.surface,
            ) {
                DrawerNavContent()
            }
        },
        drawerState = drawerState,
        content = content
    )
}

@Composable
fun DrawerNavContent() {
    var selectedId by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(12.dp)
    ) {
        // Profile Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, top = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "https://i.pinimg.com/736x/38/ac/ec/38acec2058ca6b9e8bac6be2bdce6620.jpg",
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Ronald Richards",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "ronaldrichards@example.com",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 8.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation Items
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(drawerItems.size) { index ->
                val item = drawerItems[index]
                DrawerNavItem(
                    icon = item.icon,
                    title = item.title,
                    selected = selectedId == item.id,
                    onClick = { selectedId = item.id },
                    trailingIcon = item.trailingIcon
                )
            }
        }
        DrawerNavItem(
            icon = Icons.Outlined.Logout,
            title = "Sign Out",
            selected = false,
            onClick = { /* Handle Logout */ },
            modifier = Modifier.padding(bottom = 16.dp),
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun DrawerNavItem(
    icon: ImageVector,
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: ImageVector? = null,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    val background = if (selected) MaterialTheme.colorScheme.primaryContainer.copy(0.5f) else Color.Transparent
    val contentColor = if (selected) MaterialTheme.colorScheme.onPrimaryContainer else color

    Surface(
        selected = selected,
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp),
        shape = RoundedCornerShape(16.dp),
        color = background,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = contentColor
            )
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = contentColor.copy(alpha = 0.6f)
                )
            }
        }
    }
}

data class ItemDrawerModel(
    val id: Int,
    val icon: ImageVector,
    val title: String,
    val trailingIcon: ImageVector? = null,
)

val drawerItems = listOf(
    ItemDrawerModel(
        1,
        Icons.Outlined.Home,
        "Home",
        Icons.AutoMirrored.Filled.KeyboardArrowRight
    ),
    ItemDrawerModel(
        2,
        Icons.Outlined.Person,
        "Profile",
        Icons.AutoMirrored.Filled.KeyboardArrowRight
    ),
    ItemDrawerModel(
        3,
        Icons.Outlined.Notifications,
        "Notifications",
        Icons.AutoMirrored.Filled.KeyboardArrowRight
    ),
    ItemDrawerModel(
        4,
        Icons.Outlined.Settings,
        "Settings",
        Icons.AutoMirrored.Filled.KeyboardArrowRight
    )
)



@Preview
@Composable
fun PreviewDrawerNav() {
    DrawerNav(
        content = {},
        drawerState = DrawerState(DrawerValue.Open)
    )
}