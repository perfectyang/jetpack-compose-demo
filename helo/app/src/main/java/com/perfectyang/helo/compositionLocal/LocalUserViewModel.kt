package com.perfectyang.helo.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.perfectyang.helo.viewModel.UserViewModel

val LocalUserViewModel = compositionLocalOf<UserViewModel> {
    error("user view model not found")
}
