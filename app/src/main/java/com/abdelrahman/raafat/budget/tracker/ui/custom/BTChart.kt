package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.asAngle
import com.abdelrahman.raafat.budget.tracker.utils.degreeToRadian
import com.abdelrahman.raafat.budget.tracker.utils.formatWithCurrency
import kotlin.math.cos
import kotlin.math.sin

@Suppress("FunctionName")
@Composable
fun BTChart(
    chartDataList: List<ChartData>,
    modifier: Modifier = Modifier,
    isDividerShown: Boolean = false,
    dividerColor: Color = AppColors.TransportColor,
) {
    val textMeasurer = rememberTextMeasurer()
    val textMeasureResults =
        remember(chartDataList) {
            chartDataList.map {
                textMeasurer.measure(
                    text = "${it.data.formatWithCurrency(currency = "", maxFraction = 1)}%",
                    style =
                        TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                )
            }
        }

    // Start Angle to start from
    val animatable =
        remember {
            Animatable(-180f)
        }

    // Final Angle to end at
    val finalValue = 180f

    LaunchedEffect(key1 = animatable) {
        animatable.animateTo(
            targetValue = finalValue,
            animationSpec =
                tween(
                    delayMillis = 200,
                    durationMillis = 5000,
                ),
        )
    }
    val currentSweepAngle = animatable.value

    Canvas(modifier = modifier) {
        var startAngle = -180f
        val width = size.width
        val radius = width / 2f
        val strokeWidth = radius * .4f

        chartDataList.forEachIndexed { index, chartData ->
            val sweepAngle = chartData.data.asAngle
            val realSweepAngle = sweepAngle.coerceAtMost(currentSweepAngle - startAngle)
            if (startAngle <= currentSweepAngle) {
                drawArc(
                    color = chartData.color,
                    startAngle = startAngle,
                    sweepAngle = realSweepAngle,
                    useCenter = false,
                    size = Size(width - strokeWidth, width - strokeWidth),
                    style = Stroke(strokeWidth),
                    topLeft =
                        Offset(
                            x = strokeWidth / 2,
                            y = strokeWidth / 2,
                        ),
                )
            }

            val angleInRadians = (startAngle + sweepAngle / 2).degreeToRadian
            val textMeasureResult = textMeasureResults[index]
            val textSize = textMeasureResult.size
            val textCenter = textSize.center
            val innerRadius = radius - strokeWidth
            if (currentSweepAngle == finalValue) {
                drawText(
                    textLayoutResult = textMeasureResult,
                    color = Color.Black,
                    topLeft =
                        Offset(
                            -textCenter.x + center.x + (innerRadius + strokeWidth / 2) *
                                cos(
                                    angleInRadians,
                                ),
                            -textCenter.y + center.y + (innerRadius + strokeWidth / 2) *
                                sin(
                                    angleInRadians,
                                ),
                        ),
                )
            }
            if (isDividerShown) {
                rotate(
                    90f + startAngle,
                ) {
                    drawLine(
                        color = dividerColor,
                        start =
                            Offset(
                                x = center.x,
                                y = (width / 2 - innerRadius).coerceAtMost(width / 2),
                            ),
                        end = Offset(center.x, 0f),
                        strokeWidth = 15f,
                    )
                }
            }

            startAngle += sweepAngle
        }
    }
}

data class ChartData(
    val color: Color,
    val data: Float,
)

@Suppress("FunctionName")
@Preview
@Composable
private fun PreviewExpenseDistributionView() {
    BudgetTrackerTheme {
        val chartDataList =
            listOf(
                ChartData(AppColors.BillsUtilitiesColor, 20f), // Bills & Utilities
                ChartData(AppColors.FoodColor, 10f), // Food
                ChartData(AppColors.PersonalColor, 5f), // Personal
                ChartData(AppColors.HealthcareColor, 15f), // Healthcare
                ChartData(AppColors.EducationColor, 17f), // Education
                ChartData(AppColors.HealthcareColor, 18f), // Transport
                ChartData(AppColors.InvestmentColor, 9f), // Investment
                ChartData(AppColors.OthersColor, 6f), // Other
            )
        BTChart(
            chartDataList,
            modifier =
                Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(Color.White)
                    .padding(10.dp),
        )
    }
}
