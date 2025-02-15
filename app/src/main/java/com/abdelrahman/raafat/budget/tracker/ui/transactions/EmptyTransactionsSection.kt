package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTLottie
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.airbnb.lottie.compose.LottieConstants

@Suppress("FunctionName")
@Composable
fun EmptyTransactionsSection() {
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
@Preview
@Composable
private fun EmptyTransactionsSectionPreview() {
    BudgetTrackerTheme {
        EmptyTransactionsSection()
    }
}
