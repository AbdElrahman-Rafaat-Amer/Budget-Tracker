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

// Light color scheme
val LightColorScheme =
    lightColorScheme(
        primary = AppColors.GreenPrimary,
        secondary = AppColors.BluePrimary,
        tertiary = AppColors.OrangeAccent,
        background = AppColors.LightBackground,
        surface = AppColors.LightCardBackground,
        onPrimary = AppColors.White,
        onSecondary = AppColors.Black,
        onBackground = AppColors.LightText,
        onSurface = AppColors.LightText,
    )

// Dark color scheme
val DarkColorScheme =
    darkColorScheme(
        primary = AppColors.DarkPrimary,
        secondary = AppColors.BluePrimary,
        tertiary = AppColors.YellowAccent,
        background = AppColors.DarkBackground,
        surface = AppColors.DarkCardBackground,
        onPrimary = AppColors.White,
        onSecondary = AppColors.Black,
        onBackground = AppColors.DarkText,
        onSurface = AppColors.DarkText,
    )

val OnboardingLightColorScheme =
    lightColorScheme(
        primary = AppColors.Teal500,
        secondary = AppColors.LightBlue,
        tertiary = AppColors.SoftGreen,
        background = AppColors.BackgroundLight,
        surface = AppColors.BackgroundLight,
        onPrimary = AppColors.White,
        onSecondary = AppColors.TextPrimary,
        onBackground = AppColors.TextPrimary,
        onSurface = AppColors.TextPrimary,
    )

// Dark Color Scheme
val OnboardingDarkColorScheme =
    darkColorScheme(
        primary = AppColors.Teal500,
        secondary = AppColors.LightBlue,
        tertiary = AppColors.MutedLavender,
        background = AppColors.BackgroundDark,
        surface = AppColors.BackgroundDark,
        onPrimary = AppColors.White,
        onSecondary = AppColors.TextPrimary,
        onBackground = AppColors.White,
        onSurface = AppColors.White,
    )

@Composable
fun BudgetTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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
        typography = Typography,
        content = content,
    )
}

@Composable
fun BudgetTrackerOnBoardingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> OnboardingDarkColorScheme
            else -> OnboardingLightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
