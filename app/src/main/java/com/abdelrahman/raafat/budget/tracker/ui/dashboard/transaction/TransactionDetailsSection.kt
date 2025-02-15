package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTDropDownMenu
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTOutlinedTextField
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTPrimaryButton
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun TransactionDetailsSection(
    modifier: Modifier,
    category: MutableState<Category>,
    paymentMethod: MutableState<PaymentMethod>,
    name: MutableState<String>,
    description: MutableState<String>,
    isEnabled: Boolean,
    transactionType: TransactionType,
    onButtonClicked: () -> Unit,
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
        val categories =
            Category.entries
                .filter { it.type == transactionType && it != Category.UNDEFINED }
        BTDropDownMenu(
            menuItems = categories,
            textStyle = textStyle,
            placeHolderTextStyle = placeHolderTextStyle,
            placeholderText = stringResource(R.string.category),
            onItemSelected = {
                category.value = it
            },
        )

        // payment method
        val paymentMethods = PaymentMethod.entries.toMutableList().dropLast(1)
        BTDropDownMenu(
            textStyle = textStyle,
            placeHolderTextStyle = placeHolderTextStyle,
            menuItems = paymentMethods,
            placeholderText = stringResource(R.string.payment_way),
            onItemSelected = {
                paymentMethod.value = it
            },
        )
        // name
        BTOutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            placeholderText = stringResource(R.string.name),
            textStyle = textStyle,
            placeholderTextStyle = placeHolderTextStyle,
            onClick = {},
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
            onButtonClicked.invoke()
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun TransactionDetailsSectionPreview() {
    BudgetTrackerTheme {
        val category = remember { mutableStateOf(Category.UNDEFINED) }
        val paymentMethod = remember { mutableStateOf(PaymentMethod.UNDEFINED) }
        val name = remember { mutableStateOf("") }
        val description = remember { mutableStateOf("") }

        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            TransactionDetailsSection(
                modifier = Modifier,
                category = category,
                paymentMethod = paymentMethod,
                name = name,
                description = description,
                isEnabled = true,
                transactionType = TransactionType.INCOME,
                onButtonClicked = { },
            )

            TransactionDetailsSection(
                modifier = Modifier,
                category = category,
                paymentMethod = paymentMethod,
                name = name,
                description = description,
                isEnabled = false,
                transactionType = TransactionType.INCOME,
                onButtonClicked = { },
            )
        }
    }
}
