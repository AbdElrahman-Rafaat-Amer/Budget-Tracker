package com.abdelrahman.raafat.budget.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.DashboardViewModel
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionDetailsScreen
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackerTheme {
                MainNavHost(dashboardViewModel)
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
fun MainNavHost(viewModel: DashboardViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreensName.Dashboard.route) {
        composable(ScreensName.Dashboard.route) {
            DashboardScreen(
                dashboardItems = viewModel.items,
                onNavigateToTransaction = {
                    val serializedList = Json.encodeToString(it)
                    navController.navigate("${ScreensName.Transaction.route}/$serializedList")
                },
            )
        }

        composable(
            route = "${ScreensName.Transaction.route}/{transactions}",
            arguments = listOf(navArgument("transactions") { type = NavType.StringType }),
        ) { backStackEntry ->
            val serializedList = backStackEntry.arguments?.getString("transactions")
            val transactionsItems = serializedList?.let { Json.decodeFromString<List<TransactionItem>>(it) }
            transactionsItems?.let {
                TransactionDetailsScreen(transactionsList = it) {
                    navController.popBackStack()
                }
            }
        }
    }
}
