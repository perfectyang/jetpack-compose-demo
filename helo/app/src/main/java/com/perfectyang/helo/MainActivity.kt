package com.perfectyang.helo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.perfectyang.helo.db.BankDatabase
import com.perfectyang.helo.route.NavRouteMap
import com.perfectyang.helo.ui.theme.HeloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeloTheme {
                NavRouteMap()
            }
        }
    }
}



