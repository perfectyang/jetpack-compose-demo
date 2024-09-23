package com.perfectyang.personbank.db.PersonBankDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.perfectyang.personbank.db.UserDb.UserDao
import com.perfectyang.personbank.db.UserDb.UserEntity

@Database(entities = [PersonBankEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class PersonDataBase: RoomDatabase() {
    abstract val personBankDao: PersonBankDao
    abstract val userDao: UserDao
}