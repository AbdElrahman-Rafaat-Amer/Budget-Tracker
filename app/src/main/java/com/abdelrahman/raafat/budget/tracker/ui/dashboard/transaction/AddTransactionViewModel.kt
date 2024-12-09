package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafat.budget.tracker.base.BTBaseViewModel
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import kotlinx.coroutines.launch

class AddTransactionViewModel(
    application: Application
) : BTBaseViewModel(application) {

    fun addTransaction(transactionItem: TransactionItem) {
        viewModelScope.launch {
            db.transactionDao.insertTransaction(transactionItem)
        }
    }

}