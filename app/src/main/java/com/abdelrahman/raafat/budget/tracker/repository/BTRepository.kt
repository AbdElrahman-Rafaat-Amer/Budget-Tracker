package com.abdelrahman.raafat.budget.tracker.repository

import com.abdelrahman.raafat.budget.tracker.database.TransactionDao
import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction
import kotlinx.coroutines.flow.Flow

class BTRepository(
    private val transactionDao: TransactionDao,
) {
    suspend fun insertTransaction(transactionItem: Transaction) = transactionDao.insertTransaction(transactionItem)

    suspend fun updateTransaction(transactionItem: Transaction) = transactionDao.insertTransaction(transactionItem)

    fun getAllTransactions(): Flow<List<Transaction>> = transactionDao.getAllTransactions()

    fun getAllIncomeTransactions(): Flow<List<Transaction>> = transactionDao.getAllIncomeTransactions()

    fun getAllExpenseTransactions(): Flow<List<Transaction>> = transactionDao.getAllExpenseTransactions()

    suspend fun deleteTransaction(transactionItem: Transaction) = transactionDao.deleteTransaction(transactionItem)
}
