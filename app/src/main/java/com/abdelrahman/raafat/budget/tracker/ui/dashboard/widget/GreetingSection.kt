package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTProgressCard
import com.abdelrahman.raafat.budget.tracker.ui.custom.CustomIndicator
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.RemainingDay
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.formatToCustomPattern
import com.abdelrahman.raafat.budget.tracker.utils.getDynamicGreeting
import com.abdelrahman.raafat.budget.tracker.utils.getPastAndRemainingDays
import com.abdelrahman.raafat.budget.tracker.utils.getRemainingWeekDays
import com.abdelrahman.raafat.budget.tracker.utils.getRemainingWeekends
import java.time.LocalDate
import java.time.LocalTime

@Suppress("FunctionName")
@Composable
fun GreetingSection(userName: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = LocalTime.now().getDynamicGreeting(),
            style = AppTextStyles.textStyle18SPNormal
        )
        Spacer(Modifier.height(3.dp))

        Text(
            text = userName,
            style = AppTextStyles.textStyle28SPMedium
        )
        Spacer(Modifier.height(3.dp))
        Text(
            text = LocalDate.now().formatToCustomPattern(),
            style = AppTextStyles.textStyle14SPNormalItalic
                .copy(
                    color = AppColors.LightText
                ),
        )

        Spacer(Modifier.height(18.dp))

        val (pastDays, remainingDays) = LocalDate.now().getPastAndRemainingDays()
        val totalDaysInMonth = pastDays + remainingDays
        BTProgressCard(
            percentage = pastDays / totalDaysInMonth,
            remainingDays = remainingDays
        )

        Spacer(Modifier.height(7.dp))
        Text(
            stringResource(R.string.remaining_days),
            style = AppTextStyles.textStyle13SPNormalItalic,
        )
        Spacer(Modifier.height(7.dp))

        val remainingWeekDays = LocalDate.now().getRemainingWeekDays()
        val remainingWeekendDays = LocalDate.now().getRemainingWeekends()
        val remainingDaysList = listOf(
            RemainingDay(
                days = remainingWeekDays,
                color = AppColors.OceanBlue,
                text = pluralStringResource(
                    id = R.plurals.weekdays,
                    count = remainingWeekDays,
                    remainingWeekDays
                )
            ),
            RemainingDay(
                days = remainingWeekendDays,
                color = AppColors.Green,
                text = pluralStringResource(
                    id = R.plurals.weekends,
                    count = remainingWeekendDays,
                    remainingWeekendDays
                )
            )

        )
        Column (verticalArrangement = Arrangement.spacedBy(4.dp)) {
            remainingDaysList.forEach{ item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    CustomIndicator(
                        borderColor = item.color,
                        color = item.color,
                    )
                    Text(
                        item.text,
                        style = AppTextStyles.textStyle13SPNormal,
                    )
                }
            }
        }

    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun GreetingSectionPreview() {
    BudgetTrackerTheme {
        GreetingSection("Abdoooooo")
    }
}
