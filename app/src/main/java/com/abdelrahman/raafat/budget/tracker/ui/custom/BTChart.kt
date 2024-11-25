package com.abdelrahman.raafat.budget.tracker.ui.custom

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.degreeToRadian
import kotlin.math.cos
import kotlin.math.sin

@Suppress("FunctionName")
@Composable
fun BTChart(
    expenses: List<Pair<Float, Color>>,
    modifier: Modifier = Modifier,
) {
    val sweepAngles = expenses.map { it.first }
    val colors = expenses.map { it.second }

    Canvas(modifier = modifier) {
        val total = sweepAngles.sum()
        var startAngle = 0f
        val strokeWidthPx = 30.dp.toPx()

        
        val textPaint =
            Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 20.sp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
            }

        translate(
            left = strokeWidthPx / 2,
            top = strokeWidthPx / 2,
        ) {
            sweepAngles.forEachIndexed { index, sweepAngle ->
                val sweep = (sweepAngle / total) * 360f

                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = sweep - 5,
                    useCenter = false,
                    size =
                        Size(
                            size.width - strokeWidthPx,
                            size.height - strokeWidthPx,
                        ),
                    style = Stroke(width = strokeWidthPx),
                )

                val middleAngle = startAngle + sweep / 2
                val radius = size.minDimension / 2 - strokeWidthPx /2

                // Calculate text position inside the arc
                val textX = center.x + radius * cos(middleAngle.degreeToRadian()).toFloat()
                val textY = center.y + radius * sin(middleAngle.degreeToRadian()).toFloat()

                drawContext.canvas.nativeCanvas.drawText(
                    "${sweep.toInt()}°",
                    textX,
                    textY,
                    textPaint,
                )

                startAngle += sweep
            }
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun PreviewExpenseDistributionView() {
    BudgetTrackerTheme {
        val expenses =
            listOf(
                Pair(25f, AppColors.BillsUtilitiesColor), // Bills & Utilities
                Pair(25f, AppColors.FoodColor), // Food
                Pair(25f, AppColors.PersonalColor), // Personal
                Pair(25f, AppColors.HealthcareColor), // Healthcare
                Pair(25f, AppColors.EducationColor), // Education
                Pair(25f, AppColors.HealthcareColor), // Transport
                Pair(25f, AppColors.InvestmentColor), // Investment
                Pair(25f, AppColors.OthersColor), // Other
            )
        BTChart(
            expenses,
            modifier =
                Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(Color.White)
                    .padding(10.dp),
        )
    }
}
