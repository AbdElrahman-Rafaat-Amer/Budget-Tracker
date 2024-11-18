package com.abdelrahman.raafat.budget.tracker.ui.dashboard

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        items(dashboardViewModel.items) { item ->
            when (item) {
                is DashboardItems.UserInfoItem -> {
                }

                is DashboardItems.BudgetExpenseItem -> {
                }

                is DashboardItems.ExpenseDistributionItem -> {
                }

                is DashboardItems.CategoryWiseExpenses -> {
                }

                is DashboardItems.UpcomingExpensesItem -> {
                }

                is DashboardItems.RecentTransactionsItem -> {
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    val dashboardViewModel = DashboardViewModel(Application())
    BudgetTrackerTheme {
        DashboardScreen(dashboardViewModel)
    }
}
