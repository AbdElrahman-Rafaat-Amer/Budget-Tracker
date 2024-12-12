package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

enum class TransactionType {
    EXPENSE,
    INCOME,
    ;

    companion object {
        fun fromType(name: String): TransactionType = entries.find { it.name == name } ?: INCOME
    }
}
