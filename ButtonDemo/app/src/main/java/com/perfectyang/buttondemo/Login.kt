package com.perfectyang.buttondemo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Login (modifier : Modifier = Modifier) {
    MyBox (
        modifier = modifier
    ) {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "欢迎登页",
                fontWeight = FontWeight(800),
                fontSize = 26.sp,
                modifier = Modifier.padding(bottom = 50.dp)
            )
            MyTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "用户名",
                keyboardOptions = KeyboardOptions(),
                keyboardActions = KeyboardActions(),
                value = username,
                onChange = {
                   username = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "密码",
                keyboardOptions = KeyboardOptions(),
                keyboardActions = KeyboardActions(),
                trailingIcon = Icons.Default.Lock,
                value = password,
                onChange = {
                    password = it
                }
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D4C92),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "登录",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                )
            }
        }
    }

}
