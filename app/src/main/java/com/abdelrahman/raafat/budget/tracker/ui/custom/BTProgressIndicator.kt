package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTProgressIndicator(
    size: Int,
    currentPage: Int? = null,
    pagerState: PagerState? = null,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(size) { iteration ->
            val isSelected =
                if (pagerState != null) {
                    pagerState.currentPage % size == iteration
                } else {
                    currentPage == iteration
                }

            val color =
                if (isSelected) {
                    Color.Transparent
                } else {
                    MaterialTheme.colorScheme.primary
                }

            val borderColor =
                if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Transparent
                }
            BTCustomIndicator(borderColor, color)
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun BTProgressIndicatorPreview() {
    BudgetTrackerTheme {
        BTProgressIndicator(
            size = 4,
            currentPage = 3,
            pagerState = null,
        )
    }
}
