package com.perfectyang.personbank.utils

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.perfectyang.personbank.page.Login.LoginViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


interface UserHandler {
    suspend fun testFun()
}


class  UserHandlerImpl @Inject constructor (
    private val context: ApplicationContext,
) : UserHandler {

    val _userId = longPreferencesKey("userId")
    val _username = stringPreferencesKey("username")
    val _password = stringPreferencesKey("password")

//    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data")

    override suspend fun testFun() {


    }




}