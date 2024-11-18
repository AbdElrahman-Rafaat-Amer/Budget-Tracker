package com.abdelrahman.raafat.budget.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

class MainActivity : ComponentActivity() {
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetTrackerTheme {
                DashboardScreen(dashboardViewModel)
            }
        }
    }
}
