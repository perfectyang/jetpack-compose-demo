package com.perfectyang.personbank.utils.DataStoreRepository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

interface BaseDataStoreRepository {
    suspend fun getString(key: String): String?
    suspend fun setString(key: String, value: String)
    suspend fun getInt(key: String): Int?
    suspend fun setInt(key: String, value: Int)
    suspend fun getBool(key: String): Boolean?
    suspend fun setBool(key: String, value: Boolean)
}



class BaseDataStoreRepositoryImpl (
    private val dataStore: DataStore<Preferences>
) : BaseDataStoreRepository {
    override suspend fun getString(key: String) = dataStore.data.map {
        it[stringPreferencesKey(key)]
    }.firstOrNull()

    override suspend fun setString(key: String, value: String) {
        dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    override suspend fun getInt(key: String): Int? {
        return dataStore.data.map {
            it[intPreferencesKey(key)]
        }.firstOrNull()
    }

    override suspend fun setInt(key: String, value: Int) {
        dataStore.edit {
            it[intPreferencesKey(key)] = value
        }
    }

    override suspend fun getBool(key: String): Boolean? {
        return dataStore.data.map {
            it[booleanPreferencesKey(key)]
        }.firstOrNull()
    }

    override suspend fun setBool(key: String, value: Boolean) {
        dataStore.edit {
            it[booleanPreferencesKey(key)] = value
        }
    }
}