package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.annotation.StringRes
import com.abdelrahman.raafat.budget.tracker.R

enum class TransactionFilter(
    @StringRes val stringRes: Int,
) {
    TODAY(R.string.today),
    YESTERDAY(R.string.yesterday),
    WEEK(R.string.week),
    MONTH(R.string.month),
    THREE_MONTHS(R.string._3_months),
    SIX_MONTHS(R.string._6_months),
    YEAR(R.string.year),
    ALL_TIMES(R.string.all_times),
}
