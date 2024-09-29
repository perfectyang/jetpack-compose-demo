package com.perfectyang.personbank.utils.DataStoreRepository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey


interface HistoryDataStoreRepository {
    suspend fun add(title: String, value: Pair<String, String>)
}

class HistoryDataStoreRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): HistoryDataStoreRepository, BaseDataStoreRepository by BaseDataStoreRepositoryImpl(dataStore)  {
    override suspend fun add(title: String, value: Pair<String, String>) {
        dataStore.edit {
            it[stringPreferencesKey(title)] = value.toString()
        }
    }
}