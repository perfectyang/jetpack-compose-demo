package com.perfectyang.personbank.db.UserDb

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun upsertUser(user: UserEntity): Long

    suspend fun getUser(username: String, password: String): UserEntity?

}