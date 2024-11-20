package com.abdelrahman.raafat.budget.tracker

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

// Create an extension property for DataStore
val Context.dataStore by preferencesDataStore(name = "user_preferences")

class PreferencesManager(
    private val context: Context,
) {
    private val showOnboardingKey = booleanPreferencesKey("SHOW_ONBOARDING")

    // Function to get the 'show onboarding' value
    suspend fun getShowOnboarding(): Boolean {
        val preferences = context.dataStore.data.first()
        return preferences[showOnboardingKey] ?: true
    }

    // Function to save the 'show onboarding' value
    suspend fun saveShowOnboarding(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[showOnboardingKey] = value
        }
    }
}
