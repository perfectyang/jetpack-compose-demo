package com.perfectyang.helo.page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.perfectyang.helo.compositionLocal.LocalUserViewModel
import com.perfectyang.helo.route.Route
import com.perfectyang.helo.service.UserInfoManager
import com.perfectyang.helo.viewModel.MineViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun Mine(modifier: Modifier = Modifier, navController: NavController) {
   val viewModel = LocalUserViewModel.current
   val coroutineScope = rememberCoroutineScope()
   val context = LocalContext.current
   val userInfo = UserInfoManager(LocalContext.current)

   val mineViewModel: MineViewModel = viewModel<MineViewModel>()

   val textState = mineViewModel.textState.collectAsState()
   

   val username by userInfo.username.collectAsState(initial = "")


   Row (
      modifier = modifier.fillMaxSize(),
      verticalAlignment = Alignment.CenterVertically

   ) {
      Column {

         Text(text = username?: "")

         Column {
            Text(text = textState.value)
            TextField(value = textState.value, onValueChange = {
               mineViewModel.changeText(it)
            })
         }



         Button(onClick = {
            coroutineScope.launch {
               viewModel.clear() {
                  Toast.makeText(context, "退出成功", Toast.LENGTH_LONG).show()
                  navController.navigate(Route.Login)
               }
            }
         }) {



            Text("退出登录")
         }
      }
   }

}