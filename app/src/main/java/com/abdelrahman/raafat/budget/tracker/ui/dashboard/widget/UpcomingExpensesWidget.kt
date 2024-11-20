package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.UpcomingExpenses
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency
import com.abdelrahman.raafat.budget.tracker.utils.toFormattedDate

@Composable
fun UpcomingExpensesWidget(
    item: UpcomingExpenses,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier.size(51.dp),
                painter = painterResource(item.iconRes),
                contentDescription = "",
            )
            Spacer(Modifier.width(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = item.date.toFormattedDate(DatePatterns.DATE_DAY_MONTH_YEAR),
                    style =
                        AppTextStyles.textStyle12SPNormal.copy(
                            color = AppColors.LightText,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 15.sp,
                        ),
                )

                Text(
                    text = item.title,
                    style = AppTextStyles.textStyle15SPMedium,
                )

                Text(
                    text = item.price.formatWithCurrency(),
                    style = AppTextStyles.textStyle14SPNormal,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UpcomingExpensesWidgetPreview() {
    BudgetTrackerTheme {
        Column(
            modifier =
                Modifier
                    .padding(10.dp),
        ) {
            val item =
                UpcomingExpenses(
                    title = "LinkedIn Subscription",
                    date = System.currentTimeMillis(),
                    price = 30.0,
                    iconRes = R.drawable.ic_onboarding_1,
                )
            UpcomingExpensesWidget(item)
        }
    }
}
