package com.ergegananputra.jetpack_compose.ui.presentations.sensor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ergegananputra.jetpack_compose.R
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph
import com.ergegananputra.jetpack_compose.ui.presentations.sensor.components.ItemSettingCard
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun SensorScreenDeveloperPreview() {
    JetpackCompose2024Theme {
        val viewModel = SensorViewModel()
        Scaffold {
            SensorScreen(
                mainEventHandler = {},
                viewModel = viewModel,
                modifier = Modifier.padding(it)
            )
        }


    }
}


@Composable
fun SensorScreen(
    mainEventHandler: (MainGraph) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SensorViewModel
) {
    Surface(modifier = modifier.padding(horizontal = 16.dp)) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Sensor Screen",
                style = MaterialTheme.typography.labelMedium,
            )

            ItemSettingCard(
                judul = "Motion Sensor",
                deskripsi = "Motion Sensor is a sensor that can detect motion. For example, it can detect when a person is walking or running.",
                iconPainter = painterResource(id = R.drawable.baseline_sports_gymnastics_24),
                iconContentDescription = "Gyro Sensor",
                onClick = {
                    mainEventHandler(MainGraph.MotionSensor)
                }

            )
        }
    }
}