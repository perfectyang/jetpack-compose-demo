package com.perfectyang.helo

import android.app.Application
import androidx.room.Room
import com.perfectyang.helo.db.BankDatabase

class MainApplication: Application() {
    companion object {
        lateinit var bankDatabase: BankDatabase
    }

    override fun onCreate() {
        super.onCreate()
        bankDatabase = Room.databaseBuilder(
            applicationContext,
            BankDatabase::class.java,
            BankDatabase.NAME
        ).build()

    }

}