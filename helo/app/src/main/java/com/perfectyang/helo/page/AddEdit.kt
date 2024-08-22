package com.perfectyang.helo.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(
   showBackground = true
)
@Composable
fun AddEdit(modifier: Modifier = Modifier) {
   Box (
      modifier = modifier
         .fillMaxSize()
         .background(Color.Black)
   ) {
      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.TopStart)
      ){
         Box (
            modifier = Modifier
               .padding(2.dp)
               .fillMaxSize()
         ) {
            Text(text = "aaaa")
            Row (
               modifier = modifier.padding(top = 20.dp, bottom = 20.dp).align(Alignment.TopStart).fillMaxSize()
            ) {
               Text(text = "center")
            }
            Text(text = "bbb", modifier=Modifier.align(Alignment.BottomEnd))
         }
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.TopEnd)
      ){
         Text(text = "bbb")
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.TopCenter)
      ){
         Text(text = "bbb")
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.CenterStart)
      ){
         Text(text = "ccc")
      }
      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.Center)
      ){
         Text(text = "ccc")
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.CenterEnd)
      ){
         Text(text = "ccc")
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.BottomStart)
      ){
         Text(text = "ccc")
      }


      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.BottomCenter)
      ){
         Text(text = "ccc")
      }

      Row (
         modifier = modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
            .align(Alignment.BottomEnd)
      ){
         Text(text = "ccc")
      }


   }
}