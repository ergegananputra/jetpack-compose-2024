package com.ergegananputra.jetpack_compose.ui.activities

import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.DashboardViewModel
import com.ergegananputra.jetpack_compose.ui.presentations.sensor.SensorViewModel

data class MainActivityViewModelPacks(
    val dashboardViewModel: DashboardViewModel,
    val sensorViewModel: SensorViewModel
)