package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun TransactionScreen(
    transactionsList: List<TransactionItems>,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onFinancialReportCardClicked: () -> Unit,
    onTimeFilterSelected: (selectedOption: TransactionFilter) -> Unit,
    onFilterClicked: () -> Unit,
) {
    BTBaseScreen(
        title = stringResource(R.string.transactions),
        headerTextStyle = AppTextStyles.textStyle21SPBold.copy(textAlign = TextAlign.Center),
        removeIcon = true,
        verticalSpace = 20.dp,
        modifier = modifier.padding(vertical = 20.dp, horizontal = 15.dp),
        onBackButtonClicked = onBackButtonClicked,
    ) {
        if (transactionsList.isEmpty()) {
            EmptyTransactionsSection()
        } else {
            TransactionsSection(
                transactionsList = transactionsList,
                onFinancialReportCardClicked = onFinancialReportCardClicked,
                onTimeFilterSelected = {
                    onTimeFilterSelected(it)
                },
                onFilterClicked = onFilterClicked,
            )
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
fun TransactionScreenPreview() {
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
        TransactionScreen(
            listOf(
                TransactionItems.DayNameItem("Today"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Yesterday"),
                TransactionItems.TransactionItem(transactionsList),
                TransactionItems.DayNameItem("Week ago"),
                TransactionItems.TransactionItem(transactionsList),
            ),
            modifier = Modifier.padding(vertical = 10.dp),
            onBackButtonClicked = {},
            onFinancialReportCardClicked = {},
            onTimeFilterSelected = {},
            onFilterClicked = {},
        )
    }
}
