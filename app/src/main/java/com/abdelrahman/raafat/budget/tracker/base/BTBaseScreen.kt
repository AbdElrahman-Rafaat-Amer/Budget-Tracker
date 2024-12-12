package com.abdelrahman.raafat.budget.tracker.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTHeader
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTBaseScreen(
    title: String,
    headerTextStyle: TextStyle = AppTextStyles.textStyle18SPSemiBold.copy(textAlign = TextAlign.Center),
    removeIcon: Boolean = false,
    iconRes: Int = R.drawable.ic_backspace,
    iconColor: Color? = null,
    textColor: Color = AppColors.Black,
    verticalSpace: Dp = 20.dp,
    modifier: Modifier = Modifier,
    headerModifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(verticalSpace),
        modifier = modifier,
    ) {
        // Header with customizable content
        BTHeader(
            title = title,
            textStyle = headerTextStyle,
            removeIcon = removeIcon,
            iconRes = iconRes,
            iconColor = iconColor,
            textColor = textColor,
            modifier = headerModifier,
        ) {
            onBackButtonClicked()
        }

        // Main content
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
fun BTBaseScreenPreview() {
    BudgetTrackerTheme {
        BTBaseScreen(
            "Income",
            modifier =
                Modifier
                    .background(Color.Green),
            headerModifier = Modifier.padding(20.dp),
        ) {
            Text(
                "Abdo",
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color.Red),
            )
        }
    }
}
