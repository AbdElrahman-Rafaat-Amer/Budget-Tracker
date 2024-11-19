package com.abdelrahman.raafat.budget.tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DefaultTextStyle = TextStyle()


val defaultTextStyleBold28SpLetterSpace
    get() =
        DefaultTextStyle.copy(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.3.sp
        )


val BTTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = AppColors.TextPrimary
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = AppColors.TextPrimary
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = AppColors.TextPrimary
    )
)