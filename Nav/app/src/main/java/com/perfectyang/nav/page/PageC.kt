package com.perfectyang.nav.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.perfectyang.nav.viewModel.ComputerViewModel

@Composable
fun PageC(navController: NavController, viewModel: ComputerViewModel = ComputerViewModel()) {
    Row (
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {



        Text(text = "Page C ${viewModel}")
        Button(onClick = {
            navController.navigate("A") {
                popUpTo("A"){inclusive=true}
            }
        }) {
            Text(text = "go to A")
        }
    }

}
