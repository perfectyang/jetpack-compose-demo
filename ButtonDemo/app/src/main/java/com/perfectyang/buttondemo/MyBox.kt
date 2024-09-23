package com.perfectyang.buttondemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
    ) {
    Box(modifier = modifier.background(brush = Brush.linearGradient(
        listOf(Color(0xFF0D4C92), Color(0xFF59C1BD))
    ))) {
        content()
    }
}

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    label: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    readOnly: Boolean = false,
    height: Dp =  42.dp,
    trailingIcon: ImageVector? = null,
    value: String,
    onChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(text = label)
        Spacer(modifier = Modifier.height(10.dp))
        BasicTextField(
            value = value,
            onValueChange = onChange,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            readOnly = readOnly,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .height(height)
                    .background(Color(0xFFEFEEEE)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f).padding(horizontal = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    it.invoke()
                }
                trailingIcon?.let {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = trailingIcon, contentDescription = null, tint = Color(0xFF828282))
                    }
                }
            }
        }
    }
}