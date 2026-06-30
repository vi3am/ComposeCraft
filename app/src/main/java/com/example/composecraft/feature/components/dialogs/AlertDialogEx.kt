package com.example.composecraft.feature.components.dialogs


import android.R.attr.dialogTitle
import android.R.attr.text
import android.graphics.drawable.Icon
import androidx.appcompat.widget.DialogTitle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AlertDialogEx(
    onDismissRequest: () -> Unit,
    onConfirm:() -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector
){
    AlertDialog(
        icon = { Icon(icon, contentDescription = "Example Icon")},
        title = { Text(dialogTitle) },
        text = { Text(dialogText) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Dismiss")
            }
        },
        onDismissRequest = onDismissRequest
    )
}