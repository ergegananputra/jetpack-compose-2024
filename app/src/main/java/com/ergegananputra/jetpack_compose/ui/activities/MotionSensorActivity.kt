package com.ergegananputra.jetpack_compose.ui.activities

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion.MotionSensorScreen
import com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion.MotionSensorState
import com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion.MotionSensorViewModel
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme


class MotionSensorActivity : ComponentActivity(), SensorEventListener {

    private val sensorManager by lazy {
        getSystemService(SENSOR_SERVICE) as SensorManager
    }

    private val motionSensorViewModel by lazy {
        MotionSensorViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            JetpackCompose2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MotionSensorScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = motionSensorViewModel
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also { gyroscope ->
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }


    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        setResult(RESULT_OK)
        return super.getOnBackInvokedDispatcher()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val values = it.values
            motionSensorViewModel.updateState(
                MotionSensorState(
                    x = values[0],
                    y = values[1],
                    z = values[2]
                )
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        motionSensorViewModel.updateState(
            MotionSensorState(accuracy = accuracy)
        )
    }
}
