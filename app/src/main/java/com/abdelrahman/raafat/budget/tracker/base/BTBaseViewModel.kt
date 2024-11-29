package com.abdelrahman.raafat.budget.tracker.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import kotlinx.coroutines.launch

open class BTBaseViewModel(
    application: Application,
) : AndroidViewModel(application) {
    protected val preferencesManager = PreferencesManager(application.baseContext)

    // Save the 'show onboarding' value
    fun saveShowOnboarding(value: Boolean) {
        viewModelScope.launch {
            preferencesManager.saveShowOnboarding(value)
        }
    }

    // Save the 'pin' value
    fun savePin(pinValue: String) {
        viewModelScope.launch {
            preferencesManager.savePin(pinValue)
        }
    }

    // Get the 'pin' value
    open fun getPin() {
        viewModelScope.launch {
            preferencesManager.getPin()
        }
    }
}