package com.perfectyang.helo.page

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextButton
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.perfectyang.helo.compositionLocal.LocalUserViewModel
import com.perfectyang.helo.ui.theme.blueColor
import com.perfectyang.helo.ui.theme.secondBlueColor
import com.perfectyang.helo.viewModel.AuthState
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


@Preview()
@Composable
fun LoginScreeen(naviate: () -> Unit = {}) {

    val viewModel = LocalUserViewModel.current
    val coroutineScope = rememberCoroutineScope()
    val authState = viewModel.authState.observeAsState()
    LaunchedEffect(authState.value) {
       if (authState.value === AuthState.Authenticated) {
           naviate()
       }
    }

    Column (
        modifier = Modifier.fillMaxSize().background(blueColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome Back", fontSize = 28.sp,
            fontWeight = FontWeight.Bold,

            )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = viewModel.userName, onValueChange = {
            viewModel.userName = it
        }, label = {
            Text(text = "Email address")
        })
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(value = viewModel.password, onValueChange = {
            viewModel.password = it
        }, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.size(width = 200.dp, height = 50.dp),
            onClick = {
                coroutineScope.launch {
                    viewModel.login {
                        naviate()
                    }
                }
            },
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                if (viewModel.loading) {
                    LinearProgressIndicator(modifier = Modifier.height(10.dp), color = Color.Red, trackColor = Color.Blue)
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "登录")
                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Forget Password ??")
        }
    }

}