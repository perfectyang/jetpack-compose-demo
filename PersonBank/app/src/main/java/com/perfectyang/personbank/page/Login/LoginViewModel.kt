package com.perfectyang.personbank.page.Login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.personbank.db.UserDb.UserEntity
import com.perfectyang.personbank.db.UserDb.UserRepository
import com.perfectyang.personbank.utils.DataStoreRepository.HistoryDataStoreRepository
import com.perfectyang.personbank.utils.DataStoreRepository.LocalUserData
import com.perfectyang.personbank.utils.DataStoreRepository.UserDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userRepository: UserRepository,
    private val historyDataStoreRepository: HistoryDataStoreRepository,
    private val userDataStoreRepository: UserDataStoreRepository
) : ViewModel() {





    fun login(username: String, password: String, callback: () -> Unit = {}) {
        viewModelScope.launch {
            val userInfo = userRepository.getUser(username, password)
            if (userInfo !== null)  {
                userDataStoreRepository.storeUserData(
                    LocalUserData(
                        username = username,
                        userId = userInfo.userId.toString(),
                        password = password
                    )
                )
            } else {
                val id = userRepository.upsertUser(UserEntity(username, password))
                userDataStoreRepository.storeUserData(
                    LocalUserData(
                        username = username,
                        userId = id.toString(),
                        password = password
                    )
                )
            }
            historyDataStoreRepository.add(username, Pair("password", password))
            callback()
        }
    }


    fun clear() {
        viewModelScope.launch {
            userDataStoreRepository.clearUserStore()
        }
    }

    fun getUserData() = userDataStoreRepository.getUserData()


}