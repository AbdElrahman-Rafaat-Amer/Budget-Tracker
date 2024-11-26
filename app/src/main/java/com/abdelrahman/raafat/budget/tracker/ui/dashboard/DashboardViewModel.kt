package com.abdelrahman.raafat.budget.tracker.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.BudgetExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.CategoryExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.ExpenseDistribution
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Transaction
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.UpcomingExpenses
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

class DashboardViewModel(application: Application, ) : AndroidViewModel(application) {
    val items =
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
                            title = "Dota Plus: August",
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
                items =
                    listOf(
                        Transaction(
                            title = "Door Handle Replacement",
                            category = Category.BILLS_UTILITIES,
                            date = System.currentTimeMillis(),
                            price = 20.0,
                        ),
                        Transaction(
                            title = "Nike Running Shoe",
                            category = Category.PERSONAL,
                            date = System.currentTimeMillis() - 200000,
                            price = 20.0,
                        ),
                        Transaction(
                            title = "Mutual Fund",
                            category = Category.INVESTMENT,
                            date = System.currentTimeMillis() - 100000,
                            price = 20.0,
                        ),
                    ),
            ),
        )
}
