package com.abdelrahman.raafat.budget.tracker.ui.splash

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.base.BTBaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    application: Application,
) : BTBaseViewModel(application) {
    var pinValue = ""
        private set

    init {
        getPin()
    }

    private val _isPinRight: MutableStateFlow<UiState> = MutableStateFlow((UiState.Initial))
    val isPinRight: StateFlow<UiState> get() = _isPinRight

    // Get the 'pin' value
    override fun getPin() {
        viewModelScope.launch {
            pinValue = preferencesManager.getPin()
        }
    }

    fun checkIfPinIsCorrect(pinValue: String) {
        viewModelScope.launch {
            if (pinValue == preferencesManager.getPin()) {
                _isPinRight.value = UiState.Success
            } else {
                _isPinRight.value = UiState.Error
            }
        }
    }

    fun resetState() {
        _isPinRight.value = UiState.Initial
    }
}

sealed class UiState {
    data object Initial : UiState()

    data object Success : UiState()

    data object Error : UiState()
}
