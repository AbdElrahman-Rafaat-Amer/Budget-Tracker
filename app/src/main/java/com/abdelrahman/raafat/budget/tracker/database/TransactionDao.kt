package com.abdelrahman.raafat.budget.tracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transactionItem: TransactionItem)

    @Update
    suspend fun updateTransaction(transactionItem: TransactionItem)

    @Query("SELECT * FROM `transaction` ORDER BY date DESC")
    fun getAllTransactions(): Flow<List<TransactionItem>>

    @Query("SELECT * FROM `transaction` WHERE isExpense = 0 ORDER BY date DESC")
    fun getAllIncomeTransactions(): Flow<List<TransactionItem>>

    @Query("SELECT * FROM `transaction` WHERE isExpense = 1 ORDER BY date DESC")
    fun getAllExpenseTransactions(): Flow<List<TransactionItem>>

    @Delete
    suspend fun deleteTransaction(transactionItem: TransactionItem)
}
