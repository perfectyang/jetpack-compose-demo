package com.perfectyang.helo.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.perfectyang.helo.R
import com.perfectyang.helo.db.entity.Bank
import com.perfectyang.helo.viewModel.BankListViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Preview()
@Composable
fun BankList(modifier: Modifier = Modifier) {
   val bankListViewModel: BankListViewModel = viewModel<BankListViewModel>()

   val bankList by bankListViewModel.bankList.observeAsState()

   var inputText by remember {
        mutableStateOf("")
    }

   Column(
      modifier = modifier
         .fillMaxHeight()
         .padding(8.dp)
   ) {

      Row(
         modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
         horizontalArrangement = Arrangement.SpaceBetween
      ) {
         OutlinedTextField(
            modifier= Modifier
               .weight(1f)
               .padding(0.dp, 0.dp, 10.dp, 0.dp),
            value = inputText,
            onValueChange = {
               inputText = it
            })
         Button(onClick = {
            bankListViewModel.searchBank(inputText)
         }) {
            Text(text = "Search")
         }
      }

      bankList?.let {
         LazyColumn(
            modifier = Modifier.padding(bottom = 20.dp),
            content = {
               itemsIndexed(it){index: Int, item: Bank ->
                  TodoItem(item = item, onDelete = {
                     bankListViewModel.deleteBank(item.id)
                  })
               }
            }
         )
      }?:Text(
         modifier = Modifier.fillMaxSize(),
         textAlign = TextAlign.Center,
         text = "No items yet",
         fontSize = 16.sp
      )
   }


}



@Composable
fun TodoItem(item : Bank,onDelete : ()-> Unit) {
   Row(
      modifier = Modifier
         .fillMaxWidth()
         .padding(8.dp)
         .clip(RoundedCornerShape(16.dp))
         .background(MaterialTheme.colorScheme.primary)
         .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically

   ) {
      SelectionContainer (
         modifier = Modifier.weight(1f)
      ) {
         Column(
            modifier = Modifier.weight(1f)
         ) {
            Row (
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
            ){
               Text(
                  text = if (item.type == "1")  "银行卡" else "信用卡",
                  fontSize = 18.sp,
                  color = Color.Red
               )
               Text(
                  text = SimpleDateFormat("yyyy-dd-mm", Locale.ENGLISH).format(item.createdAt),
                  fontSize = 12.sp,
                  color = Color.DarkGray
               )
            }
            BankItem("银行名称", item.bankName)
            BankItem("银行卡号", item.backNum)
            BankItem("有效期 ", item.validDate)
            BankItem("卡背面三位", item.bankCard)
         }
      }
      IconButton(onClick = onDelete) {
         Icon(
            painter = painterResource(id = R.drawable.baseline_delete_sweep),
            contentDescription = "Delete",
            tint = Color.White
         )
      }
   }
}

@Composable
fun BankItem(name:String, value: String) {
   if (value.isNotEmpty()) {
      Row(
         modifier=Modifier.fillMaxWidth()
      ){
         Text(
            modifier = Modifier.width(100.dp),
            text = name)
         Text(
            modifier = Modifier.weight(1f),
            text = value)
      }
   }
}
