package com.abdelrahman.raafat.budget.tracker.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTHeader

@Suppress("FunctionName")
@Composable
fun BTBaseScreen(
    title: String,
    iconRes: Int = R.drawable.ic_backspace,
    iconColor: Color? = null,
    verticalSpace: Dp = 20.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(verticalSpace),
        modifier = modifier,
    ) {
        // Header with customizable content
        BTHeader(
            title = title,
            iconRes = iconRes,
            iconColor = iconColor,
        )

        // Main content
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}
