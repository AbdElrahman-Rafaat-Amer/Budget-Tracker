package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun TransactionsSection(
    modifier: Modifier = Modifier,
    transactionsList: List<TransactionItems>,
    onFinancialReportCardClicked: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FilterRow(
            modifier = Modifier.fillMaxWidth()
        )

        // Finical Report
        FinancialReportCard {
            onFinancialReportCardClicked()
        }

        // Transactions
        TransactionsList(transactionsList)
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
fun TransactionsSectionPreview() {
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

        val transactionsList: MutableList<Transaction> = mutableListOf()
        repeat(10) { index ->
            transactionsList.add(
                item.copy(
                    name = item.name + index,
                    description = item.description + index,
                    date = item.date - index * 10000,
                    amount = item.amount * index,
                    isExpense = index % 2 == 0,
                ),
            )
        }
        TransactionsSection(
            modifier = Modifier.padding(16.dp),
            transactionsList = listOf(
                TransactionItems.DayNameItem("Today"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Yesterday"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Week ago"),
                TransactionItems.TransactionItem(transactionsList),
            ),
        ) {}
    }
}
