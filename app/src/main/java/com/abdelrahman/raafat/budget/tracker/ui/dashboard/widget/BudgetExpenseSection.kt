package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTArc
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.BudgetExpense
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.formatToCustomPattern
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency
import java.time.LocalDate

@Suppress("FunctionName")
@Composable
fun BudgetExpenseSection(
    budgetExpenseItem: DashboardItems.BudgetExpenseItem,
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
                text = stringResource(R.string.budget_vs_expense),
                style = AppTextStyles.textStyle21SPBold,
            )

            Spacer(Modifier.height(5.dp))

            val currentDate = LocalDate.now().formatToCustomPattern(DatePatterns.DAY_MONTH)
            Text(
                text = stringResource(R.string.from, "01", currentDate),
                style = AppTextStyles.textStyle13SPNormalItalic,
            )

            Spacer(Modifier.height(10.dp))

            Box {
                BTArc(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .aspectRatio(2f),
                    angleValue = budgetExpenseItem.item.angleValue,
                )

                Text(
                    text =
                        setupBudgetText(
                            budgetExpenseItem.item.price,
                            budgetExpenseItem.item.totalPrice,
                        ),
                    lineHeight = 30.sp,
                    color = AppColors.LightText,
                    textAlign = TextAlign.Center,
                    modifier =
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 20.dp),
                )
            }
        }
    }
}

@Composable
private fun setupBudgetText(
    price: Double,
    totalPrice: Double,
) = buildAnnotatedString {
    withStyle(
        style =
            SpanStyle(
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
            ),
    ) {
        append(price.formatWithCurrency())
    }
    append("\n")
    withStyle(
        style =
            SpanStyle(
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic,
                fontSize = 19.sp,
            ),
    ) {
        append(stringResource(R.string.of))
        append(" ")
        append(totalPrice.formatWithCurrency())
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun BudgetExpenseSectionPreview() {
    BudgetTrackerTheme {
        val item =
            DashboardItems.BudgetExpenseItem(
                item =
                    BudgetExpense(
                        price = -20.0,
                        totalPrice = 160.0,
                    ),
            )
        BudgetExpenseSection(item)
    }
}
