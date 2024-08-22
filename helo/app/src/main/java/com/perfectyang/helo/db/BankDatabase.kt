package com.perfectyang.helo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.perfectyang.helo.db.entity.Bank


@Database(entities = [Bank::class], version = 1)
@TypeConverters(Converters::class)
abstract  class BankDatabase: RoomDatabase() {

    companion object {
        const val NAME = "Bank_DB"
    }
    abstract fun getBankDao(): BankDao

}