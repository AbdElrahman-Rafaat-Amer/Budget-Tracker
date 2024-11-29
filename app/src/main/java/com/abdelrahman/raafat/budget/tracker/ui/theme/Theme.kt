package com.abdelrahman.raafat.budget.tracker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles.BTTypography

// Light color scheme
val LightColorScheme =
    lightColorScheme(
        primary = AppColors.PrimaryLight,
        secondary = AppColors.BluePrimary,
        tertiary = AppColors.OrangeAccent,
        background = AppColors.LightBackground,
        surface = AppColors.LightCardBackground,
        onPrimary = AppColors.White,
        onSecondary = AppColors.Black,
        onBackground = AppColors.LightOnBackground,
        onSurface = AppColors.LightOnBackground,
    )

// Dark color scheme
val DarkColorScheme =
    darkColorScheme(
        primary = AppColors.PrimaryDark,
        secondary = AppColors.BluePrimary,
        tertiary = AppColors.YellowAccent,
        background = AppColors.DarkBackground,
        surface = AppColors.DarkCardBackground,
        onPrimary = AppColors.White,
        onSecondary = AppColors.Black,
        onBackground = AppColors.DarkOnBackground,
        onSurface = AppColors.DarkOnBackground,
    )

@Suppress("FunctionName")
@Composable
fun BudgetTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = BTTypography,
        content = content,
    )
}
