package com.perfectyang.rentcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.LibraryBooks
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.perfectyang.rentcar.ui.theme.Blur
@Preview(
    showBackground = true
)
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
   Row (
       modifier = modifier
           .clip(RoundedCornerShape(26.dp))
           .padding(horizontal = 26.dp, vertical = 10.dp),
       horizontalArrangement = Arrangement.SpaceBetween,
       verticalAlignment = Alignment.CenterVertically
   ) {
      bottomBarItems.forEach { bottomItem ->
          if (bottomItem.isSelected) {
              Box (
                  modifier = Modifier
                      .size(38.dp)
                      .border(
                          width = 1.dp,
                          color = Color.White,
                          shape = RoundedCornerShape(14.dp)
                      )
                      .padding(2.dp)
                      .clip(RoundedCornerShape(14.dp))
                      .background(Blur)
              ) {
                  Icon(
                      imageVector = bottomItem.icon,
                      contentDescription = null,
                      tint = Color.White,
                      modifier = Modifier.size(38.dp)
                  )
              }
          } else {

              Icon(
                  imageVector = bottomItem.icon,
                  contentDescription = null,
                  tint = Color.White,
                  modifier = Modifier.size(38.dp)
              )
          }
      }
   }
}


data class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val isSelected: Boolean
)

val bottomBarItems = listOf(
    BottomBarItem(
        title = "Home",
        icon = Icons.Rounded.Home,
        isSelected = true
    ),
    BottomBarItem(
        title = "Account",
        icon = Icons.Rounded.AccountBox,
        isSelected = false
    ),
    BottomBarItem(
        title = "Analytics",
        icon = Icons.AutoMirrored.Rounded.LibraryBooks,
        isSelected = false
    ),
    BottomBarItem(
        title = "Settings",
        icon = Icons.Rounded.Settings,
        isSelected = false
    ),
)