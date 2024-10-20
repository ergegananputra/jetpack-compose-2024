package com.ergegananputra.jetpack_compose.ui.presentations.dashboard

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.ergegananputra.jetpack_compose._dev.Mocks
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph
import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components.CardInformational
import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components.DialogConsent
import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.components.PhotosCard
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun DashboardScreenDeveloperPreview() {
    JetpackCompose2024Theme {
        val viewModel = DashboardViewModel(
            photosRepository = Mocks.photosRepository
        )
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
    LaunchedEffect(null) {
        viewModel.fetchPhotos()
    }

    val state by viewModel.state.collectAsState()

    DialogConsent(
        isOpen = state.isDialogConfirmOpen,
        onDismiss = { viewModel.onDialogDismissed() },
        onConfirm = { mainEventHandler(MainGraph.ImplicitIntent("https://www.slingacademy.com/article/sample-photos-free-fake-rest-api-for-practice/")) }
    )

    Surface(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            CardInformational(
                onClick = {
                    // https://api.slingacademy.com/v1/sample-data/photos
                    viewModel.onCardInfoClicked()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .minimumInteractiveComponentSize()
                    .align(Alignment.TopCenter)
                    .zIndex(2f)
            )


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(1f)
            ) {
                item {
                    Spacer(modifier = Modifier.fillMaxWidth().height(100.dp))
                }
                items(
                    items = state.photos,
                    key = { it.id }
                ) {photo ->
                    PhotosCard(photo)
                }
            }
        }
    }
}





