package com.perfectyang.rentcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun ImageDemo(modifier: Modifier = Modifier, url: String?) {
   Column (
       modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Text(text = "图片显示")
       val imageUrl = url?: "http://oss-other.beautydms.com/uploadfile/20240327/93c5dfdd-b3d9-4d0a-93b8-2af63fa32184.jpg"
       val model = ImageRequest
           .Builder(LocalContext.current)
           .data(imageUrl)
           .size(Size.ORIGINAL)
           .build()

       val imageState = rememberAsyncImagePainter(model = model).state
       if (imageState is AsyncImagePainter.State.Success) {
           Image(
               painter = imageState.painter,
               contentDescription = null,
               modifier = Modifier
                   .size(200.dp)
                   .clip(RoundedCornerShape(20.dp))
                   .border(
                       width = 1.dp,
                       color = Color.Red,
                       shape = RoundedCornerShape(20.dp)
                   )
           )
       }
       if (imageState is AsyncImagePainter.State.Loading) {
           Text("加载Loading")
       }

       if (imageState is AsyncImagePainter.State.Error) {
           Text("加载失败")
       }

       AsyncImage(model = url, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.1f)
   }
}