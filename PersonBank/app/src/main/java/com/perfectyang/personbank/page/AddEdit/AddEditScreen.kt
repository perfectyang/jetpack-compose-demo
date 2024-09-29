package com.perfectyang.personbank.page.AddEdit

import android.widget.Toast
import androidx.annotation.ReturnThis
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.perfectyang.personbank.page.Home.HomeViewModel
import com.perfectyang.personbank.page.Login.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

data class BankType (
    val type: String,
    val title: String
)

@Composable
fun AddEditScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    addEditViewModel: AddEditViewModel = hiltViewModel(),
    loginViewModel: LoginViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
    bankId: String? = null
) {
    val radioOpts = listOf(BankType("1", "信用卡"), BankType("2", "借记卡"))
    val state by addEditViewModel.state.collectAsState()
    val userData by loginViewModel.getUserData().collectAsState(null)
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect (key1 = bankId) {
        if (bankId != null) {
            coroutineScope.launch {
                val personBank = homeViewModel.getPersonBankDetail(bankId.toInt())
                addEditViewModel.updateState(personBank)
            }
        }
    }


    Column(
        modifier = modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(Color(0xF7009688))
            .padding(10.dp)
) {
        Row(
            Modifier
                .selectableGroup()
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                color = Color.White,
                text = "卡类型"
            )
            radioOpts.forEach { opt->
                Row (
                    modifier= Modifier
                        .height(50.dp)
                        .selectable(
                            selected = (state.category == opt.type),
                            onClick = {
                                addEditViewModel.onEvent(OnEvent.UpdateCategory(opt.type))
                            },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (state.category == opt.type),
                        onClick = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                        text = opt.title,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

        TextInputComp(
            text = "银行名称",
            value = state.bank_name ?: ""
        ) {
            addEditViewModel.onEvent(OnEvent.UpdateBankName(it))
        }
        TextInputComp(
            text = "银行卡号",
            value = state.bank_number.toString()
        ) {
            addEditViewModel.onEvent(OnEvent.UpdateBankNumber(it))
        }
        if (state.category.toString() == "1") {
            TextInputComp(
                text = "有效期",
                value = state.valid_time.toString()
            ) {
                addEditViewModel.onEvent(OnEvent.UpdateBankValidTime(it))
            }
            TextInputComp(
                text = "卡背面三位数",
                value = state.back_card_three.toString()
            ) {
                addEditViewModel.onEvent(OnEvent.UpdateBackCardThree(it))
            }
            TextInputComp(
                text = "账单日",
                value = state.bill_date ?: ""
            ) {
                addEditViewModel.onEvent(OnEvent.UpdateBackBillDate(it))
            }
            TextInputComp(
                text = "还款日",
                value = state.pay_date ?: ""
            ) {
                addEditViewModel.onEvent(OnEvent.UpdateBackPayDate(it))
            }
            TextInputComp(
                text = "总额度",
                value = state.quota ?: ""
            ) {
                addEditViewModel.onEvent(OnEvent.UpdateQuota(it))
            }
        }


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color(0xFF2FDBCB)
                ),
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "取消", fontSize = 14.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color(0xFF2FDBCB)
                ),
                onClick = {
                    if (
                        state.bank_name === null || state.bank_name?.trim() === ""
                        ) {
                        Toast.makeText(context, "银行名称不能为空", Toast.LENGTH_SHORT).show()
                      return@Button
                    }
                    userData?.let {
                        it.userId.let { userId ->
                            addEditViewModel.upInsertPersonBank(state, userId = userId)
                            navController.popBackStack()
                        }
                    }
                }
            ) {
                Text(text = "保存", fontSize = 14.sp, color = Color.White)
            }
        }

    }

}


@Composable
fun TextInputComp(text: String, value: String, callback: (text: String)->Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier.width(100.dp),
            text = text)
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Color(0xFF06CBE4),
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1FFFEA).copy(alpha = 0.4f))
                .padding(horizontal = 20.dp, vertical = 15.dp)
            ,
            value = value,
            onValueChange = {
                callback(it)
            },
            cursorBrush = SolidColor(Color.White),
            singleLine = true,
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight(500)
            )
        )
    }
}

