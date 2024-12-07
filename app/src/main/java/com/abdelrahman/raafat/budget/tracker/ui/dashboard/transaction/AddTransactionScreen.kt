package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTDropDownMenu
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTOutlinedTextField
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTPrimaryButton
import com.abdelrahman.raafat.budget.tracker.ui.custom.transparentTextFieldColors
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun AddTransactionScreen(
    transactionType: TransactionType = TransactionType.INCOME,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
) {
    val amount = remember { mutableStateOf("") }
    val category = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val paymentWay = remember { mutableStateOf("") }

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
                description = description,
                paymentMethod = paymentWay,
                transactionType = transactionType,
                isEnabled = amount.value.isNotEmpty() && category.value.isNotEmpty() && paymentWay.value.isNotEmpty(),
            )
        }
    }
}

@Suppress("FunctionName")
@Composable
private fun AmountInputSection(amount: MutableState<String>) {
    val maxChars = 10
    Text(
        text = stringResource(R.string.how_much),
        style =
            AppTextStyles.textStyle18SPSemiBold.copy(
                lineHeight = 21.sp,
                color = AppColors.BottomNavigationColor.copy(alpha = 0.64f),
            ),
        modifier = Modifier.padding(start = 20.dp),
    )

    // Amount TextField
    val textStyle =
        AppTextStyles.textStyle64SPSemiBold.copy(
            color = AppColors.BottomNavigationColor,
        )
    TextField(
        value = amount.value,
        onValueChange = {
            if (it.length <= maxChars) {
                amount.value = it
            }
        },
        textStyle = textStyle,
        placeholder = { Text(text = "0", style = textStyle) },
        prefix = { Text("$", style = textStyle) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = transparentTextFieldColors(),
    )
}

@Suppress("FunctionName")
@Composable
private fun TransactionDetailsSection(
    modifier: Modifier,
    category: MutableState<String>,
    description: MutableState<String>,
    paymentMethod: MutableState<String>,
    isEnabled: Boolean,
    transactionType: TransactionType,
) {
    Column(
        modifier =
            modifier
                .background(
                    color = AppColors.White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                ).padding(vertical = 24.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val textStyle =
            AppTextStyles.textStyle16SPNormal.copy(
                lineHeight = 18.sp,
            )

        val placeHolderTextStyle =
            textStyle.copy(
                color = AppColors.PlaceholderColor,
            )

        // category
        val categories = Category.entries.map { stringResource(it.titleResId) }
        BTDropDownMenu(
            value = category,
            menuItems = categories,
            textStyle = textStyle,
            placeHolderTextStyle = placeHolderTextStyle,
            placeholderText = stringResource(R.string.category),
            onItemSelected = { title ->
                category.value = title
            },
        )

        // payment method
        val paymentMethods =
            PaymentMethod.entries
                .filter { it.type == transactionType }
                .map { stringResource(it.titleResId) }
        BTDropDownMenu(
            value = paymentMethod,
            textStyle = textStyle,
            placeHolderTextStyle = placeHolderTextStyle,
            menuItems = paymentMethods,
            placeholderText = stringResource(R.string.payment_way),
            onItemSelected = { title ->
                paymentMethod.value = title
            },
        )
        // description
        BTOutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            placeholderText = stringResource(R.string.description),
            textStyle = textStyle,
            placeholderTextStyle = placeHolderTextStyle,
            onClick = {},
        )

        Spacer(Modifier.weight(1f))
        BTPrimaryButton(
            text = stringResource(R.string.save),
            isAllCaps = false,
            isEnabled = isEnabled,
        ) {
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
