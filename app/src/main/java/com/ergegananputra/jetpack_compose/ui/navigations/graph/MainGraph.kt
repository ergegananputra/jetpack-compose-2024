package com.ergegananputra.jetpack_compose.ui.navigations.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.DashboardScreen
import com.ergegananputra.jetpack_compose.ui.presentations.sensor.SensorScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class MainGraph {

    @Serializable
    data object Dashboard : MainGraph()

    @Serializable
    data object Sensor : MainGraph()

    companion object {
        @Composable
        fun NavHost(
            navController: androidx.navigation.NavHostController,
            modifier: Modifier = Modifier
        ) {
            androidx.navigation.compose.NavHost(
                navController = navController,
                startDestination = Dashboard
            ) {
                composable<Dashboard> {
                    DashboardScreen(modifier = modifier)
                }
                composable<Sensor> {
                    SensorScreen(modifier = modifier)
                }
            }
        }
    }

}