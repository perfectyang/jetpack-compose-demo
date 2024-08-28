package com.perfectyang.rentcar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfectyang.rentcar.ui.theme.Primary

@Composable
fun Pager(modifier: Modifier = Modifier) {
    var selected by remember {
        mutableStateOf(0)
    }
   Column (
       modifier = modifier
   ) {
        Spacer(modifier = Modifier.height(10.dp))
       Text(
           text = "Luxurious\nRental Cars",
           fontSize = 25.sp,
           color = Color.White,
           fontWeight = FontWeight.SemiBold,
           lineHeight = 40.sp,
           modifier = Modifier.padding(horizontal = 22.dp)
       )

       Row (
           modifier = Modifier.fillMaxWidth()
       ) {
           TabItem(
               modifier = Modifier.weight(1f),
               title = "luxurious",
               selected = selected == 0,
               type = 0,
               onClick = {
                  selected = it
               }
           )
           TabItem(
               modifier = Modifier.weight(1f),
               title = "VIP Cars",
               selected = selected == 1,
               type = 1,
               onClick = {
                   selected = it
               }
           ) { _modifier ->
               Text(
                   text = "New",
                   color = Color.Black,
                   fontSize = 12.sp,
                   fontWeight = FontWeight.SemiBold,
                   modifier = _modifier
                       .alpha(0.7f)
                       .clip(RoundedCornerShape(20.dp))
                       .background(Primary)
                       .padding(horizontal = 5.dp)
               )
           }
       }

   }
}


@Composable
fun TabItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    title: String,
    type: Int = 0,
    onClick: (type: Int) -> Unit = {},
    Icon: @Composable (modifier: Modifier) -> Unit = {},
) {
    Box (
        modifier = modifier.height(50.dp).clickable {
            onClick(type)
        }
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = -20.dp)
        )
        HorizontalDivider(
           modifier = Modifier
               .align(alignment = Alignment.BottomStart)
               .fillMaxWidth(),
            thickness = if (selected) 3.dp else 1.dp,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }

}