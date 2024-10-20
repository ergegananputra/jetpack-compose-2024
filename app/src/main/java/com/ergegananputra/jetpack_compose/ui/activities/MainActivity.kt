package com.ergegananputra.jetpack_compose.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.ergegananputra.jetpack_compose.ui.presentations.components.BottomNavigation
import com.ergegananputra.jetpack_compose.ui.navigations.graph.MainGraph
import com.ergegananputra.jetpack_compose.ui.presentations.dashboard.DashboardViewModel
import com.ergegananputra.jetpack_compose.ui.presentations.sensor.SensorViewModel
import com.ergegananputra.jetpack_compose.ui.theme.JetpackCompose2024Theme
import dagger.hilt.android.AndroidEntryPoint
import com.ergegananputra.jetpack_compose.ui.presentations.components.TopAppBar as eTopAppBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainNavController = rememberNavController()
            val viewModelPacks = MainActivityViewModelPacks(
                dashboardViewModel = hiltViewModel<DashboardViewModel>(),
                sensorViewModel = viewModel {
                    SensorViewModel()
                }
            )
            JetpackCompose2024Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { eTopAppBar() },
                    bottomBar = { BottomNavigation(mainNavController) }
                ) { innerPadding ->
                    MainGraph.NavHost(
                        navController = mainNavController,
                        eventHandler = ::eventHandler,
                        viewModelPacks = viewModelPacks,
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }


    private fun eventHandler(action: MainGraph) {
        when (action) {
            is MainGraph.ImplicitIntent -> {
                val uri = action.uri
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                webUriLauncher.launch(intent)
            }
            is MainGraph.MotionSensor -> {
                val intentToMotionSensorActivity = Intent(this, MotionSensorActivity::class.java)
                activitySensorLauncher.launch(intentToMotionSensorActivity)
            }
            else -> {
                // Handle other actions
            }
        }
    }


    /**
     * Launch Web URI
     */
    private val webUriLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            Log.d(this::class.simpleName, "Web URI Launched")
        }

    private val activitySensorLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                Log.d(this::class.simpleName, "Sensor Activity Launched")
            } else {
                Log.d(this::class.simpleName, "Sensor Activity Cancelled")
            }
        }

}


