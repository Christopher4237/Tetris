package com.example.myapplication

import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Background() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val drop by infiniteTransition.animateFloat(
        initialValue = -600f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .offset(y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFF6ABCE2))
        )
        Box(
            modifier = Modifier
                .offset(x = -50.dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFFFF7F7F))
        )
        Box(
            modifier = Modifier
                .offset(x = 50.dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFFF1EE8E))
        )
        Box(
            modifier = Modifier
                .offset(x = (-100).dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFFCBC3E3))
                .alpha(0.5f)
        )
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFF83F28F))
        )
        Box(
            modifier = Modifier
                .offset(x = (-150).dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFFFFD580))
                .alpha(0.5f)
        )
        Box(
            modifier = Modifier
                .offset(x = 150.dp, y = drop.dp)
                .rotate(angle)
                .size(30.dp)
                .background(Color(0xFFAFFFFF))
                .alpha(0.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Background()
    }
}