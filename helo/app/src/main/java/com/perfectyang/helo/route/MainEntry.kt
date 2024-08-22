package com.perfectyang.helo.route

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.perfectyang.helo.model.RouteItem
import com.perfectyang.helo.page.BankList
import com.perfectyang.helo.page.CreditList
import com.perfectyang.helo.page.LoginScreeen
import com.perfectyang.helo.page.Mine
import com.perfectyang.helo.ui.theme.Purple40
import com.perfectyang.helo.ui.theme.blueColor
import com.perfectyang.helo.ui.theme.secondBlueColor

@Composable
fun MainEntry(modifier: Modifier = Modifier, activeTab: Int = 0, onTab: (activeTab: Int) -> Unit) {
    val navList = listOf(
        RouteItem(title = "储蓄卡", icon = Icons.Filled.AccountBox),
        RouteItem(title = "信用卡", icon = Icons.Filled.ShoppingCart),
        RouteItem(title = "我的", icon = Icons.Filled.Home),
    )
    var selectedItem by remember { mutableIntStateOf(activeTab) }
    NavigationBar (
        modifier = Modifier.height(60.dp),
        containerColor = secondBlueColor,
    ) {
        navList.forEachIndexed { index, item ->
            NavigationBarItem(
                modifier = Modifier.padding(top = 10.dp),
                icon = { Icon(item.icon, contentDescription = item.title,
                    tint = if (selectedItem == index) Color.Red else LocalContentColor.current
                ) },
                label = {
                    Text(
                        color = if (selectedItem == index) Color.Red else Color.White,
                        text = item.title
                    )
                        },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onTab(index)
                }
            )
        }
    }
}


@Composable
fun MainTitle(addEdit: () -> Unit) {
    Row (
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text( "银行卡列表")
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red
            ),
            onClick = { addEdit() },

        ) {
            Text("添加")
        }
    }
}


@Composable
fun MainFrame(backLogin: ()->Unit = {}, addEdit: () -> Unit = {}, navController: NavController) {
    var activeTab by remember { mutableIntStateOf(0) }
    Scaffold (
        contentColor =  MaterialTheme.colorScheme.primaryContainer,
        containerColor =  blueColor,
        topBar = {
            MainTitle() {
                addEdit()
            }
        },
        bottomBar={
            MainEntry(){
                activeTab = it
            }
        }
    ){ paddingValues ->
        when(activeTab) {
            0 -> BankList(Modifier.padding(top = paddingValues.calculateTopPadding()))
            1 -> CreditList(Modifier.padding(top=paddingValues.calculateTopPadding()))
            2 -> Mine(Modifier.padding(top=paddingValues.calculateTopPadding()), navController)
        }
    }
}
