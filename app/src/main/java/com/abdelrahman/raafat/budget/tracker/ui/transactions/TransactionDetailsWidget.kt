package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency
import com.abdelrahman.raafat.budget.tracker.utils.toFormattedDate

@Suppress("FunctionName")
@Composable
fun TransactionDetailsWidget(
    transactionItem: TransactionItem,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(20.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 17.dp, horizontal = 20.dp),
        ) {
            // Title & Desc
            Column(verticalArrangement = Arrangement.spacedBy(13.dp)) {
                Text(
                    text = transactionItem.name,
                    style = AppTextStyles.textStyle16SPMedium,
                )
                Text(
                    text = transactionItem.description,
                    style =
                        AppTextStyles.textStyle13SPMedium.copy(
                            color = AppColors.Gray,
                        ),
                )
            }

            // Price & Time
            Column(
                verticalArrangement = Arrangement.spacedBy(13.dp),
                horizontalAlignment = Alignment.End,
            ) {
                val (priceColor, pricePrefix) = if (transactionItem.isExpense) AppColors.Red to "- " else AppColors.Green to "+ "
                Text(
                    text = "$pricePrefix${transactionItem.price.formatWithCurrency()}",
                    style =
                        AppTextStyles.textStyle16SPMedium.copy(
                            color = priceColor,
                        ),
                )

                // TODO Future Enhancement to show the date format based on the user setting
                Text(
                    text = transactionItem.date.toFormattedDate(DatePatterns.TIME_HOUR_MINUTE),
                    style =
                        AppTextStyles.textStyle13SPMedium.copy(
                            color = AppColors.Gray,
                        ),
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun TransactionDetailsWidgetPreview() {
    BudgetTrackerTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp),
//            modifier = Modifier.padding(20.dp)
        ) {
//            TransactionDetailsWidget(
//                TransactionItem(
//                    name = "Shopping",
//                    description = "Buy some grocery",
//                    date = System.currentTimeMillis(),
//                    price = 5120.0,
//                    isExpense = true
//                )
//            )

            TransactionDetailsWidget(
                TransactionItem(
                    name = "Salary",
                    description = "Salary for  August",
                    date = System.currentTimeMillis() - 10000,
                    price = 5000.0,
                    isExpense = false,
                    category = Category.BILLS_UTILITIES,
                ),
            )
        }
    }
}
