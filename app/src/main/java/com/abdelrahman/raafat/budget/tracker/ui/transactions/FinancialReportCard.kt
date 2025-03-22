package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.theme.ThemesPreviews

@Suppress("FunctionName")
@Composable
fun FinancialReportCard(onItemClicked: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.LightLavender),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier =
            Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 48.dp)
                .clip(MaterialTheme.shapes.medium.copy(CornerSize(8.dp)))
                .clickable {
                    onItemClicked()
                },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
        ) {
            Text(stringResource(R.string.see_financial_report))

            Image(painter = painterResource(R.drawable.ic_forward), contentDescription = "")
        }
    }
}

@ThemesPreviews
@Suppress("FunctionName")
@Composable
private fun FinancialReportCardPreview() {
    BudgetTrackerTheme {
        FinancialReportCard {}
    }
}
