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
fun Number.formatWithCurrency(
    currency: String = "\$",
    isBefore: Boolean = true,
    maxFraction: Int = 2,
): String {
    val numberFormat = NumberFormat.getNumberInstance(Locale.US)
    numberFormat.maximumFractionDigits = maxFraction // Limit to 2 decimal places
    val formattedNumber = numberFormat.format(this)
    val formattedPrice =
        if (currency.trim().isEmpty()) {
            formattedNumber
        } else {
            if (isBefore) {
                "$currency$formattedNumber"
            } else {
                "$formattedNumber$currency"
            }
        }
    return formattedPrice
}

val Float.degreeToRadian
    get() = (this * Math.PI / 180f).toFloat()

val Float.asAngle: Float
    get() = this * 360f / 100f
