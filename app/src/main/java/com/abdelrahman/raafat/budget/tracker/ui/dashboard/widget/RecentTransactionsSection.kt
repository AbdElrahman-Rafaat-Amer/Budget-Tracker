package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTSectionTitle
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency
import com.abdelrahman.raafat.budget.tracker.utils.toFormattedDate

@Suppress("FunctionName")
@Composable
fun RecentTransactionsSection(
    item: DashboardItems.RecentTransactionsItem,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(7.dp),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp, bottom = 15.dp, start = 15.dp, end = 15.dp),
        ) {
            // Section Title with "See All" Button
            BTSectionTitle(
                title = stringResource(R.string.recent_transactions),
                showSeeAll = false,
            )
            Spacer(Modifier.height(10.dp))
            item.recentTransactions.forEachIndexed { index, transaction ->
                TransactionRow(transaction = transaction, isAlternateRow = index % 2 != 0)
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
fun TransactionRow(
    transaction: TransactionItem,
    isAlternateRow: Boolean,
) {
    val backgroundColor = if (isAlternateRow) AppColors.Transparent else AppColors.White
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(backgroundColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Date
        Text(
            text = transaction.date.toFormattedDate(DatePatterns.DAY_MONTH_ABBREVIATION),
            style = AppTextStyles.textStyle12SPNormal.copy(color = AppColors.LightText),
            modifier = Modifier.weight(0.2f),
        )

        Spacer(Modifier.width(10.dp))

        // Title
        Text(
            text = setupTitle(transaction),
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f),
            lineHeight = 20.sp,
        )

        Spacer(Modifier.width(10.dp))

        // Price
        val (priceColor, pricePrefix) = if (transaction.isExpense) AppColors.Red to "- " else AppColors.Green to "+ "
        Text(
            text = "$pricePrefix${transaction.price.formatWithCurrency()}",
            style =
                AppTextStyles.textStyle16SPMedium.copy(
                    color = priceColor,
                ),
        )
    }
}

private fun setupTitle(transition: TransactionItem): AnnotatedString =
    buildAnnotatedString {
        withStyle(
            style =
                SpanStyle(
                    fontWeight = FontWeight.Medium,
                    color = AppColors.Black,
                    fontSize = 15.sp,
                ),
        ) {
            append(transition.name)
        }

        append("\n")
        withStyle(
            style =
                SpanStyle(
                    fontWeight = FontWeight.Normal,
                    color = AppColors.LightText,
                    fontSize = 13.sp,
                ),
        ) {
            append(transition.category.toString())
        }
    }

@Suppress("FunctionName")
@Preview
@Composable
private fun RecentTransactionsSectionPreview() {
    BudgetTrackerTheme {
        val recentTransactionsItem = DashboardItems.RecentTransactionsItem(recentTransactions = emptyList())
        val item =
            TransactionItem(
                name = "Door Handle Replacement",
                description = "Door Handle Replacement desc",
                category = Category.BILLS_UTILITIES,
                date = System.currentTimeMillis(),
                price = 20.0,
                isExpense = false,
            )
        val listItems: MutableList<TransactionItem> = mutableListOf()
        repeat(10) {
            listItems.add(
                item.copy(
                    name = "${item.name} $it",
                    price = item.price * it,
                    date = item.date * it,
                ),
            )
        }
        recentTransactionsItem.recentTransactions = listItems
        RecentTransactionsSection(recentTransactionsItem)
    }
}
