package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod

@Entity(tableName = "transaction")
data class TransactionItem(
    var name: String,
    var category: Category,
    var paymentMethod: PaymentMethod,
    var description: String,
    @PrimaryKey
    var date: Long,
    var amount: Double,
    var isExpense: Boolean,
)
