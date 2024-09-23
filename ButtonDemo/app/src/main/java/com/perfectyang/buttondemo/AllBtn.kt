package com.perfectyang.buttondemo

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.perfectyang.buttondemo.ui.theme.ButtonDemoTheme

@Composable
fun AllBtn(modifier: Modifier = Modifier) {
    BtnDemo()
}


@Composable
fun BtnDemo( modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(top = 20.dp)) {
        NormalBtn()
        NormalBtn2()
        NormalBtn3()
        ShadowBtn()
        ShadowBtnRound()
        
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            DashLine(
                Modifier.weight(1f)
            )
            Text(text = "OR", fontSize = 14.sp, color = Color.Red)
            DashLine(
                Modifier.weight(1f)
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().height(62.dp).shadow(
                shape = RoundedCornerShape(percent = 50),
                elevation = 6.dp,
                spotColor = Color.Blue
            )
        ) {
            
        }



    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonDemoTheme {
        BtnDemo(modifier = Modifier.fillMaxSize())
    }
}


@Composable
fun NormalBtn(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd =  20.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(4.dp)
    ) {
        Text(text = "Click Me", fontSize = 16.sp)
    }
}


@Composable
fun NormalBtn2(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(Color(0xFFFF0048)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Subscriptions,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                .padding(4.dp)
        )
        Text(text = "Click Me", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(start = 4.dp))
    }
}




@Composable
fun NormalBtn3(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = CircleShape,

        colors = ButtonDefaults.buttonColors(Color(0xFFFF0048)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Subscriptions,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.White, shape = CircleShape)
                .padding(4.dp)
        )
        Text(text = "Click Me", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(start = 4.dp))
    }
}




@Composable
fun ShadowBtn(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF25D482)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(4.dp)
            .shadow(
                elevation = 6.dp,
                shape = CircleShape,
                clip = false,
                spotColor = Color.Green
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.Subscriptions,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.White, shape = CircleShape)
                .padding(4.dp)
        )
        Text(text = "Click Me", fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(start = 4.dp), letterSpacing = 0.1.em)
    }
}

@Composable
fun ShadowBtnRound(modifier: Modifier = Modifier) {
    Column {
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF),
                contentColor = Color(0xFF2196F3)
            ),
            modifier = Modifier
                .size(70.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = CircleShape,
//                    clip = false,
                    spotColor = Color.Green
                )
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
                tint = Color.Blue,
            )
        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF08F5F),
                contentColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(62.dp)
//                .shadow(
//                    elevation = 6.dp,
//                    shape = RoundedCornerShape(20.dp),
//                    clip = false
//                )
        ) {
            Text(text = "Procceed to checkout", fontSize = 18.sp)
        }


        var num by remember { mutableStateOf("2") }

        ElevatedCard(
            onClick = { /*TODO*/ },
//            enabled = false,
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF8F8FB)
            )
        ) {
            Box(modifier = Modifier.padding(10.dp)) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        imageVector = Icons.Rounded.Subscriptions,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .border(
                                width = 1.dp, shape = RoundedCornerShape(20.dp),
                                color = Color.Black
                            )
                            .background(
                                Color(0xFFFFFFFF)
                            )
                            .padding(10.dp)
                    )
                    Column (
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 20.dp)
                    ) {
                        Text(text = "Laurens \'s", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Black.copy(0.3f))
                        Text(text = "Orange Juice", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
                        Text(text = "$ 149", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
                    }

                }
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(25.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFFFFFFFF))
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(imageVector = Icons.Rounded.Remove, contentDescription = null, tint = Color(0xFFF08F5F))
                    BasicTextField(
                        value = num,
                        onValueChange = {
                            num = it
                        },
                        modifier = Modifier
                            .width(20.dp)
                            .background(Color.Transparent)
                            .padding(vertical = 2.dp, horizontal = 2.dp),
                        textStyle = TextStyle(
                            textAlign = TextAlign.Center,
                        ),
                        maxLines = 1,
                        singleLine = true,
                        cursorBrush = SolidColor(Color(0xFFF08F5F))

                    )
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = null, tint = Color(0xFFF08F5F))
                }
            }
        }


        BasicTextField(
            value = num,
            onValueChange = {
                num = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
//                .border(
//                    width = 1.dp,
//                    color = Color.Black,
//                )
                .background(Color(0xFF29C0C5))
                .padding(20.dp),
            singleLine = true,
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                    Box(modifier = Modifier.weight(1f)) {
                        innerTextField()
                    }
                    Icon(imageVector = Icons.Rounded.Clear, contentDescription = null)

                }
            }
        )
    }
}


@Composable
fun DashLine(modifier: Modifier = Modifier) {
   Canvas(modifier = modifier) {
       drawLine(
           color = Color.Red,
           start = Offset(0f, 0f),
           end = Offset(size.width, 0f),
           pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f,8f), 0f),
           cap = StrokeCap.Round,
           strokeWidth = 1.dp.toPx()
       )
   }
}














