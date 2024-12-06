package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdelrahman.raafat.budget.tracker.ui.budget.BudgetScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.profile.ProfileScreen
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionDetailsScreen

@Suppress("FunctionName")
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    viewModel: DashboardViewModel,
) {
    NavHost(navController = navController, startDestination = BTBottomNavItem.Dashboard.route) {
        composable(BTBottomNavItem.Dashboard.route) { DashboardScreen(viewModel.items) }
        composable(BTBottomNavItem.Transaction.route) {
            TransactionDetailsScreen(viewModel.transactionsItems) {
            }
        }
        composable(BTBottomNavItem.Budget.route) {
            BudgetScreen()
        }
        composable(BTBottomNavItem.Profile.route) {
            ProfileScreen()
        }
    }
}
