package com.example.composecraft.feature.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationPermissionScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()

    ){ isGranted ->
        createNotificationChannel(context)
        if(isGranted)Toast.makeText(context, "Permission granted: $isGranted",Toast.LENGTH_SHORT).show()
        else Toast.makeText(context, "Permission denied: $isGranted",Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(Unit){
        val isGranted = ContextCompat.checkSelfPermission(context,
            android.Manifest.permission.POST_NOTIFICATIONS)== android.content.pm.PackageManager.PERMISSION_GRANTED
        if(!isGranted){
            Toast.makeText(context, "Permission not granted",Toast.LENGTH_SHORT).show()
        }
        launcher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Notification Permission")

            },
                navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }

            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }

    }
}
fun createNotificationChannel(context: Context){
    val channel = NotificationChannel(
        "default_channel",
        "General Notifications",
        NotificationManager.IMPORTANCE_DEFAULT
    ).apply {
        description = "This is the default channel for notifications"
    }

    val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    manager.createNotificationChannel(channel)
}

@Preview
@Composable
fun NotificationPermissionScreenPreview() {
    NotificationPermissionScreen(
        onBack = {}
    )

}