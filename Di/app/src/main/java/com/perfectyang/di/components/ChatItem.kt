package com.perfectyang.di.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfectyang.di.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatRow(modifier: Modifier = Modifier) {
   val list = listOf("1", "2", "3","12", "13", "14", "15")
   LazyColumn(modifier = modifier
      .padding(start = 10.dp, end = 10.dp)
      .fillMaxSize()) {
      items(list) {
         ChatItem(it)
      }
   }
}

@Composable
fun ChatItem(i: String) {
   Row (
      modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
      verticalAlignment = Alignment.Top
   )  {
      Spacer(modifier = Modifier.width(8.dp))
      Image(
         modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .background(Color.Gray)
            .padding(4.dp)
            .size(40.dp),
         painter = painterResource(id = R.drawable.card), contentDescription = null)

      Spacer(modifier = Modifier.width(8.dp))

      Box(modifier = Modifier
         .size(12.dp)
         .clip(CircleShape)
         .background(Color.Red)
         .border(
            color = Color.Black,
            width = 1.dp,
            shape = CircleShape
         ))
      Column (
         modifier = Modifier.weight(1f)
      ) {
         Text(text = "$i --- Connor Frazier",
            modifier = Modifier,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
         )
         Text(
            modifier = Modifier.padding(top = 0.dp),
            fontSize = 12.sp,
            color = Color.Gray,
            text = "Whatkind ofmusicdoyou likeand" +
                    "what app do you use?")

         Row (
            verticalAlignment = Alignment.CenterVertically
         ) {
            Box() {

               Rater(image = R.drawable.card)
               Rater(image = R.drawable.card2,  modifier = Modifier.padding(start = 16.dp))
               Rater(image = R.drawable.card,  modifier = Modifier.padding(start = 28.dp))
            }
         }



      }
      Column (
         modifier = Modifier.wrapContentSize(),
         horizontalAlignment = Alignment.End
      ) {
         Text(text = "7:11 PM", color = Color.Gray)
         Spacer(modifier = Modifier.height(2.dp))
         Text(
            modifier = Modifier
               .width(20.dp)
               .clip(
                  RoundedCornerShape(4.dp)
               )
               .background(Color.Blue)
               .padding(vertical = 2.dp),
            color = Color.White,
            text = "16",
            fontSize = 12.sp,
            textAlign = TextAlign.Center
         )
      }
   }
}

@Composable
fun Rater(modifier: Modifier = Modifier, image: Int) {
   Image(
      painter = painterResource(id = image),
      contentDescription = null,
      modifier = modifier
         .size(24.dp)
         .clip(CircleShape)
         .border(
            width = 2.dp,
            color = Color.Black,
            shape = CircleShape
         )
   )

}