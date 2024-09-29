package com.perfectyang.personbank.utils.DataStoreRepository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Datastore {
    internal val Context.historyDataStore: DataStore<Preferences> by preferencesDataStore(name = "history")
    internal val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = "user_store")
}
