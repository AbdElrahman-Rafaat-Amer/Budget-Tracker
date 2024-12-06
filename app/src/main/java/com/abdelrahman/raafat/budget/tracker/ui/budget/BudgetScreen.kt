package com.abdelrahman.raafat.budget.tracker.ui.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Suppress("FunctionName")
@Composable
fun BudgetScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color(0xFFFF0000)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Budget Screen", style = MaterialTheme.typography.displayLarge)
    }
}
