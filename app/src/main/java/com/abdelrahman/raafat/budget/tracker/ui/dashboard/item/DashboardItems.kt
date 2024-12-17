package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction

sealed class DashboardItems {
    data class UserInfoItem(
        var userName: String,
    ) : DashboardItems()

    data class BudgetExpenseItem(
        var item: BudgetExpense,
    ) : DashboardItems()

    data class ExpenseDistributionItem(
        var items: List<ExpenseDistribution>,
    ) : DashboardItems()

    data class CategoryWiseExpenses(
        var items: List<CategoryExpense>,
    ) : DashboardItems()

    data class UpcomingExpensesItem(
        var items: List<UpcomingExpenses>,
    ) : DashboardItems()

    data class RecentTransactionsItem(
        var recentTransactions: List<Transaction>,
    ) : DashboardItems()
}
