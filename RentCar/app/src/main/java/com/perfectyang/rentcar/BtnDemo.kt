package com.perfectyang.rentcar

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfectyang.rentcar.ui.theme.btnColor

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun BtnDemo(modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFFF6F6F6),
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Color.Green
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 5.dp,
                pressedElevation = 30.dp
            ),
//            modifier = Modifier.shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
        ) {
           Text("3 months", color = Color.White, fontSize = 18.sp)
            Text("aaa")
        }

        val scrollState = rememberScrollState()

        Row (
            modifier = Modifier
                .size(width = 152.dp, height = 98.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xFF5AE677))
                .horizontalScroll(state = scrollState)
        ) {

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color(0xFFF6F6F6),
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Green
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 30.dp
                ),
//            modifier = Modifier.shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
            ) {
                Text("3 months", color = Color.White, fontSize = 18.sp)
                Text("aaa")
            }



            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color(0xFFF6F6F6),
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Green
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 30.dp
                ),
//            modifier = Modifier.shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
            ) {
                Text("3 months", color = Color.White, fontSize = 18.sp)
                Text("aaa")
            }






        }

        Card(
            onClick = { /*TODO*/ },
            colors = CardDefaults.cardColors().copy(
                containerColor = Color(0xFFF6F6F6),
                contentColor = Color.Black
            ),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = 5.dp
//            ),
            modifier = Modifier.size(100.dp),
            border = BorderStroke(
                width = 1.dp,
                color = Color(0xFFF0F0F0)
            )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
            ) {

                Text("aa")
            }
        }


        InputField(
            leadingIconRes = R.drawable.w_1,
            placeholderText = "You email",
            modifier = Modifier.padding(horizontal = 24.dp)
        )


    }
}


@Composable
private fun InputField(
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    @DrawableRes leadingIconRes: Int,
    placeholderText: String
) {
    var inputValue by remember { mutableStateOf("") }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(62.dp),
        value = inputValue,
        onValueChange = { inputValue = it },
        visualTransformation = visualTransformation,
        singleLine = true,
        shape = RoundedCornerShape(percent = 50),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedTextColor = Color(0xFF132b4c),
            unfocusedTextColor = Color(0xFF132b4c),
            unfocusedPlaceholderColor = Color(0xFF132b4c),
            focusedPlaceholderColor = Color(0xFF132b4c),
            focusedLeadingIconColor = Color(0xFF132b4c),
            unfocusedLeadingIconColor = Color(0xFF132b4c),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Medium
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(leadingIconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        placeholder = {
            Text(text = placeholderText)
        }
    )
}
