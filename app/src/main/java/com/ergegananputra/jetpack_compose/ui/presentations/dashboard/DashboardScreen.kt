package com.ergegananputra.jetpack_compose.ui.presentations.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun DashboardScreenDeveloperPreview() {
    JetpackCompose2024Theme {
        val viewModel = DashboardViewModel()
        DashboardScreen(
            viewModel = viewModel,
            mainEventHandler = {}
        )
    }
}


@Composable
fun DashboardScreen(
    mainEventHandler: (MainGraph) -> Unit,
    viewModel: DashboardViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()

    DialogConsent(
        isOpen = state.isDialogConfirmOpen,
        onDismiss = { viewModel.onDialogDismissed() },
        onConfirm = { mainEventHandler(MainGraph.ImplicitIntent("https://www.slingacademy.com/article/sample-photos-free-fake-rest-api-for-practice/")) }
    )

    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .clickable {
                        // https://api.slingacademy.com/v1/sample-data/photos
                        viewModel.onCardInfoClicked()
                    }
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Row (
                    verticalAlignment = androidx.compose.ui.Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp, 8.dp)
                ) {
                    Icon(
                        Icons.Filled.Info, contentDescription = "Info",
                        modifier = Modifier.padding(
                            top = 8.dp,
                            end = 8.dp
                        )
                    )
                    Column(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Lazy List & API Fetch Example",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Sling Academy: Sample Photos - Free Fake REST API for Practice",
                            style = MaterialTheme.typography.labelSmall,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DialogConsent(
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