package com.perfectyang.demoinjectdi.page.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class StateInfo(
    val imageUrl: String = "",
    val title: String = "大哥",
    val description: String = "",

    val isImagesDialogShowing: Boolean = false,

    val imageList: List<String> = emptyList(),
    val searchImagesQuery: String = "",
    val isLoadingImages: Boolean = false,
)

sealed interface infoAction {
    data class UpdateImageUrl(val imageUrl: String): infoAction
    data class UpdateTitle(val title: String): infoAction
    data class UpdateDescription(val description: String): infoAction
    data class UpdateIsImagesDialogShowing(val isImagesDialogShowing: Boolean): infoAction
    data class UpdateImageList(val imageList: List<String>): infoAction
}


@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    val _infoListState = MutableStateFlow(StateInfo())
    val stateInfo = _infoListState.asStateFlow()


    fun onAction(action: infoAction) {
        when(action) {
            is infoAction.UpdateTitle -> {
                _infoListState.update {
                    it.copy(title = action.title)
                }
            }
            is infoAction.UpdateDescription -> TODO()
            is infoAction.UpdateImageList -> TODO()
            is infoAction.UpdateImageUrl -> TODO()
            is infoAction.UpdateIsImagesDialogShowing -> TODO()
        }
    }





}