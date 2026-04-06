package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.text.FieldPosition

data class TetrisUiState(
    val currentPiece: Pieces = Pieces.O,
    val score: Int = 0,
    val currentPieceItems: SnapshotStateList<Int> = mutableStateListOf(),
    val allPieces: SnapshotStateList<Int> = mutableStateListOf(),
    val gameOver: Boolean = false,
    val generatorList: MutableMap<Int, Boolean> = mutableMapOf(0 to false,
        1 to false, 2 to false, 3 to false, 4 to false, 5 to false, 6 to false),
    val rowsCleared: Int = 0,
    val colorCells: MutableMap<Int, SnapshotStateList<Int>?> = mutableMapOf(0 to mutableStateListOf(),
        1 to mutableStateListOf(), 2 to mutableStateListOf(), 3 to mutableStateListOf(),
        4 to mutableStateListOf(), 5 to mutableStateListOf(), 6 to mutableStateListOf()),
    val canContinue: Boolean = true,
    var speed: Float = 500F,
    var numberOfIterations: Int = 0
)

