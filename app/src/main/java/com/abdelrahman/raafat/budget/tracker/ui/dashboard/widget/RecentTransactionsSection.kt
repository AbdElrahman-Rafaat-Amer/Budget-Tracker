package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.DashboardItems
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Transaction
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.DatePatterns
import com.abdelrahman.raafat.budget.tracker.utils.toFormattedDate

@Composable
fun RecentTransactionsSection(item: DashboardItems.RecentTransactionsItem) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(item.items) { transition ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = transition.date.toFormattedDate(DatePatterns.DAY_MONTH)
                )

                Text(
                    text = setupTitle(transition),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = transition.price.toString()
                )
            }
        }
    }

}

fun setupTitle(transition: Transaction): AnnotatedString {
return buildAnnotatedString {
    append(transition.title)
    append("\n")
    append(transition.category.toString())
}
}


@Preview(showBackground = true)
@Composable
private fun RecentTransactionsSectionPreview() {
    BudgetTrackerTheme {
        val item = DashboardItems.RecentTransactionsItem(
            items =
            listOf(
                Transaction(
                    title = "Door Handle Replacement",
                    category = Category.BILLS_UTILITIES,
                    date = System.currentTimeMillis(),
                    price = 20.0,
                ),
                Transaction(
                    title = "Nike Running Shoe",
                    category = Category.PERSONAL,
                    date = System.currentTimeMillis() - 200000,
                    price = 20.0,
                ),
                Transaction(
                    title = "Mutual Fund",
                    category = Category.INVESTMENT,
                    date = System.currentTimeMillis() - 100000,
                    price = 20.0,
                ),
            )
        )
        RecentTransactionsSection(item)
    }
}