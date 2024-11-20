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
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.BudgetExpenseSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.CategoryWiseExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.ExpenseDistributionSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.GreetingSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.RecentTransactionsSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.UpcomingExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        items(dashboardViewModel.items) { item ->
            when (item) {
                is DashboardItems.UserInfoItem -> {
                    GreetingSection()
                }

                is DashboardItems.BudgetExpenseItem -> {
                    BudgetExpenseSection()
                }

                is DashboardItems.ExpenseDistributionItem -> {
                    ExpenseDistributionSection()
                }

                is DashboardItems.CategoryWiseExpenses -> {
                    CategoryWiseExpensesSection()
                }

                is DashboardItems.UpcomingExpensesItem -> {
                    UpcomingExpensesSection(item)
                }

                is DashboardItems.RecentTransactionsItem -> {
                    RecentTransactionsSection(item = item)
                }
            }
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    val dashboardViewModel = DashboardViewModel(Application())
    BudgetTrackerTheme {
        DashboardScreen(dashboardViewModel)
    }
}
