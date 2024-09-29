package com.perfectyang.personbank.db.UserDb

import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl (
    val dao: UserDao
): UserRepository {
    override suspend fun upsertUser(user: UserEntity): Long {
       return dao.upsertUser(user)
    }

    override suspend fun getUser(username: String, password: String): UserEntity? {
        return dao.getUser(username, password)
    }

    override fun getAllUser(): Flow<List<UserEntity>> {
        return dao.getAllUser()
    }
}