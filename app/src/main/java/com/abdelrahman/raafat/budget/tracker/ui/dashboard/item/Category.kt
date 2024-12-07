package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

import androidx.annotation.StringRes
import com.abdelrahman.raafat.budget.tracker.R

enum class Category(
    @StringRes val titleResId: Int,
) {
    BILLS_UTILITIES(R.string.bills_utilities),
    FOOD(R.string.food),
    PERSONAL(R.string.personal),
    HEALTHCARE(R.string.healthcare),
    EDUCATION(R.string.education),
    TRANSPORT(R.string.transport),
    INVESTMENT(R.string.investment),
    INSTALLMENTS(R.string.installments),
    OTHER(R.string.other),
}
