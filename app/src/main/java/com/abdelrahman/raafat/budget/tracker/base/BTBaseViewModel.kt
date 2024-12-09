package com.abdelrahman.raafat.budget.tracker.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import com.abdelrahman.raafat.budget.tracker.database.BTDatabase
import com.abdelrahman.raafat.budget.tracker.repository.BTRepository
import kotlinx.coroutines.launch

open class BTBaseViewModel(
    application: Application,
) : AndroidViewModel(application) {
    protected val preferencesManager = PreferencesManager(application.baseContext)

    private val database = BTDatabase.getInstance(application.applicationContext)
    private val itemDao = database.transactionDao
    val repository = BTRepository(itemDao)

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
