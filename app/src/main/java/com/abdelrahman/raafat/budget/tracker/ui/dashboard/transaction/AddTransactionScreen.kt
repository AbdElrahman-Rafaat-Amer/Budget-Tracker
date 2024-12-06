package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseScreen
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTPrimaryButton
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun AddTransactionScreen(
    modifier: Modifier = Modifier,
    transactionType: TransactionType = TransactionType.Income,
    onBackButtonClicked: () -> Unit,
) {
    val (titleResId, backGroundColor) =
        if (transactionType == TransactionType.Income) {
            R.string.income to AppColors.Green
        } else {
            R.string.expense to AppColors.Red
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
                value = "",
                onValueChange = {},
                textStyle = textStyle,
                placeholder = {
                    Text(
                        text = "0",
                        style = textStyle,
                    )
                },
                prefix = {
                    Text(
                        "$",
                        style = textStyle,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors =
                    TextFieldDefaults.colors(
                        unfocusedIndicatorColor = AppColors.Transparent,
                        focusedIndicatorColor = AppColors.Transparent,
                        unfocusedContainerColor = AppColors.Transparent,
                        focusedContainerColor = AppColors.Transparent,
                    ),
            )

            Spacer(Modifier.height(30.dp))
            // White bottom view
            Column(
                modifier =
                    Modifier
                        .background(
                            color = AppColors.White,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                        ).weight(1f)
                        .padding(vertical = 24.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                val descriptionTextStyle =
                    AppTextStyles.textStyle16SPNormal.copy(
                        lineHeight = 18.sp,
                        color = AppColors.PlaceholderColor,
                    )

                // Category
                OutlinedTextField(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(AppColors.White)
                            .border(1.dp, AppColors.BorderColor, RoundedCornerShape(16.dp)),
                    value = "",
                    onValueChange = {},
                    textStyle = descriptionTextStyle,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.category),
                            style = descriptionTextStyle,
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors =
                        TextFieldDefaults.colors(
                            unfocusedIndicatorColor = AppColors.Transparent,
                            focusedIndicatorColor = AppColors.Transparent,
                            unfocusedContainerColor = AppColors.Transparent,
                            focusedContainerColor = AppColors.Transparent,
                        ),
                )

                // Description
                OutlinedTextField(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(AppColors.White)
                            .border(1.dp, AppColors.BorderColor, RoundedCornerShape(16.dp)),
                    value = "",
                    onValueChange = {},
                    textStyle = descriptionTextStyle,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.description),
                            style = descriptionTextStyle,
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors =
                        TextFieldDefaults.colors(
                            unfocusedIndicatorColor = AppColors.Transparent,
                            focusedIndicatorColor = AppColors.Transparent,
                            unfocusedContainerColor = AppColors.Transparent,
                            focusedContainerColor = AppColors.Transparent,
                        ),
                )

                // Payment way
                OutlinedTextField(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(AppColors.White)
                            .border(1.dp, AppColors.BorderColor, RoundedCornerShape(16.dp)),
                    value = "",
                    onValueChange = {},
                    textStyle = descriptionTextStyle,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.payment_way),
                            style = descriptionTextStyle,
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors =
                        TextFieldDefaults.colors(
                            unfocusedIndicatorColor = AppColors.Transparent,
                            focusedIndicatorColor = AppColors.Transparent,
                            unfocusedContainerColor = AppColors.Transparent,
                            focusedContainerColor = AppColors.Transparent,
                        ),
                )

                Spacer(Modifier.weight(1f))
                BTPrimaryButton(
                    text = stringResource(R.string.save),
                    isAllCaps = false,
                ) { }
            }
        }
    }
}

sealed class TransactionType {
    data object Expense : TransactionType()

    data object Income : TransactionType()
}

@Suppress("FunctionName")
@Preview
@Composable
fun AddTransactionScreenPreview() {
    BudgetTrackerTheme {
        AddTransactionScreen {
        }
    }
}
