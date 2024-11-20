package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.CustomIndicator
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.formatToCustomPattern
import java.time.LocalDate

@Composable
fun GreetingSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(R.string.good_morning),
            color = AppColors.Black,
        )
        Text(
            text = "Abdooooooo",
            color = AppColors.Black,
        )
        Text(
            text = LocalDate.now().formatToCustomPattern(),
            color = AppColors.Black,
        )

        Text(
            "Remaining Days:",
            style = MaterialTheme.typography.displayLarge,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            CustomIndicator(
                borderColor = AppColors.OceanBlue,
                color = AppColors.OceanBlue,
            )
            Text(
                "05 Weekdays",
//                color = AppColors.Black,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            CustomIndicator(
                borderColor = AppColors.Green,
                color = AppColors.Green,
            )
            Text(
                "04 Weekends & Holidays",
//                color = AppColors.Black,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

@Preview
@Composable
private fun GreetingSectionPreview() {
    BudgetTrackerTheme {
        GreetingSection()
    }
}
