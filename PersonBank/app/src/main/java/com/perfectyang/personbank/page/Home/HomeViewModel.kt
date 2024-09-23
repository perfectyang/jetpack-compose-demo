package com.perfectyang.personbank.page.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.personbank.db.PersonBankDb.PersonRepository
import com.perfectyang.personbank.db.UserDb.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PersonRepository,
): ViewModel() {


    private val _searchValue = MutableStateFlow("")
    // 卡类型
    private val _category = MutableStateFlow("1")

    private val _userId = MutableStateFlow<Long?>(null)


    private val _personBankList =  combine(_searchValue, _userId, _category) { searchValue, userId, c ->
       if (userId == null) {
           flowOf(emptyList())
       } else {
           if (searchValue.isBlank()){
               repository.getPersonBank(userId = userId, c)
           } else {
               repository.searchPersonBank(searchValue, userId, c)
           }
       }
    }.flatMapLatest { it ->
        it
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(HomeState())

    val state = combine(_state, _searchValue, _personBankList, _category) { state, searchValue, personBankList, c ->
        state.copy(
            searchValue = searchValue,
            personBankList = personBankList,
            category = c
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeState())



    fun deleteRow (id: Int) {
        viewModelScope.launch {
            repository.deletePersonBank(id)
        }
    }



    fun searchValue (value: String) {
        _searchValue.value = value
    }


    fun setUserId(userId: Long) {
        _userId.value = userId
    }

    fun selectTab(c: String) {
        _category.value = c
    }


}