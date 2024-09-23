package com.perfectyang.personbank.page.Login

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.personbank.db.UserDb.UserEntity
import com.perfectyang.personbank.db.UserDb.UserRepository
import com.perfectyang.personbank.utils.UserHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject




val _userId = longPreferencesKey("userId")
val _username = stringPreferencesKey("username")
val _password = stringPreferencesKey("password")
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data")

@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userRepository: UserRepository,
) : ViewModel() {





    fun login(username: String, password: String, callback: () -> Unit = {}) {
        viewModelScope.launch {
            val userInfo = userRepository.getUser(username, password)
            if (userInfo !== null)  {
                context.dataStore.edit { user ->
                    user[_userId] = userInfo.userId!!
                    user[_username] = username
                    user[_password] = password
                }

            } else {
                val id = userRepository.upsertUser(UserEntity(username, password))
                context.dataStore.edit { user ->
                    user[_userId] = id
                    user[_username] = username
                    user[_password] = password
                }
            }
            callback()
        }
    }


    fun clear() {
        viewModelScope.launch {
            context.dataStore.edit { user ->
                user.clear()
            }
        }
    }

    fun getUserData() = context.dataStore.data


}