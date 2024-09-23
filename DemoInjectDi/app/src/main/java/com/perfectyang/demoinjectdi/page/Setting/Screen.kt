package com.perfectyang.demoinjectdi.page.Setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.perfectyang.demoinjectdi.page.Home.HomeViewModel
import com.perfectyang.demoinjectdi.page.Home.infoAction


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val stateInfo by homeViewModel.stateInfo.collectAsState()

    Column {
        TextField(
            modifier = modifier.background(Color.Transparent),
            value = stateInfo.title,
            onValueChange = {
                homeViewModel.onAction(
                    infoAction.UpdateTitle(it)
                )
            },
            label = {
                Text("search")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null, modifier = Modifier.size(20.dp))
            },
            colors = TextFieldDefaults.colors().copy(
                focusedTextColor = Color.Red
            )
        )
    }
}