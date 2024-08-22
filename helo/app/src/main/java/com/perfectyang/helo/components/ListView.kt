package com.perfectyang.helo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    device = Devices.NEXUS_10
//    showSystemUi = true
)
@Composable
fun ListViewScreen(modifier: Modifier = Modifier) {
//    Column (
//        modifier = Modifier
//            .size(200.dp, 200.dp)
//            .padding(10.dp)
//            .background(MaterialTheme.colorScheme.errorContainer),
//        verticalArrangement = Arrangement.SpaceAround,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.primaryContainer),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "first")
//            Text(text = "-")
//            Text(text = "second")
//        }
//
//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "first")
//            Text(text = "-")
//            Text(text = "second")
//        }
//    }    Column (
//        modifier = Modifier
//            .size(200.dp, 200.dp)
//            .padding(10.dp)
//            .background(MaterialTheme.colorScheme.errorContainer),
//        verticalArrangement = Arrangement.SpaceAround,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.primaryContainer),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "first")
//            Text(text = "-")
//            Text(text = "second")
//        }
//
//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "first")
//            Text(text = "-")
//            Text(text = "second")
//        }
//    }


    Box (
        modifier = Modifier
            .size(300.dp, 200.dp)
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.errorContainer),
    ){
        Row(
            modifier = Modifier
                .width(100.dp)
                .height(20.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .align(Alignment.BottomEnd)
            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "1")
            Text(text = "-")
            Text(text = "1")
        }

//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "2")
//            Text(text = "-")
//            Text(text = "2")
//        }
//
//
//        Row(
//            modifier = Modifier
//                .width(100.dp)
//                .height(20.dp)
//                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(text = "3")
//            Text(text = "-")
//            Text(text = "3")
//        }
    }

}

