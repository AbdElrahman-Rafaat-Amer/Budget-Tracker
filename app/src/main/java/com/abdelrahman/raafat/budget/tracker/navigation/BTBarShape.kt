package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class BTBarShape(
    private val circleGap: Dp = 40.dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline = Outline.Generic(getPath(size, density))

    private fun getPath(
        size: Size,
        density: Density,
    ): Path {
        val cutoutCenterX = size.width / 2
        val cutoutRadius = density.run { circleGap.toPx() }
        return Path().apply {
            val cutoutEdgeOffset = cutoutRadius * 1.2f
            val cutoutLeftX = cutoutCenterX - cutoutEdgeOffset
            val cutoutRightX = cutoutCenterX + cutoutEdgeOffset

            // bottom left
            moveTo(x = 0F, y = size.height)

            // top left
            if (cutoutLeftX > 0) {
                arcTo(
                    rect =
                        Rect(
                            left = 0f,
                            top = 0f,
                            right = 0f,
                            bottom = 0f,
                        ),
                    startAngleDegrees = 180.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false,
                )
            }

            lineTo(cutoutLeftX, 0f)

            // cutout
            cubicTo(
                x1 = cutoutCenterX - cutoutRadius,
                y1 = 0f,
                x2 = cutoutCenterX - cutoutRadius,
                y2 = cutoutRadius * 1.5f,
                x3 = cutoutCenterX,
                y3 = cutoutRadius * 1.5f,
            )
            cubicTo(
                x1 = cutoutCenterX + cutoutRadius,
                y1 = cutoutRadius * 1.5f,
                x2 = cutoutCenterX + cutoutRadius,
                y2 = 0f,
                x3 = cutoutRightX,
                y3 = 0f,
            )

            // top right
            if (cutoutRightX < size.width) {
                arcTo(
                    rect =
                        Rect(
                            left = size.width,
                            top = 0f,
                            right = size.width,
                            bottom = size.height,
                        ),
                    startAngleDegrees = -90.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false,
                )
            }

            // bottom right
            lineTo(x = size.width, y = size.height)
            close()
        }
    }
}
