package com.abdelrahman.raafat.budget.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.budget.tracker.navigation.BottomNavGraph
import com.abdelrahman.raafat.budget.tracker.navigation.BottomNavigationBar
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

class MainActivity : ComponentActivity() {
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackerTheme {
                MainScreen(dashboardViewModel)
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
fun MainScreen(dashboardViewModel: DashboardViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController = navController, viewModel = dashboardViewModel)
        }
    }
}
