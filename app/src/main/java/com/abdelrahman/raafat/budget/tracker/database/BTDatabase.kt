package com.abdelrahman.raafat.budget.tracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem

@Database(
    entities = [TransactionItem::class],
    version = 1,
)
abstract class BTDatabase : RoomDatabase() {
    abstract val transactionDao: TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: BTDatabase? = null

        fun getInstance(context: Context): BTDatabase =
            INSTANCE ?: synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context.applicationContext,
                            BTDatabase::class.java,
                            "budget_tracker.db",
                        ).build()
                INSTANCE = instance
                instance
            }
    }
}
