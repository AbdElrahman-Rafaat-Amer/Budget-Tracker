package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import kotlinx.coroutines.delay

@Suppress("FunctionName")
@Composable
fun BTLinearProgressIndicator(
    targetProgress: Float,
    currentProgress: Float = 0f,
    color: Color = AppColors.OceanBlue,
    trackColor: Color = AppColors.LightPrimary,
) {
    var progress by remember { mutableFloatStateOf(currentProgress) }
    LaunchedEffect(targetProgress) {
        while (progress < targetProgress) {
            delay(60)
            progress = (progress + 0.02f).coerceAtMost(targetProgress)
        }
    }

    LinearProgressIndicator(
        progress = { progress },
        color = color,
        trackColor = trackColor,
        modifier =
            Modifier
                .fillMaxWidth()
                .height(10.dp),
        strokeCap = StrokeCap.Round,
        gapSize = (-5).dp,
        drawStopIndicator = {},
    )
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
fun BTLinearProgressIndicatorPreview() {
    BudgetTrackerTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            BTLinearProgressIndicator(
                targetProgress = 0.7f,
                currentProgress = 0.2f,
            )
        }
    }
}
