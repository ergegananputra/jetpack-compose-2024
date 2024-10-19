package com.ergegananputra.jetpack_compose.ui.presentations.sensor

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme

@Preview(
    name = "Light Mode",
    showSystemUi = true,
    showBackground = true,
)
@Composable
private fun SensorScreenDeveloperPreview() {
    JetpackCompose2024Theme {
        SensorScreen()
    }
}


@Composable
fun SensorScreen(modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        Text(text = "Sensor Screen")
    }
}