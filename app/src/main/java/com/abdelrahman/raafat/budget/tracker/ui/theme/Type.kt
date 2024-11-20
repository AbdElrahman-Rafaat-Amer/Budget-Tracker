package com.abdelrahman.raafat.budget.tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Custom Text Styles
object AppTextStyles {
    val BTTypography = Typography()

    private val _defaultTextStyle =
        TextStyle(
            lineHeight = 20.sp,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            color = AppColors.Black,
        )

    val textStyle12SP =
        _defaultTextStyle.copy(
            fontSize = 12.sp,
            lineHeight = 16.sp,
        )

    val textStyle16SP =
        _defaultTextStyle.copy(
            fontSize = 16.sp,
        )
}
