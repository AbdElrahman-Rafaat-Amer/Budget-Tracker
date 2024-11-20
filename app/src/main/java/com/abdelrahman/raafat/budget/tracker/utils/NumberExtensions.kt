package com.abdelrahman.raafat.budget.tracker.utils

fun Double.formatWithCurrency(): String {
    val formattedPrice =
        if (this % 1 == 0.0) {
            this.toLong().toString()
        } else {
            "%.2f".format(this)
        }
    return formattedPrice
}
