package com.abdelrahman.raafat.budget.tracker.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.abdelrahman.raafat.budget.tracker.R
import java.time.LocalTime


// Extension function to generate a dynamic greeting message based on the current time
@Composable
fun LocalTime.getDynamicGreeting(): String {
    return when {
        this.isBefore(LocalTime.NOON) -> stringResource(R.string.good_morning)
        this.isBefore(LocalTime.of(18, 0)) -> stringResource(R.string.good_afternoon)
        else -> stringResource(R.string.good_evening)
    }
}