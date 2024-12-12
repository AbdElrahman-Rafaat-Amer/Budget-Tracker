package com.abdelrahman.raafat.budget.tracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.abdelrahman.raafat.budget.tracker.ui.transactions.TransactionItem

@Database(
    entities = [TransactionItem::class],
    version = 2,
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
                        ).addMigrations(MIGRATION_1_2)
                        .build()
                INSTANCE = instance
                instance
            }
    }
}

val MIGRATION_1_2 =
    object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            // Add the new column with a default value
            db.execSQL("ALTER TABLE `transaction` ADD COLUMN `paymentMethod` TEXT NOT NULL DEFAULT 'UNDEFINED'")
        }
    }
