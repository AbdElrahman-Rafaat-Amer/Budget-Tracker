package com.abdelrahman.raafat.budget.tracker.ui.onboarding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.item.OnboardingItem
import kotlinx.coroutines.launch

class OnboardingViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val preferencesManager = PreferencesManager(application.baseContext)

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

    // Save the 'show onboarding' value
    fun saveShowOnboarding(value: Boolean) {
        viewModelScope.launch {
            preferencesManager.saveShowOnboarding(value)
        }
    }
}
