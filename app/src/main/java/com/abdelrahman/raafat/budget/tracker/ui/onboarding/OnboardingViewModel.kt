package com.abdelrahman.raafat.budget.tracker.ui.onboarding

import android.app.Application
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.base.BTBaseViewModel
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.item.OnboardingItem

class OnboardingViewModel(
    application: Application,
) : BTBaseViewModel(application) {
    val onboardingList =
        listOf(
            OnboardingItem(
                imageResId = R.drawable.ic_onboarding_1,
                headline = application.baseContext.getString(R.string.onboarding_title_1),
                description = application.baseContext.getString(R.string.onboarding_desc_1),
            ),
            OnboardingItem(
                imageResId = R.drawable.ic_onboarding_2,
                headline = application.baseContext.getString(R.string.onboarding_title_2),
                description = application.baseContext.getString(R.string.onboarding_desc_2),
            ),
            OnboardingItem(
                imageResId = R.drawable.ic_onboarding_3,
                headline = application.baseContext.getString(R.string.onboarding_title_3),
                description = application.baseContext.getString(R.string.onboarding_desc_3),
            ),
        )
}
