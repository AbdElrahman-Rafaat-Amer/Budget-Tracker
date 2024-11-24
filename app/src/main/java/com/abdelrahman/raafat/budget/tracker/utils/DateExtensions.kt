package com.abdelrahman.raafat.budget.tracker.utils

import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
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
    const val DATE_DAY_MONTH_YEAR = "d MMMM yyyy" // Format: 22 August 2024
}

fun LocalDate.formatToCustomPattern(pattern: String = DatePatterns.DATE_DAY_MONTH): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return this.format(formatter)
}

// Extension function to get past and remaining days for the current date's month
fun LocalDate.getPastAndRemainingDays(): Pair<Int, Int> {
    // Get the total number of days in the current month
    val totalDaysInMonth = YearMonth.of(this.year, this.month).lengthOfMonth()

    // Calculate past and remaining days
    val pastDays = this.dayOfMonth - 1 // Exclude today from past days
    val remainingDays = totalDaysInMonth - this.dayOfMonth // Remaining days include today

    return Pair(pastDays, remainingDays)
}

// Extension function to calculate remaining weekends in the current month
fun LocalDate.getRemainingWeekends(
    weekendDays: List<DayOfWeek> =
        listOf(
            DayOfWeek.SATURDAY,
            DayOfWeek.FRIDAY,
        ),
): Int {
    // Get the last day of the current month
    val lastDayOfMonth = YearMonth.of(this.year, this.month).atEndOfMonth()

    // Start from today
    var currentDate = this
    var weekendCount = 0

    // Iterate through the remaining days of the month
    while (currentDate <= lastDayOfMonth) {
        // Check if the current day is one of the weekend days
        if (currentDate.dayOfWeek in weekendDays) {
            weekendCount++
        }
        currentDate = currentDate.plusDays(1) // Move to the next day
    }

    return weekendCount
}

// Extension function to calculate remaining week days in the current month
fun LocalDate.getRemainingWeekDays(
    weekendDays: List<DayOfWeek> =
        listOf(
            DayOfWeek.SATURDAY,
            DayOfWeek.FRIDAY,
        ),
): Int {
    // Get the last day of the current month
    val lastDayOfMonth = YearMonth.of(this.year, this.month).atEndOfMonth()

    // Start from today
    var currentDate = this
    var weekendCount = 0

    // Iterate through the remaining days of the month
    while (currentDate <= lastDayOfMonth) {
        // Check if the current day is one of the weekend days
        if (currentDate.dayOfWeek !in weekendDays) {
            weekendCount++
        }
        currentDate = currentDate.plusDays(1) // Move to the next day
    }

    return weekendCount
}

fun Long.toFormattedDate(
    pattern: String = DatePatterns.DATE_DAY_MONTH,
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(this), zoneId)
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    return dateTime.format(formatter)
}
