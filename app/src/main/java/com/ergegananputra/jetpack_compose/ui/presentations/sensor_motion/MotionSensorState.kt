package com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion

data class MotionSensorState(
    val x: Float = 0f,
    val y: Float = 0f,
    val z: Float = 0f,
    val accuracy: Int = 0,
)
