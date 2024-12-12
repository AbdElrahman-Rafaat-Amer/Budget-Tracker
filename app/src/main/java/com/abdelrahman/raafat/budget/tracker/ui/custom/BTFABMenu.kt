package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun BTFabMenu(
    onDismiss: () -> Unit,
    onIncomeClick: () -> Unit,
    onTransferClick: () -> Unit,
    onExpenseClick: () -> Unit,
) {
    Box(
        modifier = Modifier.padding(top = 80.dp, bottom = 15.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            BTFab(
                fabColor = AppColors.Green,
                iconResID = R.drawable.ic_income,
                contentDescription = stringResource(R.string.income),
            ) {
                onDismiss()
                onIncomeClick()
            }

            BTFab(
                fabColor = AppColors.Blue,
                iconResID = R.drawable.ic_money_exchange,
                contentDescription = stringResource(R.string.transfer),
                fabModifier = Modifier.offset(y = (-60).dp),
            ) {
                onDismiss()
                onTransferClick()
            }

            BTFab(
                fabColor = AppColors.Red,
                iconResID = R.drawable.ic_expense,
                contentDescription = stringResource(R.string.expense),
            ) {
                onDismiss()
                onExpenseClick()
            }
        }
    }
}
