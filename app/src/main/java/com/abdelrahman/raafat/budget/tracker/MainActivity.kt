package com.abdelrahman.raafat.budget.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.budget.tracker.navigation.BottomNavGraph
import com.abdelrahman.raafat.budget.tracker.navigation.BottomNavigationBar
import com.abdelrahman.raafat.budget.tracker.navigation.BottomNavigationFab
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTFabMenu
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.TransactionType
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
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
private fun MainScreen(dashboardViewModel: DashboardViewModel) {
    val navController = rememberNavController()
    var showDialog by remember { mutableStateOf(false) }

    val currentRoute =
        navController
            .currentBackStackEntryAsState()
            .value
            ?.destination
            ?.route

    // Routes where the bottom bar and FAB should be hidden
    val hideBottomBarRoutes = listOf("AddTransactionScreen/{transactionType}")

    Scaffold(
        bottomBar = {
            if (currentRoute !in hideBottomBarRoutes) {
                BottomNavigationBar(navController)
            }
        },
        containerColor = AppColors.LightPrimary,
        floatingActionButton = {
            if (currentRoute !in hideBottomBarRoutes) {
                BottomNavigationFab(showDialog) {
                    showDialog = showDialog.not()
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding), contentAlignment = Alignment.BottomCenter) {
            BottomNavGraph(navController = navController, viewModel = dashboardViewModel)

            // Overlay for showing the 3 buttons
            AnimatedVisibility(
                visible = showDialog && currentRoute !in hideBottomBarRoutes,
                enter =
                    slideInVertically(
                        initialOffsetY = { it }, // Start below the screen
                        animationSpec = tween(durationMillis = 300),
                    ),
                exit =
                    slideOutVertically(
                        targetOffsetY = { it }, // Move back below the screen
                        animationSpec = tween(durationMillis = 300),
                    ),
            ) {
                BTFabMenu(
                    onDismiss = { showDialog = false },
                    onIncomeClick = {
                        navController.navigate("AddTransactionScreen/${TransactionType.INCOME.name}")
                    },
                    onExpenseClick = {
                        navController.navigate("AddTransactionScreen/${TransactionType.EXPENSE.name}")
                    },
                    onTransferClick = {
                        // TODO handle transfer case.
                    },
                )
            }
        }
    }
}
