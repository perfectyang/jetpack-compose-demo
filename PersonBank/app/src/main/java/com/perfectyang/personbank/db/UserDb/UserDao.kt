package com.perfectyang.personbank.db.UserDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUser(user: UserEntity): Long

    @Query("SELECT * FROM UserEntity where username = :username and password = :password")
    suspend fun getUser(username: String, password: String): UserEntity?

}