package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abdelrahman.raafat.budget.tracker.ui.budget.BudgetScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.AddTransactionScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.TransactionType
import com.abdelrahman.raafat.budget.tracker.ui.profile.ProfileScreen
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionScreen

@Suppress("FunctionName")
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    viewModel: DashboardViewModel,
) {
    NavHost(navController = navController, startDestination = BTBottomNavItem.Dashboard.route) {
        composable(BTBottomNavItem.Dashboard.route) {
            val items = viewModel.items.collectAsState()
            DashboardScreen(items.value)
        }
        composable(BTBottomNavItem.Transaction.route) {
            TransactionScreen(viewModel.transactionsItems) {
            }
        }
        composable(BTBottomNavItem.Budget.route) {
            BudgetScreen()
        }
        composable(BTBottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(
            route = "AddTransactionScreen/{transactionType}",
            arguments = listOf(navArgument("transactionType") { type = NavType.StringType }),
        ) { backStackEntry ->
            val data = backStackEntry.arguments?.getString("transactionType") ?: TransactionType.INCOME.name
            val transactionType = TransactionType.fromType(data)
            AddTransactionScreen(transactionType = transactionType) {
                navController.popBackStack()
            }
        }
    }
}
