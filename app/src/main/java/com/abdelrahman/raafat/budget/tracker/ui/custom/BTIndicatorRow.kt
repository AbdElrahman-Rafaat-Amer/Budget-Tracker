package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTIndicatorRow(
    borderColor: Color,
    indicatorColor: Color,
    text: String,
    textStyle: TextStyle = AppTextStyles.textStyle13SPNormal,
    modifier: Modifier = Modifier,
    spacing: Dp = 4.dp,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacing),
    ) {
        BTCustomIndicator(
            borderColor = borderColor,
            color = indicatorColor,
        )
        Text(
            text = text,
            style = textStyle,
        )
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
fun BTIndicatorRowPreview() {
    BudgetTrackerTheme {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            BTIndicatorRow(
                borderColor = AppColors.Green,
                indicatorColor = AppColors.PersonalColor,
                text = "5 Weekdays",
            )

            BTIndicatorRow(
                borderColor = AppColors.OceanBlue,
                indicatorColor = AppColors.OceanBlue,
                text = "5 WeekEnds",
            )
        }
    }
}
