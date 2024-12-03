package com.abdelrahman.raafat.budget.tracker

sealed class ScreensName(
    val route: String,
) {
    data object Splash : ScreensName("splash")

    data object Onboarding : ScreensName("onboarding")

    data object Pin : ScreensName("pin")

    data object Dashboard : ScreensName("dashboard")

    data object Transaction : ScreensName("transaction")
}
