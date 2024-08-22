package com.perfectyang.helo.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perfectyang.helo.api.User
import com.perfectyang.helo.api.UserInfo
import com.perfectyang.helo.api.types.UserInfoEntity
import com.perfectyang.helo.service.UserInfoManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.security.MessageDigest

@Suppress("IMPLICIT_BOXING_IN_IDENTITY_EQUALS")
class UserViewModel(context: Context): ViewModel() {
    private val userInfoManager = UserInfoManager(context)

    val userApi = User.instance()

    var userName by mutableStateOf("")
    var password by mutableStateOf("")

    var userInfo: UserInfoEntity? = null
        private set


    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        viewModelScope.launch {
            val userId = userInfoManager.userId.firstOrNull()
            val token = userInfoManager.accessToken.firstOrNull()
            val refreshToken = userInfoManager.accessToken.firstOrNull()
            val username = userInfoManager.username.firstOrNull()
            userInfo = if (userId?.isNotEmpty() === true && token?.isNotEmpty() === true && refreshToken?.isNotEmpty() === true && username?.isNotEmpty() === true ) {
                _authState.value = AuthState.Authenticated
                UserInfoEntity(userId, accessToken = token, refreshToken = refreshToken, username = username)
            } else {
                _authState.value = AuthState.Unauthenticated
                null
            }
        }
    }


    //是否正在登录
    var loading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    private val _context = context


    suspend fun login(onClose: () -> Unit) {
        error = ""
        loading = true
        val ret = userApi.signIn(UserInfo(username = userName, password=password, tenantId = "125"))
        if (ret.code == 200  && ret.data !== null) {
            userInfo = ret.data
            userInfoManager.save(ret.data.userId, ret.data.accessToken, ret.data.refreshToken, userName)
            Toast.makeText(_context, "成功登录", Toast.LENGTH_SHORT).show()
            onClose()
        } else {
            error = ret.message
            Toast.makeText(_context, "登录失败", Toast.LENGTH_LONG).show()
        }
        loading = false
    }

    fun clear(onClose: () -> Unit) {
        viewModelScope.launch {
            userInfoManager.clear() //清除本地数据存储
            userInfo = null //置空内存数据
            _authState.value = AuthState.Unauthenticated
            onClose()
        }
    }

    fun md5(content: String): String {
        val hash = MessageDigest.getInstance("MD5").digest(content.toByteArray())
        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            var str = Integer.toHexString(b.toInt())
            if (b < 0x10) {
                str = "0$str"
            }
            hex.append(str.substring(str.length - 2))
        }
        return hex.toString()
    }

}
sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
}