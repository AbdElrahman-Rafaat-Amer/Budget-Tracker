package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

data class Transaction(
    var title: String,
    var category: Category,
    var date: Long,
    var price: Double,
)
