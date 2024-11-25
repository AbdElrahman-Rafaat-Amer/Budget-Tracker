package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Suppress("FunctionName")
@Composable
fun BTCustomIndicator(
    borderColor: Color,
    color: Color,
) {
    Box(
        modifier =
            Modifier
                .padding(horizontal = 3.dp)
                .clip(CircleShape)
                .background(color)
                .size(10.dp)
                .border(1.dp, borderColor, CircleShape),
    )
}
