package com.abdelrahman.raafat.budget.tracker.ui.transactions


sealed class TransactionItems {
    data class DayNameItem(
        var dayName: String,
    ) : TransactionItems()

    data class TransactionItem(
        var transactions: List<Transaction>,
    ) : TransactionItems()

}