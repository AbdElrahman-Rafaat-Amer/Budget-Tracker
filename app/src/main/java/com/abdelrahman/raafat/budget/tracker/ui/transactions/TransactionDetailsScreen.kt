package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun TransactionDetailsScreen(
    transactionsList: List<TransactionItem>,
    modifier: Modifier = Modifier,
) {
    BTBaseScreen(
        title = stringResource(R.string.transactions),
        verticalSpace = 30.dp,
        modifier = modifier,
    ) {
        LazyColumn {
            items(transactionsList) {
                TransactionDetailsWidget(
                    it,
                    modifier = Modifier.padding(vertical = 7.dp),
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun TransactionDetailsScreenPreview() {
    BudgetTrackerTheme {
        val item =
            TransactionItem(
                name = "Shopping",
                description = "Buy some grocery",
                date = System.currentTimeMillis(),
                price = 10.0,
                isExpense = true,
            )

        val transactionsList: MutableList<TransactionItem> = mutableListOf()
        repeat(10) { index ->
            transactionsList.add(
                item.copy(
                    name = item.name + index,
                    description = item.description + index,
                    date = item.date - index * 10000,
                    price = item.price * index,
                    isExpense = index % 2 == 0,
                ),
            )
        }
        TransactionDetailsScreen(
            transactionsList,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
        )
    }
}
