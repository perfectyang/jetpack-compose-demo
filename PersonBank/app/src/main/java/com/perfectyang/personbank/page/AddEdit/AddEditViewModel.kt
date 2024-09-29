package com.perfectyang.personbank.page.AddEdit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.personbank.db.PersonBankDb.PersonBankEntity
import com.perfectyang.personbank.db.PersonBankDb.PersonRepository
import com.perfectyang.personbank.utils.DataStoreRepository.UserDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class OnEvent {
    data class UpdateBankName(val value: String): OnEvent()
    data class UpdateBankNumber(val value: String): OnEvent()
    data class UpdateBankValidTime(val value: String): OnEvent()
    data class UpdateBackCardThree(val value: String): OnEvent()
    data class UpdateBackBillDate(val value: String): OnEvent()
    data class UpdateBackPayDate(val value: String): OnEvent()
    data class UpdateQuota(val value: String): OnEvent()
    data class UpdateCategory(val value: String): OnEvent()
}


@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val repository: PersonRepository,
): ViewModel() {

    val state = MutableStateFlow(PersonBankEntity())

    fun upInsertPersonBank(personBank: PersonBankEntity, userId: String) {
        val _personBank = personBank.copy(
            userId = userId
        )
        viewModelScope.launch {
            repository.upsertPersonBank(_personBank)
        }
    }


    fun onEvent(event: OnEvent) {
        when(event) {
            is OnEvent.UpdateBankName -> {
                state.value = state.value.copy(
                    bank_name = event.value
                )
            }
            is OnEvent.UpdateBackBillDate -> {
                state.value = state.value.copy(
                    bill_date = event.value
                )
            }
            is OnEvent.UpdateBackCardThree ->  {
                state.value = state.value.copy(
                    back_card_three = event.value
                )
            }
            is OnEvent.UpdateBackPayDate -> {
                state.value = state.value.copy(
                    pay_date = event.value
                )
            }
            is OnEvent.UpdateBankNumber -> {
                state.value = state.value.copy(
                    bank_number = event.value
                )
            }
            is OnEvent.UpdateBankValidTime -> {
                state.value = state.value.copy(
                    valid_time = event.value
                )
            }
            is OnEvent.UpdateQuota -> {
                state.value = state.value.copy(
                    quota = event.value
                )
            }
            is OnEvent.UpdateCategory -> {
                state.value = state.value.copy(
                    category = event.value
                )
            }
        }
    }

    fun updateState(personBank: PersonBankEntity) {
        viewModelScope.launch{
            state.value = state.value.copy(
                category = personBank.category,
                bank_name = personBank.bank_name,
                bank_number = personBank.bank_number,
                valid_time = personBank.valid_time,
                pay_date = personBank.pay_date,
                bill_date = personBank.bill_date,
                quota = personBank.quota,
                back_card_three = personBank.back_card_three,
                id = personBank.id
            )
        }
    }



}