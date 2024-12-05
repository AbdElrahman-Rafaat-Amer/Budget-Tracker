package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.abdelrahman.raafat.budget.tracker.R

sealed class BTBottomNavItem(
    val route: String,
    @DrawableRes val iconResId: Int,
    @StringRes val titleResId: Int,
) {
    data object Dashboard : BTBottomNavItem("dashboard", R.drawable.ic_home, R.string.dashboard)

    data object Transaction : BTBottomNavItem("transaction", R.drawable.ic_transaction, R.string.transaction)

    data object AddExpenses : BTBottomNavItem("expenses", R.drawable.ic_transaction, R.string.transaction)

    data object Budget : BTBottomNavItem("budget", R.drawable.ic_budget, R.string.budget)

    data object Profile : BTBottomNavItem("profile", R.drawable.ic_user_profile, R.string.profile)
}
