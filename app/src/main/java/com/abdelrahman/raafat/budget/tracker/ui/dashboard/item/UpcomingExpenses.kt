package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import androidx.annotation.DrawableRes

data class UpcomingExpenses(
    var title: String,
    var date: Long,
    var price: Double,
    @DrawableRes var iconRes: Int,
)
