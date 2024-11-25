package com.abdelrahman.raafat.budget.tracker.ui.dashboard

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.BudgetExpenseSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.CategoryWiseExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.ExpenseDistributionSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.GreetingSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.RecentTransactionsSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.UpcomingExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel) {
    LazyColumn(
        modifier =
            Modifier
                .background(AppColors.LightPrimary)
                .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(dashboardViewModel.items) { item ->
            when (item) {
                is DashboardItems.UserInfoItem -> {
                    GreetingSection(
                        userInfoItem = item,
                        modifier = Modifier.background(AppColors.BackgroundLight),
                    )
                }

                is DashboardItems.BudgetExpenseItem -> {
                    BudgetExpenseSection(item)
                }

                is DashboardItems.ExpenseDistributionItem -> {
                    ExpenseDistributionSection(item)
                }

                is DashboardItems.CategoryWiseExpenses -> {
                    CategoryWiseExpensesSection(item)
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
