package com.perfectyang.rentcar

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowRight
import androidx.compose.material.icons.automirrored.rounded.FactCheck
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SettingsOverscan
import androidx.compose.material.icons.rounded.ViewComfy
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.pm.ShortcutXmlParser
import com.perfectyang.rentcar.ui.theme.Primary
import com.perfectyang.rentcar.ui.theme.Secondary
import com.perfectyang.rentcar.ui.theme.btnColor
import com.perfectyang.rentcar.ui.theme.btnSecondColor
import com.perfectyang.rentcar.ui.theme.grayColor
import dev.chrisbanes.haze.haze

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
fun Dot(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(btnColor),
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.White)
                .padding(20.dp)
                .verticalScroll(scrollState),
        ) {

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Total Balance",
                    color = Color.Black.copy(0.5f),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = "$ 2,548.00",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {

                OperateSection(
                    modifier = Modifier,
                    icon = Icons.Rounded.Add,
                    title = "Add"
                )
                OperateSection(
                    modifier = Modifier,
                    icon = Icons.Rounded.ViewComfy,
                    title = "Play"
                )
                OperateSection(
                    modifier = Modifier,
                    icon = Icons.AutoMirrored.Rounded.Send,
                    title = "Send"
                )
            }
            
            HorizontalDivider(
                thickness = 2.dp,
                color = btnColor,
                modifier = Modifier.padding(vertical = 4.dp)
            )




            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(grayColor.copy(0.4f))
                    .padding(vertical = 1.dp, horizontal = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SelectBtn(
                    modifier = Modifier.weight(1f),
                    selected = true
                ) {
                    Text(
                        text = "Cards",
                        color = Color.Black
                    )
                }
                SelectBtn(
                    modifier = Modifier.weight(1f),
                    selected = false
                ) {
                    Text(
                        text = "Accounts",
                        color = Color.Black
                    )
                }
            }


            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier.size(width = 324.dp, height = 225.dp)
                ) {

                    Row (
                        modifier = Modifier
                            .offset(x = 20.dp)
                            .padding(end = 40.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(btnColor, btnSecondColor)
                                )
                            )
                    ) {

                    }
                    Row (
                        modifier = Modifier
                            .offset(y = 20.dp)
                            .fillMaxSize()
                            .padding(bottom = 20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(btnColor)
                    ) {
                    }
                }

            }

            Spacer(modifier = Modifier.height(10.dp))
            SelectBar(
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            SelectBar(
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(10.dp))
            SelectBar(
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            SelectBar(
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        shape = ButtonDefaults.shape,
                        color = btnColor
                    ),
                contentPadding = PaddingValues(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color.Transparent
                )
                ) {
               Text(
                   text = "Next",
                   color = btnColor,
                   fontSize = 18.sp

                   )
            }





        }
    }
}
//Icon: @Composable (modifier: Modifier) -> Unit = {},

@Composable
fun SelectBtn(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    TextCmp: @Composable () -> Unit = {}) {
    Button(
        modifier = modifier.padding(start = 3.dp, end = 3.dp)
        ,onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.White else Color.Transparent
        ),
        ) {
        TextCmp()
    }

}

@Composable
fun SelectBar(modifier: Modifier = Modifier) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(grayColor.copy(0.3f))
            .padding(20.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = null,
                tint = btnColor,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(10.dp)
            )

            Column (
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)

            ) {
                Text(
                    text = "Bank Link",
                    fontSize = 18.sp,
                    color = btnColor,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Connect your bank\naccount to deposit & fund",
                    fontSize = 12.sp,
                    color = btnColor.copy(0.5f),
                    lineHeight = 14.sp,
                )
            }

            Icon(
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = null,
                tint = btnColor,
                modifier = Modifier.size(30.dp)
            )
        }
    }

}

@Composable
fun OperateSection(modifier: Modifier = Modifier, icon: ImageVector, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            tint = btnColor,
            contentDescription = null,
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = btnColor,
                    shape = CircleShape
                )
                .padding(15.dp),
            )
        Text(
            text = title,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }

}


