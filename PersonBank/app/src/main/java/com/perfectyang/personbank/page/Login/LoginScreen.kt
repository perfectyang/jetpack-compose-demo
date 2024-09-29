package com.perfectyang.personbank.page.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.perfectyang.personbank.db.UserDb.UserEntity
import com.perfectyang.personbank.router.Screens


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel:LoginViewModel = hiltViewModel()
) {


    val userData by loginViewModel.getUserData().collectAsState(null)

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var loading by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(key1 = userData) {
        userData.let {
            username = it?.username ?: ""
            password = it?.password ?: ""
        }
    }
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        userData?.let {
            Text(text = "${it.userId}")
        }

        OutlinedTextField(value = username, onValueChange = {
            username  = it
        })

        OutlinedTextField(value = password, onValueChange = {
            password  = it
        })

        Button(onClick = {
            loginViewModel.login(username, password) {
                navController.navigate(Screens.ScreenAppRoute.route) {
                    popUpTo(Screens.ScreenAuthRoute.route) {
                        inclusive = true
                    }
                }
            }
        }) {
            Text("login")
        }

    }



}