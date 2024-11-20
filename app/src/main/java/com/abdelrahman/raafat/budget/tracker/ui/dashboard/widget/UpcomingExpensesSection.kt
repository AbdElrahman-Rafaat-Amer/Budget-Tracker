package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.UpcomingExpenses
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Composable
fun UpcomingExpensesSection(item: DashboardItems.UpcomingExpensesItem) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.upcoming_expenses),
            style = AppTextStyles.textStyle21SPBold,
        )

        Spacer(Modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Group items into pairs for the two-column layout
            items(item.items.chunked(2)) { chunk ->
                Column(
                    modifier = Modifier.padding(horizontal = 1.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    chunk.forEach { upcomingItem ->
                        UpcomingExpensesWidget(
                            upcomingItem,
                            modifier =
                                Modifier
                                    .defaultMinSize(minWidth = 250.dp),
                        )
                    }

                    // Fill the gap if chunk size is less than 2 (for odd-sized lists)
                    if (chunk.size < 2) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UpcomingExpensesSectionPreview() {
    BudgetTrackerTheme {
        Column(
            modifier =
                Modifier
                    .padding(10.dp),
        ) {
            val item =
                DashboardItems.UpcomingExpensesItem(
                    items =
                        listOf(
                            UpcomingExpenses(
                                title = "LinkedIn Subscription",
                                date = System.currentTimeMillis(),
                                price = 30.0,
                                iconRes = R.drawable.ic_onboarding_1,
                            ),
                            UpcomingExpenses(
                                title = "Dota Plus: August",
                                date = System.currentTimeMillis() - 100000,
                                price = 40.0,
                                iconRes = R.drawable.ic_onboarding_2,
                            ),
                            UpcomingExpenses(
                                title = "Office 365 Subscription",
                                date = System.currentTimeMillis() - 200000,
                                price = 50.0,
                                iconRes = R.drawable.ic_onboarding_3,
                            ),
                            UpcomingExpenses(
                                title = "Waste Disposal Bill",
                                date = System.currentTimeMillis() - 300000,
                                price = 60.0,
                                iconRes = R.drawable.ic_launcher_foreground,
                            ),
                            UpcomingExpenses(
                                title = "Waste Disposal Bill",
                                date = System.currentTimeMillis() - 300000,
                                price = 60.0,
                                iconRes = R.drawable.ic_launcher_foreground,
                            ),
                        ),
                )
            UpcomingExpensesSection(item)
        }
    }
}
