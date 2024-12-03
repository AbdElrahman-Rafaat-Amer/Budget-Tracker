package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTSectionTitle(
    title: String,
    showSeeAll: Boolean = false,
    modifier: Modifier = Modifier,
    onSeeAllClicked: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = AppTextStyles.textStyle21SPBold,
            modifier = modifier.weight(1f),
        )
//        if (showSeeAll) {
//            Button(
//                onClick = onSeeAllClicked,
//                colors =
//                ButtonColors(
//                    containerColor = AppColors.LightLavender,
//                    contentColor = AppColors.Transparent,
//                    disabledContainerColor = AppColors.Transparent,
//                    disabledContentColor = AppColors.Transparent,
//                ),
//            ) {
//                Text(
//                    text = stringResource(R.string.see_all),
//                    style =
//                    AppTextStyles.textStyle16SPNormal
//                        .copy(color = AppColors.PrimaryLight),
//                )
//            }
//        }
//        if (showSeeAll) {
//            TextButton(
//                onClick = onSeeAllClicked,
//                colors =
//                ButtonColors(
//                    containerColor = AppColors.LightLavender,
//                    contentColor = AppColors.Transparent,
//                    disabledContainerColor = AppColors.Transparent,
//                    disabledContentColor = AppColors.Transparent,
//                ),
//            ) {
//                Text(
//                    text = stringResource(R.string.see_all),
//                    style =
//                    AppTextStyles.textStyle16SPNormal
//                        .copy(color = AppColors.PrimaryLight),
//                )
//            }
//        }

        if (showSeeAll) {
            Card(
                shape = MaterialTheme.shapes.medium.copy(CornerSize(40.dp)),
                colors = CardDefaults.cardColors(containerColor = AppColors.LightLavender),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            ) {
                Text(
                    text = stringResource(R.string.see_all),
                    style =
                        AppTextStyles.textStyle16SPNormal
                            .copy(color = AppColors.PrimaryLight),
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
@Preview
private fun BTSectionTitlePreview() {
    BudgetTrackerTheme {
        BTSectionTitle(stringResource(R.string.recent_transactions), showSeeAll = true) {
        }
    }
}
