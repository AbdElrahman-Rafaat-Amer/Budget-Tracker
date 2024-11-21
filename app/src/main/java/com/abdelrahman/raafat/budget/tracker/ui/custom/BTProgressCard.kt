package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTProgressCard(
    percentage: Int,
    remainingDays: Int,
    diagonalStriped: DiagonalStripedType = DiagonalStripedType.Vertical,
    backGroundColor: Color = AppColors.LightPrimary
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backGroundColor),
        contentAlignment = Alignment.CenterStart
    ) {
        // Diagonal striped layer based on percentage
        when (diagonalStriped) {
            DiagonalStripedType.Italic -> BuildItalicDiagonal(percentage)
            DiagonalStripedType.Vertical -> BuildVerticalDiagonal(percentage)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            // Left text: Percentage Completed
            Text(
                text = setupPercentageCompletedText(percentage),
                color = Color.Black
            )

            // Right text: Remaining Days
            Text(
                text = setupRemainingDaysText(remainingDays),
                color = Color.Black,
                lineHeight = 25.sp,
                textAlign = TextAlign.End
            )
        }
    }
}

@Suppress("FunctionName")
@Composable
private fun BuildItalicDiagonal(percentage: Int) = Canvas(modifier = Modifier.fillMaxSize()) {
    val width = size.width * (percentage / 100f) // Dynamic width based on percentage
    val stripeWidth = 20f // Stripe thickness
    val stripeSpacing = 10f // Spacing between stripes
    val stripeColor = AppColors.DeepBlue
    val diagonalAngle = 315f // Angle of the stripes

    // Clip the canvas to restrict drawing to the highlighted area
    clipRect(right = width) {
        // Rotate the canvas to draw diagonal stripes
        rotate(degrees = diagonalAngle) {
            // Adjust drawing bounds to cover full width and height, ensuring no gaps
            for (x in -size.height.toInt()..(size.width + size.height).toInt() step (stripeWidth + stripeSpacing).toInt()) {
                drawRect(
                    color = stripeColor,
                    topLeft = Offset(
                        x.toFloat(),
                        -size.height * 2
                    ), // Offset to ensure full coverage
                    size = Size(
                        stripeWidth,
                        size.height * 4
                    ) // Extend size to cover rotation fully
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
private fun BuildVerticalDiagonal(percentage: Int) =
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width * (percentage / 100f)
        val stripeWidth = 20f
        val stripeSpacing = 10f
        val stripeColor = Color(0xFF93C9FF)

        for (x in 0..width.toInt() step (stripeWidth + stripeSpacing).toInt()) {
            drawRect(
                color = stripeColor,
                topLeft = Offset(x.toFloat(), 0f),
                size = Size(stripeWidth, size.height)
            )
        }
    }

@Composable
private fun setupPercentageCompletedText(percentage: Int) = buildAnnotatedString {
    withStyle(
        style = SpanStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    ) {
        append("$percentage%")
    }
    append("\n")
    withStyle(
        style = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    ) {
        append(stringResource(R.string.completed))
    }
}


@Composable
private fun setupRemainingDaysText(remainingDays: Int) = buildAnnotatedString {
    withStyle(
        style = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp
        )
    ) {
        append(stringResource(R.string.remaining))
    }
    append("\n")
    withStyle(
        style = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    ) {
        val remainingDaysText = pluralStringResource(
            id = R.plurals.remaining_days,
            count = remainingDays,
            remainingDays
        )
        append(remainingDaysText)
    }
}

enum class DiagonalStripedType {
    Italic,
    Vertical
}

@Suppress("FunctionName")
@Preview(locale = "Ar")
@Preview(locale = "En")
@Composable
fun BTProgressCardPreview() {
    BudgetTrackerTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            BTProgressCard(
                percentage = 79,
                remainingDays = 9,
                diagonalStriped = DiagonalStripedType.Vertical
            )

            BTProgressCard(
                percentage = 79,
                remainingDays = 9,
                diagonalStriped = DiagonalStripedType.Italic
            )
        }

    }
}