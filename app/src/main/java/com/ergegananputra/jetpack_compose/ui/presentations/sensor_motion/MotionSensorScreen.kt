package com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun MotionSensorScreenDeveloperPreview() {
    JetpackCompose2024Theme {
        val viewModel = MotionSensorViewModel()
        Scaffold {
            MotionSensorScreen(
                modifier = Modifier.padding(it),
                viewModel = viewModel
            )
        }
    }
}


@Composable
fun MotionSensorScreen(
    modifier: Modifier = Modifier,
    viewModel: MotionSensorViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Motion Sensor Screen"
            )

            // X Sensor
            Text(
                text = "X: ${state.x}"
            )

            // Y Sensor
            Text(
                text = "Y: ${state.y}"
            )

            // Z Sensor
            Text(
                text = "Z: ${state.z}"
            )

            // Accurate Sensor
            Text(
                text = "Accurate: ${state.accuracy}"
            )
        }
    }
}