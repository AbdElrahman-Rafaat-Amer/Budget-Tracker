package com.abdelrahman.raafat.budget.tracker.ui.onboarding.item

import androidx.annotation.DrawableRes

data class OnboardingItem(
    @DrawableRes var imageResId: Int,
    var headline: String,
    var description: String,
)
