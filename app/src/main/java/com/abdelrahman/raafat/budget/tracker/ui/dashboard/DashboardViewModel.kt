package com.abdelrahman.raafat.budget.tracker.ui.dashboard

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseViewModel
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.BudgetExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.CategoryExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.ExpenseDistribution
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.UpcomingExpenses
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val application: Application,
) : BTBaseViewModel(application) {
    var transactionsItems: List<TransactionItem> = mutableListOf()
        private set

    private val _items = MutableStateFlow<List<DashboardItems>>(emptyList())
    val items: StateFlow<List<DashboardItems>> get() = _items

    init {
        getTransaction()
        updateItems()
    }

    private fun updateItems() {
        val items = mutableListOf<DashboardItems>()
        items.add(
            DashboardItems.UserInfoItem(
                userName = "Abdoooooo",
            ),
        )
        items.add(
            DashboardItems.BudgetExpenseItem(
                item = BudgetExpense(price = 10.0, totalPrice = 20.0),
            ),
        )
        val expenseDistribution = getExpenseDistribution()
        if (expenseDistribution.isNotEmpty()) {
            items.add(
                DashboardItems.ExpenseDistributionItem(
                    items = expenseDistribution,
                ),
            )
        }
        items.add(
            DashboardItems.CategoryWiseExpenses(
                items =
                    listOf(
                        CategoryExpense(
                            title = "Bills & Utilities",
                            iconRes = R.drawable.ic_onboarding_1,
                            price = 3600.0,
                            totalPrice = 3200.0,
                        ),
                        CategoryExpense(
                            title = "Food",
                            iconRes = R.drawable.ic_onboarding_2,
                            price = 1400.0,
                            totalPrice = 5000.0,
                        ),
                        CategoryExpense(
                            title = "Education",
                            iconRes = R.drawable.ic_onboarding_3,
                            price = 500.0,
                            totalPrice = 1000.0,
                        ),
                        CategoryExpense(
                            title = "Transport",
                            iconRes = R.drawable.ic_launcher_foreground,
                            price = 30.0,
                            totalPrice = 700.0,
                        ),
                    ),
            ),
        )

        items.add(
            DashboardItems.UpcomingExpensesItem(
                items =
                    listOf(
                        UpcomingExpenses(
                            title = "LinkedIn Subscription",
                            date = System.currentTimeMillis(),
                            price = 30.0,
                            iconRes = R.drawable.ic_onboarding_1,
                        ),
                        UpcomingExpenses(
                            title = "Data Plus: August",
                            date = System.currentTimeMillis() - 100000,
                            price = 40.0,
                            iconRes = R.drawable.ic_onboarding_2,
                        ),
                        UpcomingExpenses(
                            title = "Office 365 Subscription",
                            date = System.currentTimeMillis() - 200000,
                            price = 50.0,
                            iconRes = R.drawable.ic_onboarding_3,
                        ),
                        UpcomingExpenses(
                            title = "Waste Disposal Bill",
                            date = System.currentTimeMillis() - 300000,
                            price = 60.0,
                            iconRes = R.drawable.ic_launcher_foreground,
                        ),
                    ),
            ),
        )

        if (transactionsItems.isNotEmpty()) {
            items.add(
                DashboardItems.RecentTransactionsItem(
                    recentTransactions = transactionsItems.take(5),
                ),
            )
        }

        _items.value = items
    }

    /**
     * Calculates the distribution of expenses across different categories.
     *
     * The function groups all transaction items by their categories, calculates the total amount spent
     * in each category, and computes the percentage of the total expenses for each category.
     * The resulting distribution is sorted in descending order of expense amounts.
     *
     * @return A list of [ExpenseDistribution], where each item contains:
     *  - The name of the category (localized string).
     *  - The category's color.
     *  - The percentage of total expenses for the category.
     *  Returns an empty list if there are no transactions or the total transaction price is zero.
     *
     * Example:
     * If transactionsItems contain:
     *  - Category A: $100
     *  - Category B: $50
     *  - Total = $150
     * The result will be:
     *  - Category A: 66.67%
     *  - Category B: 33.33%
     */
    private fun getExpenseDistribution(): List<ExpenseDistribution> {
        val transactionsPrice = transactionsItems.sumOf { it.amount }
        if (transactionsPrice == 0.0) return emptyList() // Handle empty or zero-value transactions

        // Group transactions by category and sum their prices
        val categoriesWithPrices =
            transactionsItems
                .groupBy { it.category }
                .mapValues { (_, items) -> items.sumOf { it.amount } }
                .toList()
                .sortedByDescending { it.second } // Sort by price descending

        val expenseDistribution = mutableListOf<ExpenseDistribution>()
        categoriesWithPrices.map { (category, price) ->
            expenseDistribution.add(
                ExpenseDistribution(
                    name = application.getString(category.titleResId),
                    color = category.color,
                    percentage = (price / transactionsPrice * 100).toFloat(),
                ),
            )
        }
        return expenseDistribution
    }

    private fun getTransaction() {
        viewModelScope.launch {
            repository.getAllTransactions().collect { transactions ->
                transactionsItems = transactions.toMutableList()
                updateItems()
            }
        }
    }
}
