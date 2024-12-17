package com.abdelrahman.raafat.budget.tracker.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.BudgetExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.CategoryExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.ExpenseDistribution
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.UpcomingExpenses
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.BudgetExpenseSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.CategoryWiseExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.ExpenseDistributionSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.GreetingSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.RecentTransactionsSection
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget.UpcomingExpensesSection
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction

@Suppress("FunctionName")
@Composable
fun DashboardScreen(dashboardItems: List<DashboardItems>) {
    LazyColumn(
        modifier =
            Modifier
                .background(AppColors.LightPrimary)
                .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(dashboardItems) { item ->
            when (item) {
                is DashboardItems.UserInfoItem -> {
                    GreetingSection(userInfoItem = item)
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
    val dashboardItems =
        listOf(
            DashboardItems.UserInfoItem(
                userName = "Abdooooooo",
            ),
            DashboardItems.BudgetExpenseItem(
                item =
                    BudgetExpense(
                        price = 10.0,
                        totalPrice = 20.0,
                    ),
            ),
            DashboardItems.ExpenseDistributionItem(
                items =
                    listOf(
                        ExpenseDistribution(
                            name = "Bills & Utilities",
                            color = AppColors.BillsUtilitiesColor,
                            percentage = 27f,
                        ),
                        ExpenseDistribution(
                            name = "Food",
                            color = AppColors.FoodColor,
                            percentage = 12f,
                        ),
                        ExpenseDistribution(
                            name = "Personal",
                            color = AppColors.PersonalColor,
                            percentage = 11f,
                        ),
                        ExpenseDistribution(
                            name = "Healthcare",
                            color = AppColors.HealthcareColor,
                            percentage = 5f,
                        ),
                        ExpenseDistribution(
                            name = "Education",
                            color = AppColors.EducationColor,
                            percentage = 15f,
                        ),
                        ExpenseDistribution(
                            name = "Transport",
                            color = AppColors.TransportColor,
                            percentage = 8f,
                        ),
                        ExpenseDistribution(
                            name = "Investment",
                            color = AppColors.InvestmentColor,
                            percentage = 12f,
                        ),
                        ExpenseDistribution(
                            name = "Others",
                            color = AppColors.OthersColor,
                            percentage = 10f,
                        ),
                    ),
            ),
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
            DashboardItems.RecentTransactionsItem(
                recentTransactions =
                    listOf(
                        Transaction(
                            name = "Door Handle Replacement",
                            description = "Door Handle Replacement Shoedesc",
                            category = Category.UTILITIES,
                            paymentMethod = PaymentMethod.CASH,
                            date = System.currentTimeMillis(),
                            amount = 20.0,
                            isExpense = false,
                        ),
                        Transaction(
                            name = "Nike Running Shoe",
                            description = "Nike Running Shoedesc",
                            category = Category.PERSONAL,
                            paymentMethod = PaymentMethod.CASH,
                            date = System.currentTimeMillis() - 200000,
                            amount = 20.0,
                            isExpense = false,
                        ),
                        Transaction(
                            name = "Mutual Fund",
                            description = "Mutual Fund desc",
                            category = Category.INVESTMENT,
                            paymentMethod = PaymentMethod.CASH,
                            date = System.currentTimeMillis() - 100000,
                            amount = 20.0,
                            isExpense = false,
                        ),
                    ),
            ),
        )
    BudgetTrackerTheme {
        DashboardScreen(dashboardItems)
    }
}
