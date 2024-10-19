package com.ergegananputra.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ergegananputra.jetpack_compose.ui.navigations.BottomNavigation
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme
import com.ergegananputra.jetpack_compose.ui.presentations.components.TopAppBar as eTopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainNavController = rememberNavController()
            JetpackCompose2024Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { eTopAppBar() },
                    bottomBar = { BottomNavigation(mainNavController) }
                ) { innerPadding ->
                    MainGraph.NavHost(
                        navController = mainNavController,
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

