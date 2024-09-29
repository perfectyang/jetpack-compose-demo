package com.perfectyang.personbank.page.User

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.personbank.db.UserDb.UserEntity
import com.perfectyang.personbank.db.UserDb.UserRepository
import com.perfectyang.personbank.utils.DataStoreRepository.UserDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val userDataStoreManager: UserDataStoreRepository
): ViewModel() {



    init {
        viewModelScope.launch {
            getStoreUserData()
        }
    }

    fun getAllUser() = userRepository.getAllUser()


    fun getStoreUserData() = userDataStoreManager.getUserData()

}