package com.perfectyang.helo.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class BankInfo (
    var bankName: String
)

class MineViewModel: ViewModel() {
    val textState = MutableStateFlow("")
    var _textState = textState.asStateFlow()


    fun changeText(text: String) {
        textState.update {
            text
        }
    }



}