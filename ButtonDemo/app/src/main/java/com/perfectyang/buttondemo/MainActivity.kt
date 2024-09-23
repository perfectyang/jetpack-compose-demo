package com.perfectyang.buttondemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.perfectyang.buttondemo.ui.theme.ButtonDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlowLayout(modifier = Modifier.padding(innerPadding))
//                    GlowingCard(modifier = Modifier.padding(innerPadding))
//                    Pagers(modifier = Modifier.padding(innerPadding))
//                    Login(modifier = Modifier.padding(innerPadding))


//                    Column(
//                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ){
//                        Row() {
//                            ShowCard(modifier = Modifier.weight(1f))
//                            ShowCard(modifier = Modifier.weight(1f))
//                        }
//                    }
                }
            }
        }
    }
}
