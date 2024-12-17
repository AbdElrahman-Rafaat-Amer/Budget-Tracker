package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.base.BTBaseViewModel
import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction
import kotlinx.coroutines.launch

class AddTransactionViewModel(
    application: Application,
) : BTBaseViewModel(application) {
    fun addTransaction(transactionItem: Transaction) {
        viewModelScope.launch {
            repository.insertTransaction(transactionItem)
        }
    }
}
