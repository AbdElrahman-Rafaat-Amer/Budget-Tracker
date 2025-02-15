package com.abdelrahman.raafat.budget.tracker.ui.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

// Themes
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Theme",
    group = "Themes"
//    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Theme",
    group = "Themes",
    showBackground = true
)
annotation class ThemesPreviews

// Localization Previews
@Preview(
    locale = "en", // English
    name = "English",
    group = "Localization",
    showBackground = true
)
@Preview(
    locale = "de", // German
    name = "French",
    group = "Localization",
    showBackground = true
)
@Preview(
    locale = "ru", // Russian
    name = "French",
    group = "Localization",
    showBackground = true
)
@Preview(
    locale = "fr", // French
    name = "French",
    group = "Localization",
    showBackground = true
)
@Preview(
    locale = "es", // Spanish
    name = "French",
    group = "Localization",
    showBackground = true
)
annotation class LocalizationPreviews

// Themes
@ThemesPreviews
@LocalizationPreviews
annotation class AllPreviews
