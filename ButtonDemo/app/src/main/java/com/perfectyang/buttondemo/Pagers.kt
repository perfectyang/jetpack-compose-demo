package com.perfectyang.buttondemo

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

data class Page(
    val title: String,
    val description: String,
    val image: String
)

val pages = listOf(
    Page("Page 1", "This is page 1", "https://cdn.pixabay.com/photo/2023/03/17/23/04/pine-needles-7859595_1280.jpg"),
    Page("Page 2", "This is page 2", "https://cdn.pixabay.com/photo/2024/07/08/17/54/model-8881740_1280.jpg"),
    Page("Page 3", "This is page 3", "https://cdn.pixabay.com/photo/2023/08/23/12/50/fog-8208493_1280.jpg"),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pagers(modifier: Modifier = Modifier) {

    val pageState = rememberPagerState(
        0
    ) {
        pages.size
    }

    val buttonState = remember {
        derivedStateOf {
            when (pageState.currentPage) {
               0 -> listOf("", "Next")
               1 -> listOf("Previous", "Next")
               2 -> listOf("Previous", "Get Started")
               else -> listOf("", "")
            }
        }
    }

    Column (
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        ) { index ->
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val page = pages[pageState.currentPage]
                AsyncImage(
                    model = page.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text("pageer-------${page.title}")
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val scope = rememberCoroutineScope()
            Dot(pages = pages, curPage = pageState.currentPage) {
                scope.launch {
                    pageState.animateScrollToPage(it)
                }
            }
            if (buttonState.value[0].isNotEmpty()) {
                Button(onClick = {
                    scope.launch {
                        pageState.animateScrollToPage(pageState.currentPage - 1)
                    }
                }) {
                    Text(text = buttonState.value[0])
                }
            } else {
                Text(text = "")
            }

            Button(onClick = {
                scope.launch {
                    if (pageState.currentPage == 2) {

                    } else {
                        pageState.animateScrollToPage(pageState.currentPage + 1)
                    }
                }
            }) {
                Text(text = buttonState.value[1])
            }
        }
    }
}


@Composable
fun Dot(modifier: Modifier = Modifier, pages: List<Page>, curPage: Int, goPage: (Int) -> Unit) {
   Row (
       horizontalArrangement = Arrangement.spacedBy(10.dp)
   )  {

       repeat(pages.size) {
           Box(
               modifier = Modifier
                   .size(10.dp)
                   .clip(CircleShape)
                   .background(
                       if (it == curPage) Color.Green else Color.Gray
                   )
                   .border(width = 1.dp, color = Color.White, shape = CircleShape)
                   .clickable {
                       goPage(it)
                   },
           )
       }
   }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    backgroundColor = 0xFFFF6161
)
@Composable
fun ShowCard(modifier: Modifier = Modifier) {
   ElevatedCard(
       modifier = modifier,
       onClick = { /*TODO*/ },
       elevation = CardDefaults.cardElevation(
           defaultElevation = 2.dp
       ),
       shape = RoundedCornerShape(
           topStart = 112.dp,
           topEnd = 112.dp,
           bottomStart = 10.dp,
           bottomEnd = 10.dp
       ),
       colors = CardDefaults.cardColors(
          containerColor = Color.White
       )
   ) {

       Column (
           modifier = Modifier.padding(10.dp),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Image(
               painter = painterResource(id = R.drawable.test),
               contentDescription = null,
               modifier = Modifier.clip(RoundedCornerShape(topStart = 112.dp, topEnd = 112.dp)),
               contentScale = ContentScale.Crop
           )
           Text(
               text = "Summer Shirt",
               fontSize = 18.sp,
               modifier = Modifier.padding(vertical = 8.dp)
           )
           Text(
               text = "$55.5",
               fontSize = 20.sp,
               fontWeight = FontWeight.SemiBold
           )


       }

   }
}










