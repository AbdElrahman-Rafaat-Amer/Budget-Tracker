package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTLottie
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.airbnb.lottie.compose.LottieConstants

@Suppress("FunctionName")
@Composable
fun TransactionScreen(
    transactionsList: List<TransactionItems>,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
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
            TransactionsSection(transactionsList)
        }
    }
}

@Suppress("FunctionName")
@Composable
private fun EmptyTransactionsSection() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BTLottie(
            lottieRes = R.raw.empty_transaction,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.weight(1f),
        )

        Text(
            text = stringResource(R.string.no_transactions_title),
            style =
                AppTextStyles.textStyle18SPBold.copy(
                    color = MaterialTheme.colorScheme.primary,
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.no_transactions_message),
            style =
                AppTextStyles.textStyle14SPNormal.copy(
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center,
                ),
        )
    }
}

@Suppress("FunctionName")
@Composable
private fun TransactionsSection(transactionsList: List<TransactionItems>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        // Finical Report
        Card(
            shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
            colors = CardDefaults.cardColors(containerColor = AppColors.LightLavender),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium.copy(CornerSize(8.dp)))
                    .clickable {
                    },
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
            ) {
                Text(stringResource(R.string.see_financial_report))

                Image(painter = painterResource(R.drawable.ic_forward), contentDescription = "")
            }
        }

        // Transactions
        LazyColumn {
            items(transactionsList) { item ->
                when (item) {
                    is TransactionItems.TransactionItem -> {
                        item.transactions.forEach {
                            TransactionDetailsWidget(
                                it,
                                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                            )
                        }
                    }

                    is TransactionItems.DayNameItem -> {
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = item.dayName,
                            style = AppTextStyles.textStyle18SPSemiBold,
                            modifier = Modifier.padding(8.dp),
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
private fun TransactionScreenPreview() {
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
        ) {}
    }
}
