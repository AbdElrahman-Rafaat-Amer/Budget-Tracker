package com.abdelrahman.raafat.budget.tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Custom Text Styles
object AppTextStyles {
    val BTTypography = Typography()

    private val defaultTextStyle =
        TextStyle(
            lineHeight = 20.sp,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            color = AppColors.Black
        )

    val textStyle12SPNormal =
        defaultTextStyle.copy(
            fontSize = 12.sp,
            lineHeight = 16.sp
        )

    val textStyle13SPNormal =
        defaultTextStyle.copy(
            fontSize = 13.sp,
            lineHeight = 16.sp
        )

    val textStyle13SPNormalItalic = textStyle13SPNormal.copy(fontStyle = FontStyle.Italic)

    val textStyle14SPNormal =
        defaultTextStyle.copy(
            fontSize = 14.sp,
            lineHeight = 18.sp
        )

    val textStyle14SPNormalItalic =
        defaultTextStyle.copy(
            lineHeight = 17.sp,
            fontStyle = FontStyle.Italic
        )

    val textStyle15SPMedium =
        defaultTextStyle.copy(
            fontSize = 15.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium
        )

    val textStyle16SPNormal =
        defaultTextStyle.copy(
            fontSize = 16.sp
        )

    val textStyle18SPNormal =
        defaultTextStyle.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 25.sp
        )

    val textStyle21SPNormal =
        defaultTextStyle.copy(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 25.sp
        )

    val textStyle21SPBold =
        defaultTextStyle.copy(
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 25.sp
        )

    val textStyle28SPMedium =
        defaultTextStyle.copy(
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 25.sp
        )
}
