package com.abdelrahman.raafat.budget.tracker.repository

import com.abdelrahman.raafat.budget.tracker.database.TransactionDao
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import kotlinx.coroutines.flow.Flow

class BTRepository(
    private val transactionDao: TransactionDao,
) {
    suspend fun insertTransaction(transactionItem: TransactionItem) = transactionDao.insertTransaction(transactionItem)

    suspend fun updateTransaction(transactionItem: TransactionItem) = transactionDao.insertTransaction(transactionItem)

    fun getAllTransactions(): Flow<List<TransactionItem>> = transactionDao.getAllTransactions()

    fun getAllIncomeTransactions(): Flow<List<TransactionItem>> = transactionDao.getAllIncomeTransactions()

    fun getAllExpenseTransactions(): Flow<List<TransactionItem>> = transactionDao.getAllExpenseTransactions()

    suspend fun deleteTransaction(transactionItem: TransactionItem) = transactionDao.deleteTransaction(transactionItem)
}
