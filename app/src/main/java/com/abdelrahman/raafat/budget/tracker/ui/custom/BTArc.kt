package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.utils.degreeToRadian
import kotlin.math.cos
import kotlin.math.sin

private const val THUMB_ID = "thumb"
private const val TRACK_ID = "track"

@Suppress("FunctionName")
@Composable
fun BTArc(
    modifier: Modifier = Modifier,
    thumb: @Composable () -> Unit = {
        BTThumb(40.0)
    },
    angleValue: Float,
) {
    val strokeWidth = 20.dp

    val startAngle = 180f
    val sweepAngle = 180f
    val animatable = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animatable.animateTo(
            targetValue = angleValue,
            animationSpec =
                tween(
                    delayMillis = 200,
                    durationMillis = 5000,
                ),
        )
    }

    var thumbPosition: Offset

    val measurePolicy =
        remember {
            MeasurePolicy { measurable, constraints ->

                val thumbPlaceable =
                    measurable.fastFirst { it.layoutId == THUMB_ID }.measure(
                        constraints.copy(
                            minWidth = 0,
                            minHeight = 0,
                        ),
                    )

                val trackPlaceable =
                    measurable.fastFirst { it.layoutId == TRACK_ID }.measure(constraints)

                val sliderWidth = trackPlaceable.width
                val sliderHeight = trackPlaceable.height

                val thumbWidth = thumbPlaceable.width
                val thumbHeight = thumbPlaceable.height

                val strokeWidthPx = strokeWidth.toPx()

                val radius = sliderWidth / 2

                val thumbX =
                    radius + (-radius + strokeWidthPx / 2) * cos(animatable.value.degreeToRadian()) - thumbWidth / 2
                val thumbY =
                    sliderHeight + (-radius + strokeWidthPx / 2) * sin(animatable.value.degreeToRadian()) - thumbHeight / 2
                thumbPosition = Offset(thumbX.toFloat(), thumbY.toFloat())

                layout(sliderWidth, sliderHeight) {
                    trackPlaceable.placeRelative(0, 0)

                    if (thumbPosition != Offset.Unspecified) {
                        thumbPlaceable.placeRelative(
                            thumbPosition.x.toInt(),
                            thumbPosition.y.toInt(),
                        )
                    }
                }
            }
        }

    Layout(
        modifier = modifier,
        content = {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(2f)
                        .layoutId(TRACK_ID),
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val strokeWidthPx = strokeWidth.toPx()
                    translate(
                        left = strokeWidthPx / 2,
                        top = strokeWidthPx / 2,
                    ) {
                        drawArc(
                            color = AppColors.LightPrimary,
                            size =
                                Size(
                                    size.width - strokeWidthPx,
                                    (size.height - strokeWidthPx) * 2,
                                ),
                            startAngle = startAngle,
                            sweepAngle = sweepAngle,
                            style =
                                Stroke(
                                    strokeWidthPx,
                                    cap = StrokeCap.Round,
                                ),
                            useCenter = false,
                        )

                        drawArc(
                            color = AppColors.OceanBlue,
                            size =
                                Size(
                                    size.width - strokeWidthPx,
                                    (size.height - strokeWidthPx) * 2,
                                ),
                            startAngle = startAngle,
                            sweepAngle = animatable.value,
                            style =
                                Stroke(
                                    strokeWidthPx,
                                    cap = StrokeCap.Round,
                                ),
                            useCenter = false,
                        )
                    }
                }
            }

            Box(modifier = Modifier.layoutId(THUMB_ID)) {
                thumb()
            }
        },
        measurePolicy = measurePolicy,
    )
}

@Suppress("FunctionName")
@Preview
@Composable
private fun BTArcPreview() {
    BudgetTrackerTheme {
        BTArc(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .aspectRatio(2f),
            angleValue = 120f,
            thumb = { BTThumb() },
        )
    }
}
