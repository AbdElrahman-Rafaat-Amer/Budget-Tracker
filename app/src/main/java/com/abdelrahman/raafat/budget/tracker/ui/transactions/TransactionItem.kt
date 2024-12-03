package com.abdelrahman.raafat.budget.tracker.ui.transactions

import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import kotlinx.serialization.Serializable

@Serializable
data class TransactionItem(
    var name: String,
    var category: Category,
    var description: String,
    var date: Long,
    var price: Double,
    var isExpense: Boolean,
)
