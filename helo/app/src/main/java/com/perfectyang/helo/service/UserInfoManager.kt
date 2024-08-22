package com.perfectyang.helo.service

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserInfoManager (private val context: Context) {
    companion object {
        private val Context.userStore: DataStore<Preferences> by preferencesDataStore("user_store")
        val LOGGED = booleanPreferencesKey("LOGGED")
        val USERID = stringPreferencesKey("USERID")
        val TOKEN = stringPreferencesKey("accessToken")
        val REFRESHTOKEN = stringPreferencesKey("refreshToken")
        val USERNAME = stringPreferencesKey("username")
    }
    val logged: Flow<Boolean> = context.userStore.data.map { it[LOGGED] ?: false }
    val userId: Flow<String> = context.userStore.data.map { it[USERID] ?: "" }
    val accessToken: Flow<String> = context.userStore.data.map { it[TOKEN] ?: "" }
    val refreshToken: Flow<String> = context.userStore.data.map { it[REFRESHTOKEN] ?: "" }
    val username: Flow<String> = context.userStore.data.map { it[USERNAME] ?: "" }

    /**
     * 存储用户信息
     *
     * @param userId
     */
    suspend fun save(userId: String, accessToken: String, refreshToken: String, username: String) {
        context.userStore.edit {
            it[LOGGED] = userId.isNotEmpty()
            it[USERID] = userId
            it[TOKEN] = accessToken
            it[REFRESHTOKEN] = refreshToken
            it[USERNAME] = username
        }
    }



    /**
     * 清空用户登录数据
     *
     */
    suspend fun clear() {
        context.userStore.edit {
            it.clear()
//            it[LOGGED] = false
//            it[USERID] = ""
//            it[TOKEN] = ""
//            it[REFRESHTOKEN] = ""
//            it[USERNAME] = ""
        }
    }


}