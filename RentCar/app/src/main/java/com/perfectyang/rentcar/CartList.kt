package com.perfectyang.rentcar

import android.content.res.Configuration
import android.view.Display.Mode
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.perfectyang.rentcar.ui.theme.RentCarTheme
import com.perfectyang.rentcar.ui.theme.Secondary

@Composable
fun CartList(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    LazyColumn (
        modifier = modifier,
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding() + 22.dp,
            bottom = paddingValues.calculateBottomPadding() + 80.dp
        )
    ) {
        itemsIndexed(luxuriousCars) { index, car ->
            CartItem(
                car = car,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
            )
            Spacer(modifier = modifier.height(22.dp))
        }
    }
}


@Composable
fun CartItem(car: Car, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(car.bgColor)

    ) {
        Image(
            painter = painterResource(id = car.image),
            contentDescription = null,
            modifier = Modifier.offset( x = 150.dp, y = 0.dp)
        )
        Column (
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column (
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            ) {
                CarInfo(car)
                Spacer(modifier = Modifier.height(10.dp))
                Rater(car)
            }
            BuyButton(car = car)
        }

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeCarItemPreview() {
    RentCarTheme {
        CartItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp),
            car = Car(
                name = "Ferrari SF90 Stradale",
                image = R.drawable.ferrari_car,
                color = Color.Red,
                logo = R.drawable.ferrari_logo,
                recommendation = 98,
                recommendationRate = 4.9f,
                rentalDays = 7,
                price = 789,
                recommenders = listOf(
                    R.drawable.m_1, R.drawable.w_2, R.drawable.m_3
                ),
                bgColor = Secondary
            )
        )
    }
}


@Composable
fun CarInfo(car: Car) {
   Row (
       modifier = Modifier,
       verticalAlignment = Alignment.CenterVertically
   ) {
       Image(
           painter = painterResource(id = car.logo),
           contentDescription = null,
           modifier = Modifier
               .clip(CircleShape)
               .size(40.dp)
               .background(MaterialTheme.colorScheme.background)
               .padding(6.dp)
       )
       Spacer(modifier = Modifier.width(10.dp))
       Column {
           Row (
               verticalAlignment = Alignment.CenterVertically
           ) {
               Text(
                   text = "Color:",
                   fontSize = 12.sp,
               )
               Box(modifier = Modifier
                   .padding(start = 2.dp)
                   .clip(CircleShape)
                   .size(10.dp)
                   .background(car.color)
                   .border(
                       width = 1.dp,
                       color = Color.Black,
                       shape = CircleShape
                   )
               )

           }
           Text(
               text = car.name,
               fontSize = 12.sp,
               fontWeight = FontWeight.SemiBold
           )
       }

   }
}


@Composable
fun Rater(car: Car) {
    Column {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                RaterIcon(
                    modifier = Modifier,
                    icon = car.recommenders[0]
                )
                RaterIcon(
                    modifier = Modifier.offset(x = 24.dp),
                    icon = car.recommenders[1]
                )
                RaterIcon(
                    modifier = Modifier.offset(x = 48.dp),
                    icon = car.recommenders[2]
                )
            }
            Spacer(modifier = Modifier.width(60.dp))
            Text(
                text = car.recommendationRate.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
    Text(
        text = "${car.recommendation}% Recommended",
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
}

@Composable
fun RaterIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    ) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(30.dp)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
    )
}



@Composable
fun BuyButton(modifier: Modifier = Modifier, car: Car) {
    Row (
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(start = 25.dp, end = 16.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Column (
           modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                text = "${car.rentalDays} Days",
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                fontSize = 12.sp,
            )
            Text(
                text = "$${car.price}.00",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
    }
}