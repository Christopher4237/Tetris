package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Grid(
    score: Int,
    rowsCleared: Int,
    currentSpeed: Float,
    allPieces: SnapshotStateList<Int>,
    colorCells: SnapshotStateList<Int>,
    colorCells2: SnapshotStateList<Int>,
    colorCells3: SnapshotStateList<Int>,
    colorCells4: SnapshotStateList<Int>,
    colorCells5: SnapshotStateList<Int>,
    colorCells6: SnapshotStateList<Int>,
    colorCells7: SnapshotStateList<Int>,
    currentCells: SnapshotStateList<Int>,
    currentPiece: Pieces,
    modifier: Modifier = Modifier
) {
    val data = (0 until 20*10).toList()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Row() {
            Text(
                text = "Rows cleared: $rowsCleared",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .background(
                        color = Color.Red,
                        shape = RoundedCornerShape(
                            corner = CornerSize(4.dp)
                        )
                    )
                    .padding(
                        start = 12.dp, end = 12.dp,
                        top = 2.dp, bottom = 2.dp
                    )
            )
            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Text(
                text = "Score: $score",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .background(
                        color = Color.Red,
                        shape = RoundedCornerShape(
                            corner = CornerSize(4.dp)
                        )
                    )
                    .padding(
                        start = 12.dp, end = 12.dp,
                        top = 2.dp, bottom = 2.dp
                    )
            )
        }
        Spacer(
            modifier = Modifier.height(5.dp)
        )
        Row() {
            Text(
                text = "Current speed: $currentSpeed ms",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .background(
                        color = Color.Red,
                        shape = RoundedCornerShape(
                            corner = CornerSize(4.dp)
                        )
                    )
                    .padding(
                        start = 12.dp, end = 12.dp,
                        top = 2.dp, bottom = 2.dp
                    )
            )
        }
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(10),
            //verticalArrangement = Arrangement.spacedBy(1.dp),
            //horizontalArrangement = Arrangement.spacedBy(1.dp),
            modifier = Modifier
                .size(
                    259.dp,
                    502.5.dp
                )
        ) {
            items(data) { item ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .border(
                            0.5.dp,
                            color = Color.Black
                        )
                        .size(
                            25.dp, 25.dp
                        )
                        .background(
                            color = when (item) {
                                in currentCells -> when (currentPiece) {
                                    Pieces.O -> Color.Yellow
                                    Pieces.I -> Color.Cyan
                                    Pieces.J -> Color.Blue
                                    Pieces.S -> Color.Green
                                    Pieces.Z -> Color.Red
                                    Pieces.T -> Color.hsv(300F, 1F, 1F)
                                    Pieces.L -> Color.hsv(30F, 1F, 1F)
                                }

                                in allPieces -> when (item) {
                                    in colorCells -> Color.Yellow
                                    in colorCells2 -> Color.Cyan
                                    in colorCells3 -> Color.Blue
                                    in colorCells4 -> Color.Green
                                    in colorCells5 -> Color.Red
                                    in colorCells6 -> Color.hsv(300F, 1F, 1F)
                                    in colorCells7 -> Color.hsv(30F, 1F, 1F)
                                    else -> Color.White
                                }

                                else -> Color.White
                            }
                        )
                ) {
                    /*
                    Text(
                        text = item.toString(),
                        fontSize = 12.sp
                    )
                     */
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GridPreview() {
    MyApplicationTheme {
        Grid(
            score = 0,
            rowsCleared = 0,
            colorCells = remember {
                mutableStateListOf()
            },
            colorCells2 = remember {
                mutableStateListOf()
            },
            colorCells3 = remember {
                mutableStateListOf()
            },
            colorCells4 = remember {
                mutableStateListOf()
            },
            colorCells5 = remember {
                mutableStateListOf()
            },
            colorCells6 = remember {
                mutableStateListOf()
            },
            colorCells7 = remember {
                mutableStateListOf()
            },
            currentCells = remember {
                mutableStateListOf()
            },
            currentPiece = Pieces.O,
            allPieces = remember {
                mutableStateListOf()
            },
            currentSpeed = 150F
        )
    }
}