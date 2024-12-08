package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTHeader(
    title: String,
    textStyle: TextStyle = AppTextStyles.textStyle18SPSemiBold.copy(textAlign = TextAlign.Center),
    removeIcon: Boolean = false,
    iconRes: Int = R.drawable.ic_backspace,
    iconColor: Color? = null,
    textColor: Color = AppColors.Black,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit = {},
) {
    val colorFilter = iconColor?.let { ColorFilter.tint(iconColor) }
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        AnimatedVisibility(visible = removeIcon.not()) {
            Image(
                painter = painterResource(iconRes),
                colorFilter = colorFilter,
                contentDescription = stringResource(R.string.back),
                modifier =
                    Modifier.clickable {
                        onBackButtonClicked()
                    },
            )
        }
        Text(
            text = title,
            style =
                textStyle.copy(
                    color = textColor,
                ),
            modifier =
                Modifier
                    .weight(1f),
        )
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun BTHeaderPreview() {
    BudgetTrackerTheme {
        BTHeader(title = "Transactions")
    }
}
