package com.abdelrahman.raafat.budget.tracker.ui.transactions

data class TransactionItem(
    var name: String,
    var description: String,
    var date: Long,
    var price: Double,
    var isExpense: Boolean,
)
