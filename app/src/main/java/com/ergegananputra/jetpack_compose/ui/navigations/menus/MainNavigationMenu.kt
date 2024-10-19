package com.ergegananputra.jetpack_compose.ui.navigations.menus

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph

sealed class MainNavigationMenu(val name: String, val route: MainGraph, val icon: ImageVector) {
    data object DashboardMenu : MainNavigationMenu("Dashboard", MainGraph.Dashboard, Icons.Default.Home)
    data object SensorMenu : MainNavigationMenu("Sensor", MainGraph.Sensor, Icons.Default.Info)

    companion object {
        val menus = listOf(DashboardMenu, SensorMenu)
    }
}