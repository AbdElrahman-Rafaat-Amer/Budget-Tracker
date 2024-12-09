package com.abdelrahman.raafat.budget.tracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem

@Database(
    entities = [TransactionItem::class],
    version = 1
)
abstract class BTDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao
}