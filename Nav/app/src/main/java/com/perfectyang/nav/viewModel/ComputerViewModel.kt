package com.perfectyang.nav.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class Calucate (
    val count: Int = 0
)

class ComputerViewModel: ViewModel() {

    val _uiState = MutableStateFlow(Calucate())
    val uiState: StateFlow<Calucate> = _uiState.asStateFlow()




    fun increase () {
        _uiState.update { currentState ->
           currentState.copy(
               count = currentState.count + 1
           )
        }
    }

}