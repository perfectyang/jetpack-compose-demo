package com.perfectyang.buttondemo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text

@Composable
fun GlowingCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GlowingCard(
                    glowingColor = Color.Cyan,
                    modifier = Modifier.size(50.dp),
                    cornersRadius = 10.dp
                ) {}

                GlowingCard(
                    glowingColor = Color.White,
                    modifier = Modifier.size(100.dp),
                    cornersRadius = 10.dp
                ) {}

                GlowingCard(
                    glowingColor = Color.Yellow,
                    modifier = Modifier.size(100.dp),
                    cornersRadius = 10.dp
                ) {}
            }

            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GlowingCard(
                    glowingColor = Color.Cyan,
                    modifier = Modifier.size(100.dp),
                    cornersRadius = Int.MAX_VALUE.dp
                ) {}

                GlowingCard(
                    glowingColor = Color.White,
                    modifier = Modifier.size(100.dp),
                    cornersRadius = Int.MAX_VALUE.dp
                ) {}

                ClickableGlowingCard(
                    glowingColor = Color.Yellow,
                    modifier = Modifier.width(100.dp).height(50.dp),
                    cornersRadius = 20.dp,
                    glowingRadius = 20.dp,
                    onClick = {

                    }
                ) {
                    Text(text = "click", modifier = Modifier.align(Alignment.Center), color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun GlowingCard(
    glowingColor: Color,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    cornersRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val canvasSize = size
                drawContext.canvas.nativeCanvas.apply {
                    drawRoundRect(
                        0f, // Left
                        0f, // Top
                        canvasSize.width, // Right
                        canvasSize.height, // Bottom
                        cornersRadius.toPx(), // Radius X
                        cornersRadius.toPx(), // Radius Y
                        Paint().apply {
                            color = containerColor.toArgb()
                            isAntiAlias = true
                            setShadowLayer(
                                glowingRadius.toPx(),
                                xShifting.toPx(), yShifting.toPx(),
                                glowingColor.copy(alpha = 0.3f).toArgb()
                            )
                        }
                    )
                }
            }
    ) {
        content()
    }
}

@Composable
fun ClickableGlowingCard(
    glowingColor: Color,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    cornersRadius: Dp = 0.dp,
    glowingRadius: Dp = 20.dp,
    xShifting: Dp = 0.dp,
    yShifting: Dp = 0.dp,
    onClick:() -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val canvasSize = size
                drawContext.canvas.nativeCanvas.apply {
                    drawRoundRect(
                        0f, // Left
                        0f, // Top
                        canvasSize.width, // Right
                        canvasSize.height, // Bottom
                        cornersRadius.toPx(), // Radius X
                        cornersRadius.toPx(), // Radius Y
                        Paint().apply {
                            color = containerColor.toArgb()
                            isAntiAlias = true
                            setShadowLayer(
                                glowingRadius.toPx(),
                                xShifting.toPx(), yShifting.toPx(),
                                glowingColor.copy(alpha = 0.85f).toArgb()
                            )
                        }
                    )
                }
            }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(cornersRadius))
            .clickable { onClick() }){
            content()
        }
    }
}