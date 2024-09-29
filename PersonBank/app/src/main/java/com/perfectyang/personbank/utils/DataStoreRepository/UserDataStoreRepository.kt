package com.perfectyang.personbank.utils.DataStoreRepository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


interface UserDataStoreRepository {
    suspend fun storeUserData(user: LocalUserData)
    suspend fun clearUserStore ()
    fun getUserData(): Flow<LocalUserData>
}



data class LocalUserData(
    val username: String,
    val password: String,
    val userId: String,
)



class UserDataStoreRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): UserDataStoreRepository, BaseDataStoreRepository by BaseDataStoreRepositoryImpl(dataStore)  {
    private object PreferenceKey {
        val userId = stringPreferencesKey("userId")
        val username = stringPreferencesKey("username")
        val password = stringPreferencesKey("password")
    }



    override suspend fun storeUserData(user: LocalUserData) {
        dataStore.edit {
            it[PreferenceKey.userId] = user.userId
            it[PreferenceKey.username] = user.username
            it[PreferenceKey.password] = user.password
        }
    }




    override suspend fun clearUserStore () {
        dataStore.edit { it.clear() }
    }


    override fun getUserData() = dataStore.data.map {
        LocalUserData(
            username = it[PreferenceKey.username] ?: "",
            password = it[PreferenceKey.password] ?: "",
            userId = it[PreferenceKey.userId] ?: "",
        )
    }

}