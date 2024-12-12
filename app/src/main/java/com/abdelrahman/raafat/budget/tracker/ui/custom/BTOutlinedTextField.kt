package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun BTOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    textStyle: TextStyle,
    isEnabled: Boolean = true,
    isClickable: Boolean = false,
    modifier: Modifier = Modifier,
    placeholderTextStyle: TextStyle = textStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit,
) {
    OutlinedTextField(
        enabled = isEnabled,
        modifier =
            modifier
                .fillMaxWidth()
                .background(AppColors.White)
                .border(1.dp, AppColors.BorderColor, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .clickable(enabled = isClickable) { onClick.invoke() },
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        textStyle = textStyle,
        placeholder = {
            Text(
                text = placeholderText,
                style = placeholderTextStyle,
            )
        },
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        colors = transparentTextFieldColors(),
    )
}

// Helper function for transparent text field defaults
@Composable
fun transparentTextFieldColors() =
    TextFieldDefaults.colors(
        unfocusedIndicatorColor = AppColors.Transparent,
        focusedIndicatorColor = AppColors.Transparent,
        unfocusedContainerColor = AppColors.Transparent,
        focusedContainerColor = AppColors.Transparent,
        disabledIndicatorColor = AppColors.Transparent,
        disabledContainerColor = AppColors.Transparent,
    )
