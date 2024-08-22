package com.perfectyang.helo.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class CardInfo (
    var bankName: String = "",
    var bankCard: String = "",
    var validDate: String = "",
    var backNum: String = "",
)

class EditCardInfoViewModel: ViewModel() {
    var type by mutableStateOf("1")

    private val _uiState = MutableStateFlow(CardInfo())
    val uiState = _uiState.asStateFlow()

    fun updateBankName(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                bankName = text
            )
        }
    }
    fun updateBackNum(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                backNum = text
            )
        }
    }
    fun updateCardNum(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                bankCard = text
            )
        }
    }

    fun updateValidDate(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                validDate = text
            )
        }
    }











}