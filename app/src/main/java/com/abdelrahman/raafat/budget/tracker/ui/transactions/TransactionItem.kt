package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category

@Entity(tableName = "transaction")
data class TransactionItem(
    var name: String,
    var category: Category,
    var description: String,
    @PrimaryKey
    var date: Long,
    var amount: Double,
    var isExpense: Boolean,
)
