package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction

@Suppress("FunctionName")
@Composable
fun AddTransactionScreen(
    transactionType: TransactionType = TransactionType.INCOME,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
) {
    val addTransactionViewModel: AddTransactionViewModel = viewModel()
    val amount = remember { mutableStateOf("") }
    val category = remember { mutableStateOf(Category.UNDEFINED) }
    val paymentMethod = remember { mutableStateOf(PaymentMethod.UNDEFINED) }
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    val (titleResId, backGroundColor) =
        when (transactionType) {
            TransactionType.EXPENSE -> {
                R.string.expense to AppColors.Red
            }

            TransactionType.INCOME -> {
                R.string.income to AppColors.Green
            }
        }

    BTBaseScreen(
        title = stringResource(titleResId),
        iconColor = AppColors.White,
        textColor = AppColors.White,
        verticalSpace = 70.dp,
        modifier =
            modifier
                .fillMaxWidth()
                .background(backGroundColor),
        headerModifier = Modifier.padding(20.dp),
        onBackButtonClicked = onBackButtonClicked,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize(),
        ) {
            // Amount Input
            AmountInputSection(amount)

            Spacer(Modifier.height(30.dp))

            TransactionDetailsSection(
                modifier = Modifier.weight(1f),
                category = category,
                paymentMethod = paymentMethod,
                name = name,
                description = description,
                transactionType = transactionType,
                isEnabled =
                    amount.value.isNotBlank() &&
                        category.value != Category.UNDEFINED &&
                        paymentMethod.value != PaymentMethod.UNDEFINED &&
                        name.value.isNotBlank(),
            ) {
                addTransactionViewModel.addTransaction(
                    Transaction(
                        name = name.value,
                        category = category.value,
                        paymentMethod = paymentMethod.value,
                        description = description.value,
                        date = System.currentTimeMillis(),
                        amount = amount.value.toDouble(),
                        isExpense = transactionType == TransactionType.EXPENSE,
                    ),
                )
                onBackButtonClicked.invoke()
            }
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun AddTransactionScreenPreview() {
    BudgetTrackerTheme {
        AddTransactionScreen {
        }
    }
}
