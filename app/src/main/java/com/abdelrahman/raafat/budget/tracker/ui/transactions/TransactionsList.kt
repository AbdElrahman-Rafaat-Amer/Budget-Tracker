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
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles

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
