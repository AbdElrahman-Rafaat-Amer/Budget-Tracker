package com.abdelrahman.raafat.budget.tracker.utils

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object DatePatterns {
    // Full date and time formats
    const val FULL_DATE = "yyyy-MM-dd" // Full date (e.g., 2024-08-22)
    const val DATE_WITH_MONTH_NAME =
        "dd MMM yyyy" // Date with month abbreviation (e.g., 22 Aug 2024)
    const val FULL_DATE_TIME =
        "yyyy-MM-dd HH:mm:ss" // Full date and time (e.g., 2024-08-22 17:45:09)
    const val TIME_HOUR_MINUTE = "HH:mm" // Time in hours and minutes (e.g., 17:45)
    const val DATE_WITH_DAY =
        "EEEE, d MMMM yyyy" // Date with day name (e.g., Monday, 22 August 2024)
    const val DATE_TIME_AMPM =
        "d MMMM yyyy, h:mm a" // Date and time with AM/PM (e.g., 22 August 2024, 5:45 PM)
    const val DATE_DAY_MONTH = "EEEE, d MMMM" // Format: Monday, 22 August
    const val DAY_MONTH = "d MMMM" // Format: Monday, 22 August
}

fun LocalDate.formatToCustomPattern(pattern: String = DatePatterns.DATE_DAY_MONTH): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return this.format(formatter)
}

fun Long.toFormattedDate(
    pattern: String = DatePatterns.DATE_DAY_MONTH,
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(this), zoneId)
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return dateTime.format(formatter)
}
