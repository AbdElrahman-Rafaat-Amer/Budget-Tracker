package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

data class BudgetExpense(
    var price: Double,
    var totalPrice: Double,
    var shouldAnimate: Boolean = price > 0 && totalPrice > 0,
)
