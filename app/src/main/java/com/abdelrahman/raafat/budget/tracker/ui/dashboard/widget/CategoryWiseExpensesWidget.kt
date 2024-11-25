package com.abdelrahman.raafat.budget.tracker.ui.dashboard.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTLinearProgressIndicator
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.CategoryExpense
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency

@Suppress("FunctionName")
@Composable
fun CategoryWiseExpensesWidget(
    item: CategoryExpense,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp)),
        colors = CardDefaults.cardColors(containerColor = AppColors.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp, start = 16.dp, end = 16.dp),
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = AppColors.PaleBlue),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                shape = CircleShape,
            ) {
                Image(
                    modifier =
                        Modifier
                            .size(51.dp)
                            .padding(3.dp),
                    painter = painterResource(item.iconRes),
                    contentDescription = "",
                )
            }

            Spacer(Modifier.height(10.dp))

            Text(
                text = item.title,
                style = AppTextStyles.textStyle21SPNormal,
            )

            Spacer(Modifier.height(18.dp))

            // Fees Text
            Text(
                text = setupFeesText(item.price, item.totalPrice),
                style = AppTextStyles.textStyle15SPMedium,
                color = AppColors.LightText,
            )

            Spacer(Modifier.height(3.dp))
            // ProgressBar
            BTLinearProgressIndicator(
                targetProgress = (item.price / item.totalPrice).toFloat(),
            )
        }
    }
}

@Composable
private fun setupFeesText(
    price: Double,
    totalPrice: Double,
) = buildAnnotatedString {
    withStyle(
        style =
            SpanStyle(
                fontSize = 17.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
            ),
    ) {
        append(price.formatWithCurrency())
    }

    withStyle(
        style =
            SpanStyle(
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
            ),
    ) {
        append(" ")
        append(stringResource(R.string.of))
        append(" ")
        withStyle(
            style =
                SpanStyle(
                    fontSize = 16.sp,
                ),
        ) {
            append(totalPrice.formatWithCurrency())
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun CategoryWiseExpensesWidgetPreview() {
    BudgetTrackerTheme {
        Column(
            modifier =
                Modifier
                    .padding(10.dp),
        ) {
            val item =
                CategoryExpense(
                    title = "Bills & Utilities",
                    iconRes = R.drawable.ic_onboarding_1,
                    price = 3600.0,
                    totalPrice = 3200.0,
                )
            CategoryWiseExpensesWidget(item)
        }
    }
}
