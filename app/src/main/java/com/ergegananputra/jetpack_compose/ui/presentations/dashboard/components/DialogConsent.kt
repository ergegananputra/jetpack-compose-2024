package com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DialogConsent(
    isOpen: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (isOpen) {
        BasicAlertDialog(
            onDismissRequest = onDismiss,
        ) {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = {
                    Text("Info")
                },
                text = {
                    Text("This is a sample photos API from Sling Academy. Click OK to visit the website.")
                },
                confirmButton = {
                    TextButton(
                        onClick = onConfirm
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}