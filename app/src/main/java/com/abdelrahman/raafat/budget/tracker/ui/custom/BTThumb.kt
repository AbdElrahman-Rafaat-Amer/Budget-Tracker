package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTThumb(size: Double = 40.0) {
    Box(
        modifier =
            Modifier
                .size(size.dp)
                .border(8.dp, AppColors.White, CircleShape)
                .shadow(4.dp, CircleShape)
                .background(AppColors.OceanBlue, CircleShape),
    )
}

@Suppress("FunctionName")
@Preview
@Composable
private fun ThumbPreview() {
    BudgetTrackerTheme {
        BTThumb()
    }
}
