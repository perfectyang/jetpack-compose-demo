package com.perfectyang.helo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
//    device = Devices.NEXUS_10
    showSystemUi = true
)
@Composable
fun ModifierDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .alpha(0.8f)
//            .clickable {
//
//            }
//            .verticalScroll(rememberScrollState())
//            .horizontalScroll(rememberScrollState())
            .border(2.dp, Color.Yellow)
//            .padding(20.dp)
//            .border(10.dp, Color.Green)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {}) {
            Text("bnt 1")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(onClick = {}) {
            Text("bnt 2")
        }
    }
}