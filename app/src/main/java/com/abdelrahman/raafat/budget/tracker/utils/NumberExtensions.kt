package com.abdelrahman.raafat.budget.tracker.utils

import java.text.NumberFormat
import java.util.Locale

/**
 * Converts an angle in degrees to radians.
 *
 * @receiver [Number] The angle in degrees to be converted.
 * @return A [Double] value representing the angle in radians.
 * @see Math.toRadians
 */
fun Number.degreeToRadian(): Double = Math.toRadians(this.toDouble())

/**
 * Extension function to format a [Number] with commas, decimal places, and an optional currency symbol.
 *
 * @receiver [Number] The number to be formatted.
 * @param currency The optional currency symbol to prefix the formatted number. Defaults to an empty string.
 * @return A [String] representation of the formatted number with commas, decimal places, and optional currency symbol.
 */
fun Number.formatWithCurrency(currency: String = "\$"): String {
    val numberFormat = NumberFormat.getNumberInstance(Locale.US)
    numberFormat.maximumFractionDigits = 2 // Limit to 2 decimal places
    val formattedNumber = numberFormat.format(this)
    val formattedPrice =
        if (currency.trim().isEmpty()) {
            formattedNumber
        } else {
            "$currency$formattedNumber"
        }
    return formattedPrice
}
