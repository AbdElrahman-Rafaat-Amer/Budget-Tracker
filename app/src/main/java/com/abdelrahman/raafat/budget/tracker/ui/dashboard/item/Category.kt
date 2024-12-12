package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.TransactionType
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

enum class Category(
    @StringRes val titleResId: Int,
    val color: Color,
    val type: TransactionType,
) {
    // Income-Category
    SALARY(R.string.salary, AppColors.SalaryColor, TransactionType.INCOME),
    BONUS(R.string.bonus, AppColors.BonusColor, TransactionType.INCOME),
    INTEREST(R.string.interest, AppColors.InterestColor, TransactionType.INCOME),
    DIVIDENDS(R.string.dividends, AppColors.DividendsColor, TransactionType.INCOME),
    RENTAL_INCOME(R.string.rental_income, AppColors.RentalIncomeColor, TransactionType.INCOME),
    FREELANCE_WORK(R.string.freelance_work, AppColors.FreelanceWorkColor, TransactionType.INCOME),
    BUSINESS_PROFIT(R.string.business_profit, AppColors.UndefinedColor, TransactionType.INCOME), // TODO change the colors
    INVESTMENT_PROFIT(R.string.investment_profit, AppColors.UndefinedColor, TransactionType.INCOME), // TODO change the colors
    LOAN_RECEIVED(R.string.loan_received, AppColors.UndefinedColor, TransactionType.INCOME), // TODO change the colors
    GIFT_RECEIVED(R.string.gift_received, AppColors.UndefinedColor, TransactionType.INCOME), // TODO change the colors
    BANK_TRANSFER_INCOME(R.string.bank_transfer, AppColors.UndefinedColor, TransactionType.INCOME), // TODO change the colors
    OTHER_INCOME(R.string.other_income, AppColors.OthersColor, TransactionType.INCOME), // TODO change the colors

    // Income-Category
    RENT(R.string.rent, AppColors.RentColor, TransactionType.EXPENSE),
    MORTGAGE(R.string.mortgage, AppColors.MortgageColor, TransactionType.EXPENSE),
    GROCERIES(R.string.groceries, AppColors.GroceriesColor, TransactionType.EXPENSE),
    DINING_OUT(R.string.dining_out, AppColors.DiningOutColor, TransactionType.EXPENSE),
    SHOPPING(R.string.shopping, AppColors.ShoppingColor, TransactionType.EXPENSE),
    ENTERTAINMENT(R.string.entertainment, AppColors.EntertainmentColor, TransactionType.EXPENSE),
    HEALTH(R.string.health, AppColors.HealthColor, TransactionType.EXPENSE),
    EDUCATION(R.string.education, AppColors.EducationColor, TransactionType.EXPENSE),
    INSURANCE(R.string.insurance, AppColors.InsuranceColor, TransactionType.EXPENSE),
    DEBT_PAYMENTS(R.string.debt_payments, AppColors.DebtPaymentsColor, TransactionType.EXPENSE),
    CHARITIES(R.string.charities, AppColors.CharitiesColor, TransactionType.EXPENSE),
    TRANSPORT(titleResId = R.string.transport, color = AppColors.TransportColor, TransactionType.EXPENSE),
    HEALTHCARE(titleResId = R.string.healthcare, color = AppColors.HealthcareColor, TransactionType.EXPENSE),
    PERSONAL(titleResId = R.string.personal, color = AppColors.PersonalColor, TransactionType.EXPENSE),
    UTILITIES(titleResId = R.string.bills_utilities, color = AppColors.BillsUtilitiesColor, TransactionType.EXPENSE),
    FOOD(titleResId = R.string.food, color = AppColors.FoodColor, TransactionType.EXPENSE),
    INVESTMENT(titleResId = R.string.investment, color = AppColors.InvestmentColor, TransactionType.EXPENSE),
    INSTALLMENTS(titleResId = R.string.installments, color = AppColors.InstallmentsColor, TransactionType.EXPENSE),
    OTHER_EXPENSES(R.string.other_expenses, AppColors.OthersColor, TransactionType.EXPENSE),

    UNDEFINED(titleResId = R.string.undefined, color = AppColors.UndefinedColor, TransactionType.EXPENSE),
    ;

    companion object {
        fun fromType(name: String): Category = Category.entries.find { it.name == name } ?: UNDEFINED
    }
}
