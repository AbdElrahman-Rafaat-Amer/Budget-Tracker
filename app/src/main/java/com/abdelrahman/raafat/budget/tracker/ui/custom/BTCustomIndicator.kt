package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTCustomIndicator(
    color: Color,
    borderColor: Color = color,
    selectedColor: Color = color,
    size: Dp = 10.dp,
    text: String = "",
    textColor: Color = AppColors.White,
    textStyle: TextStyle = AppTextStyles.textStyle28SPMedium,
    isSelected: Boolean = false,
    isClickable: Boolean = false,
    onNumberClick: (number: String) -> Unit = {},
) {
    Box(
        modifier =
            Modifier
                .padding(horizontal = 3.dp)
                .clip(CircleShape)
                .background(
                    color = if (isSelected) selectedColor else color,
                ).size(size)
                .border(1.dp, borderColor, CircleShape)
                .then(
                    if (isClickable) {
                        Modifier.clickable { onNumberClick(text) }
                    } else {
                        Modifier
                    },
                ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = textColor,
            style = textStyle,
        )
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun BTCustomIndicatorPreview() {
    BudgetTrackerTheme {
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            BTCustomIndicator(
                color = MaterialTheme.colorScheme.primary,
                size = 70.dp,
                text = "2",
            )

            BTCustomIndicator(
                color = MaterialTheme.colorScheme.primary,
                size = 70.dp,
                text = "2",
                selectedColor = AppColors.Gray,
                isSelected = true,
                isClickable = true,
            )
        }
    }
}
