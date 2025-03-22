package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransactionsList(transactionsList: List<TransactionItems>) {
    LazyColumn {
        transactionsList.forEach { item ->
            when (item) {
                is TransactionItems.TransactionItem -> {
                    items(item.transactions) {
                        Spacer(Modifier.height(10.dp))
                        TransactionDetailsWidget(
                            it,
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                        )
                    }
                }

                is TransactionItems.DayNameItem -> {
                    stickyHeader {
                        Text(
                            text = item.dayName,
                            style = AppTextStyles.textStyle18SPSemiBold,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(8.dp),
                        )
                    }
                }
            }
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun TransactionsListPreview() {
    BudgetTrackerTheme {
        val item =
            Transaction(
                name = "Shopping",
                description = "Buy some grocery",
                date = System.currentTimeMillis(),
                amount = 10.0,
                isExpense = true,
                paymentMethod = PaymentMethod.CASH,
                category = Category.UTILITIES,
            )

        val transactionsList =
            (1..10).map { index ->
                item.copy(
                    name = item.name + index,
                    description = item.description + index,
                    date = item.date - index * 10000,
                    amount = item.amount * index,
                    isExpense = index % 2 == 0,
                )
            }
        TransactionsList(
            listOf(
                TransactionItems.DayNameItem("Today"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Yesterday"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Week ago"),
                TransactionItems.TransactionItem(transactionsList),
            ),
        )
    }
}
