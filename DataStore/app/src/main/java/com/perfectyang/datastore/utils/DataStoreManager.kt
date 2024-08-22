package com.perfectyang.datastore.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


data class UserDetail(
    var username: String
)

const val USER_DATASTORE = "user_data"

val Context.preferenceDataStore : DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

class DataStoreManager(val context: Context) {

    companion object {
        val USERNAME = stringPreferencesKey("USERNAME")
    }

    suspend fun saveToDataStore(user: UserDetail) {
        context.preferenceDataStore.edit {
            it[USERNAME] = user.username
        }
    }


    suspend fun clearDataStore () = context.preferenceDataStore.edit {
        it.clear()
    }

    fun  getDataStore() = context.preferenceDataStore.data.map {
        UserDetail(
            username = it[USERNAME]?: ""
        )
    }




}