package com.perfectyang.helo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.perfectyang.helo.R

@Preview(
  showBackground = true
)
@Composable
fun ImageDemo(modifier: Modifier = Modifier) {
    Column {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null)

//        val model = ImageRequest
//            .Builder(LocalContext.current)
//            .data("https://dms-upload-dev-sg.oss-ap-southeast-1.aliyuncs.com/uploadfile/20240624/6e245077-5975-4572-a2fb-8e7bb83dbca6.png")
//            .size(Size.ORIGINAL)
//            .build()
//        AsyncImage(
//            modifier = Modifier.clip(RoundedCornerShape(20.dp)),
//            model = model, contentDescription =null)

    }
}