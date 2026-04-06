package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Game(
    shiftLeft: () -> Unit,
    shiftRight: () -> Unit,
    rotateLeft: () -> Unit,
    rotateRight: () -> Unit,
    toggleSpeed: () -> Unit,
    dropDown: () -> Unit,
    currentCells: SnapshotStateList<Int>,
    currentPiece: Pieces,
    allPieces: SnapshotStateList<Int>,
    rowsCleared: Int,
    score: Int,
    currentSpeed: Float,
    colorCells: SnapshotStateList<Int>,
    colorCells2: SnapshotStateList<Int>,
    colorCells3: SnapshotStateList<Int>,
    colorCells4: SnapshotStateList<Int>,
    colorCells5: SnapshotStateList<Int>,
    colorCells6: SnapshotStateList<Int>,
    colorCells7: SnapshotStateList<Int>,
    gameOver: Boolean,
    numberOfIterations: Int,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    playAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition1 = rememberInfiniteTransition()
    val colors1 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent)
    val color1 by infiniteTransition1.animateColor(
        initialValue = colors1[0],
        targetValue = colors1[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors1[1] at 3000
                colors1[2] at 6000
                colors1[3] at 9000
                colors1[4] at 12000
                colors1[5] at 15000
                colors1[6] at 18000
            }
        )
    )
    val colors2 = listOf(Color.Blue, Color.Yellow, Color.Transparent, Color.Red, Color.Transparent, Color.Transparent, Color.Transparent)
    val color2 by infiniteTransition1.animateColor(
        initialValue = colors2[0],
        targetValue = colors2[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors2[1] at 3000
                colors2[2] at 6000
                colors2[3] at 9000
                colors2[4] at 12000
                colors2[5] at 15000
                colors2[6] at 18000
            }
        )
    )
    val colors3 = listOf(Color.Transparent, Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.Transparent)
    val color3 by infiniteTransition1.animateColor(
        initialValue = colors3[0],
        targetValue = colors3[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors3[1] at 3000
                colors3[2] at 6000
                colors3[3] at 9000
                colors3[4] at 12000
                colors3[5] at 15000
                colors3[6] at 18000
            }
        )
    )
    val colors4 = listOf(Color.Transparent, Color.Transparent, Color.Green, Color.Transparent, Color.Transparent, Color.Transparent, Color.hsv(30F, 1F, 1F))
    val color4 by infiniteTransition1.animateColor(
        initialValue = colors4[0],
        targetValue = colors4[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors4[1] at 3000
                colors4[2] at 6000
                colors4[3] at 9000
                colors4[4] at 12000
                colors4[5] at 15000
                colors4[6] at 18000
            }
        )
    )
    val colors5 = listOf(Color.Blue, Color.Yellow, Color.Green, Color.Transparent, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F))
    val color5 by infiniteTransition1.animateColor(
        initialValue = colors5[0],
        targetValue = colors5[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors5[1] at 3000
                colors5[2] at 6000
                colors5[3] at 9000
                colors5[4] at 12000
                colors5[5] at 15000
                colors5[6] at 18000
            }
        )
    )
    val colors6 = listOf(Color.Blue, Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F))
    val color6 by infiniteTransition1.animateColor(
        initialValue = colors6[0],
        targetValue = colors6[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors6[1] at 3000
                colors6[2] at 6000
                colors6[3] at 9000
                colors6[4] at 12000
                colors6[5] at 15000
                colors6[6] at 18000
            }
        )
    )
    val colors7 = listOf(Color.Blue, Color.Transparent, Color.Transparent, Color.Red, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F))
    val color7 by infiniteTransition1.animateColor(
        initialValue = colors7[0],
        targetValue = colors7[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors7[1] at 3000
                colors7[2] at 6000
                colors7[3] at 9000
                colors7[4] at 12000
                colors7[5] at 15000
                colors7[6] at 18000
            }
        )
    )
    val colors8 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent)
    val color8 by infiniteTransition1.animateColor(
        initialValue = colors8[0],
        targetValue = colors8[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors8[1] at 3000
                colors8[2] at 6000
                colors8[3] at 9000
                colors8[4] at 12000
                colors8[5] at 15000
                colors8[6] at 18000
            }
        )
    )
    val colors9 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent)
    val color9 by infiniteTransition1.animateColor(
        initialValue = colors9[0],
        targetValue = colors9[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors9[1] at 3000
                colors9[2] at 6000
                colors9[3] at 9000
                colors9[4] at 12000
                colors9[5] at 15000
                colors9[6] at 18000
            }
        )
    )
    val colors10 = listOf(Color.Yellow, Color.Transparent, Color.Red, Color.Transparent, Color.Transparent, Color.Transparent, Color.Blue)
    val color10 by infiniteTransition1.animateColor(
        initialValue = colors10[0],
        targetValue = colors10[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors10[1] at 3000
                colors10[2] at 6000
                colors10[3] at 9000
                colors10[4] at 12000
                colors10[5] at 15000
                colors10[6] at 18000
            }
        )
    )
    val colors11 = listOf(Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.Transparent, Color.Transparent)
    val color11 by infiniteTransition1.animateColor(
        initialValue = colors11[0],
        targetValue = colors11[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors11[1] at 3000
                colors11[2] at 6000
                colors11[3] at 9000
                colors11[4] at 12000
                colors11[5] at 15000
                colors11[6] at 18000
            }
        )
    )
    val colors12 = listOf(Color.Transparent, Color.Green, Color.Transparent, Color.Transparent, Color.Transparent, Color.hsv(30F, 1F, 1F), Color.Transparent)
    val color12 by infiniteTransition1.animateColor(
        initialValue = colors12[0],
        targetValue = colors12[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors12[1] at 3000
                colors12[2] at 6000
                colors12[3] at 9000
                colors12[4] at 12000
                colors12[5] at 15000
                colors12[6] at 18000
            }
        )
    )
    val colors13 = listOf(Color.Yellow, Color.Green, Color.Transparent, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue)
    val color13 by infiniteTransition1.animateColor(
        initialValue = colors13[0],
        targetValue = colors13[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors13[1] at 3000
                colors13[2] at 6000
                colors13[3] at 9000
                colors13[4] at 12000
                colors13[5] at 15000
                colors13[6] at 18000
            }
        )
    )
    val colors14 = listOf(Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue)
    val color14 by infiniteTransition1.animateColor(
        initialValue = colors14[0],
        targetValue = colors14[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors14[1] at 3000
                colors14[2] at 6000
                colors14[3] at 9000
                colors14[4] at 12000
                colors14[5] at 15000
                colors14[6] at 18000
            }
        )
    )
    val colors15 = listOf(Color.Transparent, Color.Transparent, Color.Red, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue)
    val color15 by infiniteTransition1.animateColor(
        initialValue = colors15[0],
        targetValue = colors15[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors15[1] at 3000
                colors15[2] at 6000
                colors15[3] at 9000
                colors15[4] at 12000
                colors15[5] at 15000
                colors15[6] at 18000
            }
        )
    )
    val colors16 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent)
    val color16 by infiniteTransition1.animateColor(
        initialValue = colors16[0],
        targetValue = colors16[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors16[1] at 3000
                colors16[2] at 6000
                colors16[3] at 9000
                colors16[4] at 12000
                colors16[5] at 15000
                colors16[6] at 18000
            }
        )
    )
    val colors17 = listOf(Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color17 by infiniteTransition1.animateColor(
        initialValue = colors17[0],
        targetValue = colors17[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors17[1] at 3000
                colors17[2] at 6000
                colors17[3] at 9000
                colors17[4] at 12000
                colors17[5] at 15000
                colors17[6] at 18000
            }
        )
    )
    val colors18 = listOf(Color.Transparent, Color.Red, Color.Transparent, Color.Transparent, Color.Transparent, Color.Blue, Color.Yellow)
    val color18 by infiniteTransition1.animateColor(
        initialValue = colors18[0],
        targetValue = colors18[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors18[1] at 3000
                colors18[2] at 6000
                colors18[3] at 9000
                colors18[4] at 12000
                colors18[5] at 15000
                colors18[6] at 18000
            }
        )
    )
    val colors19 = listOf(Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Yellow)
    val color19 by infiniteTransition1.animateColor(
        initialValue = colors19[0],
        targetValue = colors19[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors19[1] at 3000
                colors19[2] at 6000
                colors19[3] at 9000
                colors19[4] at 12000
                colors19[5] at 15000
                colors19[6] at 18000
            }
        )
    )
    val colors20 = listOf(Color.Green, Color.Transparent, Color.Transparent, Color.Transparent, Color.hsv(30F, 1F, 1F), Color.Transparent, Color.Transparent)
    val color20 by infiniteTransition1.animateColor(
        initialValue = colors20[0],
        targetValue = colors20[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors20[1] at 3000
                colors20[2] at 6000
                colors20[3] at 9000
                colors20[4] at 12000
                colors20[5] at 15000
                colors20[6] at 18000
            }
        )
    )
    val colors21 = listOf(Color.Green, Color.Transparent, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow)
    val color21 by infiniteTransition1.animateColor(
        initialValue = colors21[0],
        targetValue = colors21[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors21[1] at 3000
                colors21[2] at 6000
                colors21[3] at 9000
                colors21[4] at 12000
                colors21[5] at 15000
                colors21[6] at 18000
            }
        )
    )
    val colors22 = listOf(Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow)
    val color22 by infiniteTransition1.animateColor(
        initialValue = colors22[0],
        targetValue = colors22[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors22[1] at 3000
                colors22[2] at 6000
                colors22[3] at 9000
                colors22[4] at 12000
                colors22[5] at 15000
                colors22[6] at 18000
            }
        )
    )
    val colors23 = listOf(Color.Transparent, Color.Red, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Transparent)
    val color23 by infiniteTransition1.animateColor(
        initialValue = colors23[0],
        targetValue = colors23[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors23[1] at 3000
                colors23[2] at 6000
                colors23[3] at 9000
                colors23[4] at 12000
                colors23[5] at 15000
                colors23[6] at 18000
            }
        )
    )
    val colors24 = listOf(Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color24 by infiniteTransition1.animateColor(
        initialValue = colors24[0],
        targetValue = colors24[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors24[1] at 3000
                colors24[2] at 6000
                colors24[3] at 9000
                colors24[4] at 12000
                colors24[5] at 15000
                colors24[6] at 18000
            }
        )
    )
    val colors25 = listOf(Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color25 by infiniteTransition1.animateColor(
        initialValue = colors25[0],
        targetValue = colors25[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors25[1] at 3000
                colors25[2] at 6000
                colors25[3] at 9000
                colors25[4] at 12000
                colors25[5] at 15000
                colors25[6] at 18000
            }
        )
    )
    val colors26 = listOf(Color.Red, Color.Transparent, Color.Transparent, Color.Transparent, Color.Blue, Color.Yellow, Color.Transparent)
    val color26 by infiniteTransition1.animateColor(
        initialValue = colors26[0],
        targetValue = colors26[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors26[1] at 3000
                colors26[2] at 6000
                colors26[3] at 9000
                colors26[4] at 12000
                colors26[5] at 15000
                colors26[6] at 18000
            }
        )
    )
    val colors27 = listOf(Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Yellow, Color.Green)
    val color27 by infiniteTransition1.animateColor(
        initialValue = colors27[0],
        targetValue = colors27[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors27[1] at 3000
                colors27[2] at 6000
                colors27[3] at 9000
                colors27[4] at 12000
                colors27[5] at 15000
                colors27[6] at 18000
            }
        )
    )
    val colors28 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.hsv(30F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Green)
    val color28 by infiniteTransition1.animateColor(
        initialValue = colors28[0],
        targetValue = colors28[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors28[1] at 3000
                colors28[2] at 6000
                colors28[3] at 9000
                colors28[4] at 12000
                colors28[5] at 15000
                colors28[6] at 18000
            }
        )
    )
    val colors29 = listOf(Color.Transparent, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green)
    val color29 by infiniteTransition1.animateColor(
        initialValue = colors29[0],
        targetValue = colors29[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors29[1] at 3000
                colors29[2] at 6000
                colors29[3] at 9000
                colors29[4] at 12000
                colors29[5] at 15000
                colors29[6] at 18000
            }
        )
    )
    val colors30 = listOf(Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green)
    val color30 by infiniteTransition1.animateColor(
        initialValue = colors30[0],
        targetValue = colors30[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors30[1] at 3000
                colors30[2] at 6000
                colors30[3] at 9000
                colors30[4] at 12000
                colors30[5] at 15000
                colors30[6] at 18000
            }
        )
    )
    val colors31 = listOf(Color.Red, Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Transparent, Color.Transparent)
    val color31 by infiniteTransition1.animateColor(
        initialValue = colors31[0],
        targetValue = colors31[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors31[1] at 3000
                colors31[2] at 6000
                colors31[3] at 9000
                colors31[4] at 12000
                colors31[5] at 15000
                colors31[6] at 18000
            }
        )
    )
    val colors32 = listOf(Color.Transparent, Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color32 by infiniteTransition1.animateColor(
        initialValue = colors32[0],
        targetValue = colors32[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors32[1] at 3000
                colors32[2] at 6000
                colors32[3] at 9000
                colors32[4] at 12000
                colors32[5] at 15000
                colors32[6] at 18000
            }
        )
    )
    val colors33 = listOf(Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color33 by infiniteTransition1.animateColor(
        initialValue = colors33[0],
        targetValue = colors33[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors33[1] at 3000
                colors33[2] at 6000
                colors33[3] at 9000
                colors33[4] at 12000
                colors33[5] at 15000
                colors33[6] at 18000
            }
        )
    )
    val colors34 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Blue, Color.Yellow, Color.Transparent, Color.Red)
    val color34 by infiniteTransition1.animateColor(
        initialValue = colors34[0],
        targetValue = colors34[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors34[1] at 3000
                colors34[2] at 6000
                colors34[3] at 9000
                colors34[4] at 12000
                colors34[5] at 15000
                colors34[6] at 18000
            }
        )
    )
    val colors35 = listOf(Color.Cyan, Color.hsv(300F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Yellow, Color.Green, Color.Red)
    val color35 by infiniteTransition1.animateColor(
        initialValue = colors35[0],
        targetValue = colors35[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors35[1] at 3000
                colors35[2] at 6000
                colors35[3] at 9000
                colors35[4] at 12000
                colors35[5] at 15000
                colors35[6] at 18000
            }
        )
    )
    val colors36 = listOf(Color.Transparent, Color.Transparent, Color.hsv(30F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Green, Color.Transparent)
    val color36 by infiniteTransition1.animateColor(
        initialValue = colors36[0],
        targetValue = colors36[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors36[1] at 3000
                colors36[2] at 6000
                colors36[3] at 9000
                colors36[4] at 12000
                colors36[5] at 15000
                colors36[6] at 18000
            }
        )
    )
    val colors37 = listOf(Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Transparent)
    val color37 by infiniteTransition1.animateColor(
        initialValue = colors37[0],
        targetValue = colors37[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors37[1] at 3000
                colors37[2] at 6000
                colors37[3] at 9000
                colors37[4] at 12000
                colors37[5] at 15000
                colors37[6] at 18000
            }
        )
    )
    val colors38 = listOf(Color.Cyan, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Red)
    val color38 by infiniteTransition1.animateColor(
        initialValue = colors38[0],
        targetValue = colors38[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors38[1] at 3000
                colors38[2] at 6000
                colors38[3] at 9000
                colors38[4] at 12000
                colors38[5] at 15000
                colors38[6] at 18000
            }
        )
    )
    val colors39 = listOf(Color.Transparent, Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Transparent, Color.Transparent, Color.Red)
    val color39 by infiniteTransition1.animateColor(
        initialValue = colors39[0],
        targetValue = colors39[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors39[1] at 3000
                colors39[2] at 6000
                colors39[3] at 9000
                colors39[4] at 12000
                colors39[5] at 15000
                colors39[6] at 18000
            }
        )
    )
    val colors40 = listOf(Color.Cyan, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent)
    val color40 by infiniteTransition1.animateColor(
        initialValue = colors40[0],
        targetValue = colors40[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors40[1] at 3000
                colors40[2] at 6000
                colors40[3] at 9000
                colors40[4] at 12000
                colors40[5] at 15000
                colors40[6] at 18000
            }
        )
    )
    val colors41 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan)
    val color41 by infiniteTransition1.animateColor(
        initialValue = colors41[0],
        targetValue = colors41[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors41[1] at 3000
                colors41[2] at 6000
                colors41[3] at 9000
                colors41[4] at 12000
                colors41[5] at 15000
                colors41[6] at 18000
            }
        )
    )
    val colors42 = listOf(Color.Transparent, Color.Transparent, Color.Blue, Color.Yellow, Color.Transparent, Color.Red, Color.Transparent)
    val color42 by infiniteTransition1.animateColor(
        initialValue = colors42[0],
        targetValue = colors42[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors42[1] at 3000
                colors42[2] at 6000
                colors42[3] at 9000
                colors42[4] at 12000
                colors42[5] at 15000
                colors42[6] at 18000
            }
        )
    )
    val colors43 = listOf(Color.hsv(300F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Yellow, Color.Green, Color.Red, Color.Cyan)
    val color43 by infiniteTransition1.animateColor(
        initialValue = colors43[0],
        targetValue = colors43[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors43[1] at 3000
                colors43[2] at 6000
                colors43[3] at 9000
                colors43[4] at 12000
                colors43[5] at 15000
                colors43[6] at 18000
            }
        )
    )
    val colors44 = listOf(Color.Transparent, Color.hsv(30F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Green, Color.Transparent, Color.Transparent)
    val color44 by infiniteTransition1.animateColor(
        initialValue = colors44[0],
        targetValue = colors44[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors44[1] at 3000
                colors44[2] at 6000
                colors44[3] at 9000
                colors44[4] at 12000
                colors44[5] at 15000
                colors44[6] at 18000
            }
        )
    )
    val colors45 = listOf(Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Transparent, Color.Transparent)
    val color45 by infiniteTransition1.animateColor(
        initialValue = colors45[0],
        targetValue = colors45[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors45[1] at 3000
                colors45[2] at 6000
                colors45[3] at 9000
                colors45[4] at 12000
                colors45[5] at 15000
                colors45[6] at 18000
            }
        )
    )
    val colors46 = listOf(Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Red, Color.Cyan)
    val color46 by infiniteTransition1.animateColor(
        initialValue = colors46[0],
        targetValue = colors46[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors46[1] at 3000
                colors46[2] at 6000
                colors46[3] at 9000
                colors46[4] at 12000
                colors46[5] at 15000
                colors46[6] at 18000
            }
        )
    )
    val colors47 = listOf(Color.hsv(300F, 1F, 1F), Color.hsv(30F, 1F, 1F), Color.Blue, Color.Transparent, Color.Transparent, Color.Red, Color.Transparent)
    val color47 by infiniteTransition1.animateColor(
        initialValue = colors47[0],
        targetValue = colors47[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors47[1] at 3000
                colors47[2] at 6000
                colors47[3] at 9000
                colors47[4] at 12000
                colors47[5] at 15000
                colors47[6] at 18000
            }
        )
    )
    val colors48 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan)
    val color48 by infiniteTransition1.animateColor(
        initialValue = colors48[0],
        targetValue = colors48[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors48[1] at 3000
                colors48[2] at 6000
                colors48[3] at 9000
                colors48[4] at 12000
                colors48[5] at 15000
                colors48[6] at 18000
            }
        )
    )
    val colors49 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent)
    val color49 by infiniteTransition1.animateColor(
        initialValue = colors49[0],
        targetValue = colors49[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors49[1] at 3000
                colors49[2] at 6000
                colors49[3] at 9000
                colors49[4] at 12000
                colors49[5] at 15000
                colors49[6] at 18000
            }
        )
    )
    val colors50 = listOf(Color.Transparent, Color.Blue, Color.Yellow, Color.Transparent, Color.Red, Color.Transparent, Color.Transparent)
    val color50 by infiniteTransition1.animateColor(
        initialValue = colors50[0],
        targetValue = colors50[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors50[1] at 3000
                colors50[2] at 6000
                colors50[3] at 9000
                colors50[4] at 12000
                colors50[5] at 15000
                colors50[6] at 18000
            }
        )
    )
    val colors51 = listOf(Color.Transparent, Color.Transparent, Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F))
    val color51 by infiniteTransition1.animateColor(
        initialValue = colors51[0],
        targetValue = colors51[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors51[1] at 3000
                colors51[2] at 6000
                colors51[3] at 9000
                colors51[4] at 12000
                colors51[5] at 15000
                colors51[6] at 18000
            }
        )
    )
    val colors52 = listOf(Color.hsv(30F, 1F, 1F), Color.Transparent, Color.Transparent, Color.Green, Color.Transparent, Color.Transparent, Color.Transparent)
    val color52 by infiniteTransition1.animateColor(
        initialValue = colors52[0],
        targetValue = colors52[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors52[1] at 3000
                colors52[2] at 6000
                colors52[3] at 9000
                colors52[4] at 12000
                colors52[5] at 15000
                colors52[6] at 18000
            }
        )
    )
    val colors53 = listOf(Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Transparent, Color.Transparent, Color.hsv(300F, 1F, 1F))
    val color53 by infiniteTransition1.animateColor(
        initialValue = colors53[0],
        targetValue = colors53[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors53[1] at 3000
                colors53[2] at 6000
                colors53[3] at 9000
                colors53[4] at 12000
                colors53[5] at 15000
                colors53[6] at 18000
            }
        )
    )
    val colors54 = listOf(Color.hsv(30F, 1F, 1F), Color.Blue, Color.Yellow, Color.Green, Color.Red, Color.Cyan, Color.hsv(300F, 1F, 1F))
    val color54 by infiniteTransition1.animateColor(
        initialValue = colors54[0],
        targetValue = colors54[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors54[1] at 3000
                colors54[2] at 6000
                colors54[3] at 9000
                colors54[4] at 12000
                colors54[5] at 15000
                colors54[6] at 18000
            }
        )
    )
    val colors55 = listOf(Color.hsv(30F, 1F, 1F), Color.Blue, Color.Transparent, Color.Transparent, Color.Red, Color.Transparent, Color.hsv(300F, 1F, 1F))
    val color55 by infiniteTransition1.animateColor(
        initialValue = colors55[0],
        targetValue = colors55[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors55[1] at 3000
                colors55[2] at 6000
                colors55[3] at 9000
                colors55[4] at 12000
                colors55[5] at 15000
                colors55[6] at 18000
            }
        )
    )
    val colors56 = listOf(Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Transparent, Color.Cyan, Color.Transparent)
    val color56 by infiniteTransition1.animateColor(
        initialValue = colors56[0],
        targetValue = colors56[0],
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 21000
                colors56[1] at 3000
                colors56[2] at 6000
                colors56[3] at 9000
                colors56[4] at 12000
                colors56[5] at 15000
                colors56[6] at 18000


            }
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val lineFloats = listOf(
                    0.1, 0.2, 0.3, 0.4, 0.5,
                    0.6, 0.7, 0.8, 0.9
                )
                var iterateNum = 1
                val const = 0.0461883408
                for (item in lineFloats) {
                    drawLine(
                        start = Offset(x = ((item * canvasWidth).toFloat()), y = 0f),
                        end = Offset(x = ((item * canvasWidth).toFloat()), y = canvasHeight),
                        color = Color.Black,
                        strokeWidth = 5F,
                        alpha = 0.2f
                    )
                }
                while (iterateNum * const < 1) {
                    drawLine(
                        start = Offset(x = 0f, y = ((iterateNum * const * canvasHeight).toFloat())),
                        end = Offset(
                            x = canvasWidth,
                            y = ((iterateNum * const * canvasHeight).toFloat())
                        ),
                        color = Color.Black,
                        strokeWidth = 5F,
                        alpha = 0.2f
                    )
                    iterateNum += 1
                }
                drawRect(
                    topLeft = Offset(
                        x = (0 * canvasWidth),
                        y = (0 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth,
                        height = canvasHeight
                    ),
                    color = Color.Black
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (1 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color1
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (2 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color2
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (2 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color3
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (2 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color4
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (3 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color5
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (3 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color6
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (3 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color7
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (4 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color8
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (6 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color9
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (7 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color10
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (7 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color11
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (7 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color12
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (8 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color13
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (8 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color14
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (8 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color15
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (9 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color16
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (11 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color17
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (12 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color18
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (12 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color19
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (12 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color20
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (13 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color21
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (13 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color22
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (13 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color23
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (14 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color24
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (16 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color25
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color26
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color27
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color28
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.1 * canvasWidth).toFloat(),
                        y = (18 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color29
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (18 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color30
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.3 * canvasWidth).toFloat(),
                        y = (18 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color31
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.2 * canvasWidth).toFloat(),
                        y = (19 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color32
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (3 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color33
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (4 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color34
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (4 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color35
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (4 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color36
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (5 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color37
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (5 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color38
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (5 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color39
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (6 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color40
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (9 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color41
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (10 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color42
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (10 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color43
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (10 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color44
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (11 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color45
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (11 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color46
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (11 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color47
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (12 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color48
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (15 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color49
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (16 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color50
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (16 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color51
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (16 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color52
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.6 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color53
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color54
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.8 * canvasWidth).toFloat(),
                        y = (17 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color55
                )
                drawRect(
                    topLeft = Offset(
                        x = (0.7 * canvasWidth).toFloat(),
                        y = (18 * const * canvasHeight).toFloat()
                    ),
                    size = Size(
                        width = canvasWidth / 10,
                        height = (canvasHeight / 21.6504854).toFloat()
                    ),
                    color = color56
                )
            }
    ) {}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Grid(
            colorCells = colorCells,
            colorCells2 = colorCells2,
            colorCells3 = colorCells3,
            colorCells4 = colorCells4,
            colorCells5 = colorCells5,
            colorCells6 = colorCells6,
            colorCells7 = colorCells7,
            currentCells = currentCells,
            rowsCleared = rowsCleared,
            currentPiece = currentPiece,
            score = score,
            allPieces = allPieces,
            currentSpeed = currentSpeed
        )
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer)

        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
        ) {
            Button(
                onClick = rotateLeft,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = modifier.padding(10.dp)
            )
            Button(
                onClick = shiftLeft,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = modifier.padding(10.dp)
            )
            Button(
                onClick = shiftRight,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = modifier.padding(10.dp)
            )
            Button(
                onClick = rotateRight,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .offset(x = 55.dp)
        ) {
            Text(
                text = "Rotate left",
                fontSize = 8.sp
            )
            Spacer(
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = "Shift left",
                fontSize = 8.sp
            )
            Spacer(
                modifier = Modifier.width(44.dp)
            )
            Text(
                text = "Shift right",
                fontSize = 8.sp
            )
            Spacer(
                modifier = Modifier.width(36.dp)
            )
            Text(
                text = "Rotate right",
                fontSize = 8.sp
            )
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
        ) {
            Button(
                onClick = toggleSpeed,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
            Spacer(
                modifier = modifier.padding(10.dp)
            )
            Button(
                onClick = dropDown,
                modifier = Modifier.size(
                    height = 40.dp, width = 60.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .offset(x = 134.dp)
        ) {
            Text(
                text = "Accelerate",
                fontSize = 8.sp
            )
            Spacer(
                modifier = Modifier.width(38.dp)
            )
            Text(
                text = "Drop down",
                fontSize = 8.sp
            )
        }
        /*
        Column(
            modifier = modifier
        ) {
            Button(
                onClick = reset
            ) {
                Text(
                    text = "reset"
                )
            }
            Text(
                text = colorCells.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells2.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells3.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells4.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells5.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells6.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = colorCells7.toList().toString(),
                fontSize = 10.sp
            )
            Text(
                text = allPieces.toList().toString(),
                fontSize = 12.sp
            )
            Text(
                text = currentCells.toList().toString(),
                fontSize = 12.sp
            )
        }
        Column() {
            Text(
                text = gameOver.toString()
            )
            Text(
                text = allPieces.toList().toString()
            )
        }

        Text(
            text = currentCells.toList().toString(),
            fontSize = 12.sp
        )
        Text(
            text = numberOfIterations.toString(),
            fontSize = 12.sp
        )
         */
        if(gameOver) {
            TetrisAlertDialog(
                onDismissRequest = onDismissRequest,
                onConfirmation = onConfirmation,
                playAgain = playAgain,
                score = score
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun GamePreview() {
    MyApplicationTheme {
        Game(
            currentCells = remember {
                mutableStateListOf(64, 65, 74, 84)
            },
            shiftLeft = {},
            shiftRight = {},
            rotateLeft = {},
            rotateRight = {},
            currentPiece = Pieces.O,
            rowsCleared = 0,
            score = 0,
            colorCells = mutableStateListOf(),
            colorCells2 = mutableStateListOf(),
            colorCells3 = mutableStateListOf(),
            colorCells4 = mutableStateListOf(),
            colorCells5 = mutableStateListOf(),
            colorCells6 = mutableStateListOf(),
            colorCells7 = mutableStateListOf(),
            allPieces = mutableStateListOf(),
            gameOver = false,
            onDismissRequest = {},
            onConfirmation = {},
            playAgain = {},
            toggleSpeed = {},
            dropDown = {},
            numberOfIterations = 0,
            currentSpeed = 150F
        )
    }
}