package com.perfectyang.personbank.page.Home

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.health.connect.datatypes.units.Percentage
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.perfectyang.personbank.db.PersonBankDb.PersonBankEntity
import com.perfectyang.personbank.page.Login.LoginViewModel
import com.perfectyang.personbank.router.RouterIndex
import com.perfectyang.personbank.router.Screens
import com.perfectyang.personbank.ui.theme.PersonBankTheme
import com.perfectyang.personbank.ui.theme.bankBackGroundColor
import kotlin.math.sin


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val state by homeViewModel.state.collectAsState()
    val userData by loginViewModel.getUserData().collectAsState(null)
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }
    var flag by remember {
       mutableStateOf("")
    }

    // 分享功能
    fun shareText(text: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }

    // 复制功能
    fun copy(text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "复制成功", Toast.LENGTH_SHORT).show()
    }




    LaunchedEffect(key1 = userData) {
        userData?.let {
            it.userId?.let { it1 -> homeViewModel.setUserId(it1.toLong()) }
        }
    }

    val listState = rememberLazyListState()
    LaunchedEffect (key1 = state.personBankList, key2 = state.category) {
        listState.scrollToItem(0)
    }




    if (showDialog) {
        AlertDialog(
            containerColor = Color(0xD50DD1BF),
            icon = {
               Icon(imageVector = Icons.Default.Delete, contentDescription = "删除", tint = Color.Red)
            },
            title = {
                Text(text = "确定要删除该条数据吗")
            },
            onDismissRequest = {
                showDialog = false
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false
                }) {
                    Text(text = "取消")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show()
                    homeViewModel.deleteRow(state.personBankList[flag.toInt()].id!!)
                    showDialog = false
                }) {
                   Text(text = "确定")
                }
            }
        )
    }



    Scaffold (
        modifier = Modifier,
        floatingActionButton = {
            Column (
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp).clip(CircleShape).background(Color(0xFF064D4D)).padding(5.dp).clickable {
                        navController.navigate(Screens.ScreenUserRoute.route)
                    },
                    tint = Color.White,
                )
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp).clip(CircleShape).background(Color(0xFF064D4D)).padding(5.dp).clickable {
                        navController.navigate(Screens.ScreenAddEditRoute.route)
                    },
                    tint = Color.White,
                )

            }
        }

    ) {

        Column(modifier = Modifier.padding(it)) {
            TabRow(
                selectedTabIndex = state.category.toInt() - 1,
                containerColor = bankBackGroundColor,
                contentColor = Color.White,
                divider = {
                    HorizontalDivider(
                        color = Color(0xFF03E7D2)
                    )
                }
            ) {
                Tab(
                    selected = state.category == "1",
                    onClick = {
                        homeViewModel.selectTab("1")
                    },
                    text = {
                        Text(
                            text = if (state.category == "1") "信用卡(${state.personBankList.size})" else "信用卡",
                            fontSize = if (state.category == "1") 20.sp else 16.sp,
                            color = if (state.category == "1") Color(0xFFFFC107) else Color.Black,
                        )
                    }
                )
                Tab(
                    selected = state.category == "2",
                    onClick = {
                        homeViewModel.selectTab("2")
                    },
                    text = {
                        Text(
                            text =  if (state.category == "2") "借记卡(${state.personBankList.size})" else "借记卡",
                            fontSize = if (state.category == "2") 20.sp else 16.sp,
                            color = if (state.category == "2") Color(0xFFFFC107) else Color.Black,
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            SearchBar(
                value = state.searchValue,
                onValueChange = {
                    homeViewModel.searchValue(it)
                },
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (state.personBankList.isEmpty()) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f), contentAlignment = Alignment.Center) {
                    Text(text = "暂无数据！！！！！")
                }
            } else {
                LazyColumn(
                    state = listState
                ) {
                    itemsIndexed(state.personBankList) { index, item ->
                        BankCard(personBank = item, index = index, onDelete = {
                            showDialog = true
                            flag = index.toString()
                        }, share = {
                            shareText("${item.bank_name} ${item.bank_number}")
                        }, copy = {
                            navController.navigate(Screens.ScreenAddEditRoute.route + "?bankId=${item.id}")
//                            copy("${item.bank_name} ${item.bank_number}")
                        })
                    }
                }
            }

        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BankCard(modifier: Modifier = Modifier, personBank: PersonBankEntity, index: Int, onDelete: () -> Unit = {}, share: () -> Unit = {}, copy: () -> Unit = {}) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color(0xFF009688))
        .padding(horizontal = 10.dp, vertical = 5.dp)
        .combinedClickable(
            enabled = true,
            onClick = {
                copy()
            },
            onLongClick = {
                onDelete()
            }
        )
    ) {
        Column(modifier = Modifier.padding(start = 0.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "${personBank.bank_name}",
                color = Color(0xFFFFC107),
                fontSize = 18.sp
            )
            Text("卡号: ${personBank.bank_number} (${personBank.bank_number?.length}位）", fontSize = 16.sp)
            if (personBank.back_card_three !== null && personBank.back_card_three !== "" && personBank.back_card_three?.isNotEmpty() == true) {
                personBank.back_card_three?.let { Text("卡背三位数: $it", fontSize = 16.sp) }
            }
            if (personBank.valid_time !== null && personBank.valid_time !== "" && personBank.valid_time?.isNotEmpty() == true) {
                personBank.valid_time?.let { Text("有效期: $it", fontSize = 16.sp) }
            }
            if (personBank.quota !== null && personBank.quota !== "" && personBank.quota?.isNotEmpty() == true) {
                personBank.quota?.let { Text("总额度: ${try {
                  it.toInt().formatWithCommas()  
                } catch (e: NumberFormatException) {
                    "额度有误"
                }}", fontSize = 16.sp) }
            }
        }
        Icon(
            imageVector = Icons.Filled.Share,
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .size(20.dp)
                .offset(x = 0.dp, y = 10.dp)
                .clickable {
                    share()
                },
            contentDescription = null,
            tint = Color.White
        )

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES
    )
@Composable
fun Test(modifier: Modifier = Modifier) {
    PersonBankTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                SearchBar(modifier = Modifier, value = "", onValueChange = {})
                BankCard(modifier = Modifier.padding(innerPadding), personBank = PersonBankEntity("123", "123", "123", null, null, "1", "1", "1234234", "1234234"), index = 5)
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp).clip(CircleShape).background(Color(0x7208F7F7)).padding(5.dp).clickable {
                    },
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier, value: String = "", onValueChange: (String) -> Unit) {
   Box(
       modifier = modifier
           .padding(horizontal = 8.dp)
           .border(width = 1.dp, color = Color.White.copy(0.6f), shape = RoundedCornerShape(10.dp))
           .clip(shape = RoundedCornerShape(10.dp))
           .background(Color.Transparent)
           .fillMaxWidth()

   )
   {
       BasicTextField(
           value = value,
           onValueChange = onValueChange,
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 10.dp, vertical = 10.dp),
           textStyle = TextStyle(
               fontSize = 16.sp,
               color = Color.Black,
               textDecoration = TextDecoration.None,
           ),
           maxLines = 1,
           singleLine = true,
           cursorBrush = SolidColor(Color.White)
       )
   }
}


