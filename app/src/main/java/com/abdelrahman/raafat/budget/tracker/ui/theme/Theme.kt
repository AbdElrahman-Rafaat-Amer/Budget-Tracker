package com.abdelrahman.raafat.budget.tracker.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Light color scheme
val LightColorScheme =
    lightColorScheme(
        primary = GreenPrimary,
        secondary = BluePrimary,
        tertiary = OrangeAccent,
        background = LightBackground,
        surface = LightCardBackground,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = LightText,
        onSurface = LightText,
    )

// Dark color scheme
val DarkColorScheme =
    darkColorScheme(
        primary = DarkPrimary,
        secondary = BluePrimary,
        tertiary = YellowAccent,
        background = DarkBackground,
        surface = DarkCardBackground,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = DarkText,
        onSurface = DarkText,
    )

val OnboardingLightColorScheme =
    lightColorScheme(
        primary = Teal500,
        secondary = LightBlue,
        tertiary = SoftGreen,
        background = BackgroundLight,
        surface = BackgroundLight,
        onPrimary = Color.White,
        onSecondary = TextPrimary,
        onBackground = TextPrimary,
        onSurface = TextPrimary,
    )

// Dark Color Scheme
val OnboardingDarkColorScheme =
    darkColorScheme(
        primary = Teal500,
        secondary = LightBlue,
        tertiary = MutedLavender,
        background = BackgroundDark,
        surface = BackgroundDark,
        onPrimary = Color.White,
        onSecondary = TextPrimary,
        onBackground = Color.White,
        onSurface = Color.White,
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
