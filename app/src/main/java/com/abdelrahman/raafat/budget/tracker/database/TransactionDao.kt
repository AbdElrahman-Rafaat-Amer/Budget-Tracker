package com.abdelrahman.raafat.budget.tracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.abdelrahman.raafat.budget.tracker.ui.transactions.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transactionItem: Transaction)

    @Update
    suspend fun updateTransaction(transactionItem: Transaction)

    @Query("SELECT * FROM `transaction` ORDER BY date DESC")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM `transaction` WHERE isExpense = 0 ORDER BY date DESC")
    fun getAllIncomeTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM `transaction` WHERE isExpense = 1 ORDER BY date DESC")
    fun getAllExpenseTransactions(): Flow<List<Transaction>>

    @Delete
    suspend fun deleteTransaction(transactionItem: Transaction)
}
