package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

enum class Category(
    @StringRes val titleResId: Int,
    val color: Color,
) {
    BILLS_UTILITIES(titleResId = R.string.bills_utilities, color = AppColors.BillsUtilitiesColor),
    FOOD(titleResId = R.string.food, color = AppColors.FoodColor),
    PERSONAL(titleResId = R.string.personal, color = AppColors.PersonalColor),
    HEALTHCARE(titleResId = R.string.healthcare, color = AppColors.HealthcareColor),
    EDUCATION(titleResId = R.string.education, color = AppColors.EducationColor),
    TRANSPORT(titleResId = R.string.transport, color = AppColors.TransportColor),
    INVESTMENT(titleResId = R.string.investment, color = AppColors.InvestmentColor),
    INSTALLMENTS(titleResId = R.string.installments, color = AppColors.InstallmentsColor),
    OTHER(titleResId = R.string.other, color = AppColors.OthersColor);

    companion object {
        fun fromType(name: String): Category = Category.entries.find { it.name == name } ?: OTHER
    }
}
