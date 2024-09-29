package com.perfectyang.personbank.page.User

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.perfectyang.personbank.db.UserDb.UserEntity
import com.perfectyang.personbank.page.Login.LoginViewModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow


@Composable
fun UserScreen(modifier: Modifier = Modifier, navController: NavController) {

    val userViewModel = hiltViewModel<UserViewModel>()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val userList by userViewModel.getAllUser().collectAsState(initial = emptyList())
    val userData by loginViewModel.getUserData().collectAsState(initial = null)





    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ) {
            Text(text = "用户列表", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Green)
            userData?.let {
                Text(text = "当前用户：${it.username}", color = Color.Red, fontSize = 26.sp)
            }
        }
        LazyColumn (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .fillMaxSize(),
        ) {
            itemsIndexed(userList) { index, user ->
                if (user.username != userData?.username) {
                    UserItem(user = user, switchUser = {
                        loginViewModel.login(user.username, user.password) {
                            navController.popBackStack()
                        }
                    })
                }
            }
        }
    }


}


@Composable
fun UserItem(modifier: Modifier = Modifier, user: UserEntity, switchUser: () -> Unit = {}) {
   Box(modifier = modifier
       .fillMaxWidth()
       .padding(horizontal = 10.dp, vertical = 10.dp)
       .clip(shape = RoundedCornerShape(20.dp))
       .background(Color.White)
       .clickable {
           switchUser()
       }
   ) {
       Row (
           horizontalArrangement = Arrangement.spacedBy(20.dp),
           modifier = Modifier.padding(start = 10.dp)
       ) {
           Text(text = "用户名：${user.username}", color = Color.Black, fontSize = 18.sp)
           Text(text = "密码：${user.password}", color = Color.Black, fontSize = 18.sp)
       }
   }
}

