package com.perfectyang.demoinjectdi.page.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreen(
   modifier: Modifier = Modifier,
   homeViewModel: HomeViewModel = hiltViewModel()
) {
   val stateInfo by homeViewModel.stateInfo.collectAsState()
   Column {
      Text(text = stateInfo.title)
      TextField(value = stateInfo.title, onValueChange = {
         homeViewModel.onAction(infoAction.UpdateTitle(it))
      })
   }
}