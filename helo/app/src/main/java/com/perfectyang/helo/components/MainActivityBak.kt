package com.perfectyang.helo.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.perfectyang.helo.ui.theme.HeloTheme

class MainActivityBak : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            val statusBarHeightTop = LocalDensity.current.run {
                WindowInsets.statusBars.getTop(this).toDp()
            }
            HeloTheme(
            ) {
                Column (
                    modifier = Modifier
                        .background(Color(0xFF03DAC5))
                        .padding(top = statusBarHeightTop)
                        .fillMaxSize(),
                ) {
//                ListViewScreen();
//            LoginScreeen();
//                ModifierDemo()
//                ImageDemo()
//                    RadioDemo()

                }
            }

        }
    }
}


