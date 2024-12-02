package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTChart
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTIndicatorRow
import com.abdelrahman.raafat.budget.tracker.ui.custom.ChartData
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.ExpenseDistribution
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.formatToCustomPattern
import java.time.LocalDateTime

@Suppress("FunctionName")
@Composable
fun ExpenseDistributionSection(
    expenseDistributionItem: DashboardItems.ExpenseDistributionItem,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier =
                Modifier
                    .padding(top = 7.dp, bottom = 15.dp, start = 15.dp, end = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = stringResource(R.string.expense_distribution),
                style = AppTextStyles.textStyle21SPBold,
            )
            Spacer(Modifier.height(5.dp))
            val currentDate = LocalDateTime.now().formatToCustomPattern(DatePatterns.DAY_MONTH)
            Text(
                text = stringResource(R.string.from, "01", currentDate),
                style = AppTextStyles.textStyle13SPNormalItalic,
            )

            Spacer(Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Titles view
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    expenseDistributionItem.items.forEach { item ->
                        BTIndicatorRow(
                            borderColor = item.color,
                            indicatorColor = item.color,
                            text = item.name,
                            textStyle =
                                AppTextStyles.textStyle14SPNormal.copy(
                                    fontSize = 14.5.sp,
                                ),
                        )
                    }
                }

                // Chart View
                val expensesList =
                    expenseDistributionItem.items.map { item ->
                        ChartData(color = item.color, data = item.percentage)
                    }
                BTChart(
                    chartDataList = expensesList,
                    modifier =
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
fun ExpenseDistributionSectionPreview() {
    BudgetTrackerTheme {
        val item =
            DashboardItems.ExpenseDistributionItem(
                items =
                    listOf(
                        ExpenseDistribution(
                            name = "Bills & Utilities",
                            color = AppColors.BillsUtilitiesColor,
                            percentage = 27f,
                        ),
                        ExpenseDistribution(
                            name = "Food",
                            color = AppColors.FoodColor,
                            percentage = 12f,
                        ),
                        ExpenseDistribution(
                            name = "Personal",
                            color = AppColors.PersonalColor,
                            percentage = 11f,
                        ),
                        ExpenseDistribution(
                            name = "Healthcare",
                            color = AppColors.HealthcareColor,
                            percentage = 5f,
                        ),
                        ExpenseDistribution(
                            name = "Education",
                            color = AppColors.EducationColor,
                            percentage = 15f,
                        ),
                        ExpenseDistribution(
                            name = "Transport",
                            color = AppColors.TransportColor,
                            percentage = 8f,
                        ),
                        ExpenseDistribution(
                            name = "Investment",
                            color = AppColors.InvestmentColor,
                            percentage = 12f,
                        ),
                        ExpenseDistribution(
                            name = "Others",
                            color = AppColors.OthersColor,
                            percentage = 10f,
                        ),
                    ),
            )
        ExpenseDistributionSection(item)
    }
}
