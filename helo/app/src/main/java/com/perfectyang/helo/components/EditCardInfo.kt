package com.perfectyang.helo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.perfectyang.helo.db.entity.Bank
import com.perfectyang.helo.model.BankInfoType
import com.perfectyang.helo.model.BankType
import com.perfectyang.helo.viewModel.BankListViewModel
import java.time.Instant
import java.util.Date
import java.util.stream.Collectors.toList

@Composable
fun EditCardInfo(modifier: Modifier = Modifier, back: () -> Unit) {

    val radioOpts = listOf(BankType("1", "储蓄卡"), BankType("2", "信用卡"))
    val editInfoViewModel: EditCardInfoViewModel = viewModel<EditCardInfoViewModel>()
    val bankListViewModel: BankListViewModel = viewModel<BankListViewModel>()

    val uiState by editInfoViewModel.uiState.collectAsState()
    Column (
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(Color(0xFF03DAC5))
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
                            selected = (opt.type === editInfoViewModel.type),
                            onClick = {
                                editInfoViewModel.type = opt.type
                            },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (opt.type == editInfoViewModel.type),
                        onClick = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                        text =opt.text,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

        TextInputComp(
            text = "银行名称",
            value = uiState.bankName
        ) {
            editInfoViewModel.updateBankName(it)
        }
        TextInputComp(
            text = "银行卡号",
            value = uiState.bankCard
        ) {
            editInfoViewModel.updateCardNum(it)
        }
        if (editInfoViewModel.type === "2") {
            TextInputComp(
                text = "有效期",
                value = uiState.validDate
            ) {
                editInfoViewModel.updateValidDate(it)
            }
            TextInputComp(
                text = "卡背面三位数",
                value = uiState.backNum
            ) {
                editInfoViewModel.updateBackNum(it)
            }
        }


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                back()
            }) {
               Text(text = "取消")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                val bank = Bank(
                    bankCard = uiState.bankCard,
                    backNum = uiState.backNum,
                    bankName = uiState.bankName,
                    validDate = uiState.validDate,
                    type = editInfoViewModel.type,
                    createdAt =  Date.from(Instant.now()),
                )
                bankListViewModel.addBank(bank)
                back()
            }) {
                Text(text = "保存")
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
        OutlinedTextField(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp, end = 10.dp)
                .defaultMinSize(minHeight = 20.dp)
            ,
            value = value,
            onValueChange = {
                callback(it)
            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 18.sp
            )
        )
    }
}