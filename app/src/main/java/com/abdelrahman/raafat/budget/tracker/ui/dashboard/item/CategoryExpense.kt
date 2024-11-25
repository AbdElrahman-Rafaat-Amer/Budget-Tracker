package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import androidx.annotation.DrawableRes

data class CategoryExpense(
    var title: String,
    @DrawableRes var iconRes: Int,
    var iconBackgroundColor: Int = -1,
    var price: Double,
    var totalPrice: Double,
)
