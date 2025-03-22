package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.core.text.isDigitsOnly
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.transparentTextFieldColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun AmountInputSection(amount: MutableState<String>) {
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
        onValueChange = { newValue ->
            if (newValue.isDigitsOnly() && newValue.length <= maxChars) {
                amount.value = newValue
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
@Preview
@Composable
private fun AmountInputSectionPreview() {
    BudgetTrackerTheme {
        val amount = remember { mutableStateOf("") }
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            AmountInputSection(amount)
        }
    }
}
