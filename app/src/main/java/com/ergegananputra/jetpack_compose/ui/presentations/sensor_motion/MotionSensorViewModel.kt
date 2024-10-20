package com.ergegananputra.jetpack_compose.ui.presentations.sensor_motion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MotionSensorViewModel : ViewModel() {
    private val _state = MutableStateFlow(MotionSensorState())
    val state = _state.asStateFlow()

    fun updateState(state: MotionSensorState) {
        _state.update { state }
    }
}