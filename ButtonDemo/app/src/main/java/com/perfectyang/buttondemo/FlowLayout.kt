package com.perfectyang.buttondemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



val dataList = listOf(
    "周锦帆383838100码冬季s码（已交费）",
    "邓恩棋383838100码冬季S码（已收费）",
    "林华燊383838100码冬季s码",
    "姚梓琳383838100码33 冬季S码",
    "谢明荞383838100dd码冬季S码",
    "曾灏然110aa码冬季S码",
    "梁家乐1eeee10码冬季m码",
    "蔡思颖eee100码冬季S码",
    "陈羽心110吗冬季M码",
    "杨钰秋100eeefdfd码冬季S码",
    "周锦123123123帆100码冬90223季s码（已交费）",
    "邓恩123123123棋100码冬90223季S码（已收费）",
    "林华123979797912312902233燊100码冬季s码",
    "姚梓123979797912312902233琳100码33 冬季S码",
    "谢明123979797912312902233荞100dd码冬季S码",
    "曾灏123979797912312902233然110aa码冬季S码",
    "梁家123979797912312902233乐1eeee1232320码冬季m码",
    "蔡思123979797912312902233颖eee10023232码冬季S码",
    "陈羽123979797912312902233心110吗冬季23232M码",
    "杨钰1239797979123123秋100eee23232fdfd码冬季S码",
    "周锦1239797979123123帆100码冬季23232s码（已交费）",
    "邓恩1239797979123123棋100码冬季23232S码（已收费）",
    "林华1239797979123123燊100码冬季23232s码",
    "姚梓123123123琳100码3323232 冬季S码",
    "谢明123123123荞100dd码23232冬季S码",
    "曾灏123123123然110aa码23232冬季S码",
    "梁家123123123乐1eeee1232320码冬季m码",
    "蔡思123123123颖eee10023232码冬季S码",
    "陈羽123123123心110吗冬季23232M码",
    "杨钰123123123秋100eee23232fdfd码冬季S码",

    )



@Composable
fun FlowLayout(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp), // 设置列数为 2
        verticalItemSpacing = 10.dp, // 设置垂直间距
        horizontalArrangement = Arrangement.spacedBy(10.dp), // 设置水平间距
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp) // 添加 padding
    ) {
        items(dataList.size) { index ->
            // 你的可组合函数
            TextCard(text = dataList[index])
        }
    }
}


@Composable
fun TextCard(modifier: Modifier = Modifier, text: String) {
   Card (

   ) {
       Text(
           text = "Item ${text}",
           modifier = Modifier.padding(8.dp)
       )
   }
}