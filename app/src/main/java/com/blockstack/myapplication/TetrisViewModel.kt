package com.blockstack.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.Pieces
import com.example.myapplication.TetrisUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class TetrisViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(TetrisUiState())

    val uiState: StateFlow<TetrisUiState> = _uiState.asStateFlow()

    init {
        resetGame()
    }


    fun resetGame() {
        val firstPieceGenerator = uiState.value.generatorList.keys.random()
        _uiState.value = TetrisUiState(
            score = 0,
            currentPiece = when (firstPieceGenerator) {
                0 -> Pieces.O
                1 -> Pieces.I
                2 -> Pieces.J
                3 -> Pieces.S
                4 -> Pieces.Z
                5 -> Pieces.T
                else -> Pieces.L
            },
            currentPieceItems = when (firstPieceGenerator) {
                0 -> mutableStateListOf(0, 1) //mutableStateListOf(0, 1, 10, 11)
                1 -> mutableStateListOf(0) //mutableStateListOf(0, 10, 20, 30)
                2 -> mutableStateListOf(0, 1, 2) //mutableStateListOf(0, 10, 11, 12)
                3 -> mutableStateListOf(0, 1) //mutableStateListOf(1, 2, 10, 11)
                4 -> mutableStateListOf(1, 2) //mutableStateListOf(0, 1, 11, 12)
                5 -> mutableStateListOf(0, 1, 2) //mutableStateListOf(1, 10, 11, 12)
                else -> mutableStateListOf(0, 1, 2) //mutableStateListOf(2, 10, 11, 12)
            },
            numberOfIterations = 0
        )
        _uiState.value.generatorList[firstPieceGenerator] = true
    }

    suspend fun dropPiece() {
        while(_uiState.value.canContinue) {
            delay(uiState.value.speed.toLong())
            if (!_uiState.value.currentPieceItems.all { it / 10 != 19 }) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    _uiState.value.allPieces.add(_uiState.value.currentPieceItems[item])
                    when (_uiState.value.currentPiece) {
                        Pieces.O -> _uiState.value.colorCells[0]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.I -> _uiState.value.colorCells[1]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.J -> _uiState.value.colorCells[2]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.S -> _uiState.value.colorCells[3]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.Z -> _uiState.value.colorCells[4]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.T -> _uiState.value.colorCells[5]?.add(_uiState.value.currentPieceItems[item])
                        Pieces.L -> _uiState.value.colorCells[6]?.add(_uiState.value.currentPieceItems[item])
                    }
                }
                _uiState.update {
                    it.copy(
                        canContinue = false
                    )
                }
                checkGameEnd()
                getNewPiece()
                clearLine()
            } else if (!_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces }) {
                //THIS LINE DIRECTLY BELOW MAY OR MAY NOT BE NEEDED...
                delay(uiState.value.speed.toLong())
                if (!_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces }) {
                    for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                        _uiState.value.allPieces.add(_uiState.value.currentPieceItems[item])
                        when (_uiState.value.currentPiece) {
                            Pieces.O -> _uiState.value.colorCells[0]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.I -> _uiState.value.colorCells[1]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.J -> _uiState.value.colorCells[2]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.S -> _uiState.value.colorCells[3]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.Z -> _uiState.value.colorCells[4]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.T -> _uiState.value.colorCells[5]?.add(_uiState.value.currentPieceItems[item])
                            Pieces.L -> _uiState.value.colorCells[6]?.add(_uiState.value.currentPieceItems[item])
                        }
                    }
                    _uiState.update {
                        it.copy(
                            canContinue = false
                        )
                    }
                    checkGameEnd()
                    getNewPiece()
                    clearLine()
                } else {
                    for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                        _uiState.value.currentPieceItems[item] += 10
                    }
                    _uiState.update {
                        it.copy(
                            numberOfIterations = _uiState.value.numberOfIterations.plus(1)
                        )
                    }
                    if(_uiState.value.numberOfIterations == 1) {
                        when(_uiState.value.currentPiece) {
                            Pieces.O -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[0] - 10, _uiState.value.currentPieceItems[1] - 10)
                            )
                            Pieces.I -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[0] - 10)
                            )
                            Pieces.J -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[0] - 10)
                            )
                            Pieces.S -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[0] - 9, _uiState.value.currentPieceItems[1] - 9)
                            )
                            Pieces.Z -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[0] - 11, _uiState.value.currentPieceItems[1] - 11)
                            )
                            Pieces.T -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[1] - 10)
                            )
                            Pieces.L -> _uiState.value.currentPieceItems.addAll(
                                0,
                                listOf(_uiState.value.currentPieceItems[2] - 10)
                            )
                        }
                    }
                    if(_uiState.value.numberOfIterations == 2 && _uiState.value.currentPiece == Pieces.I) {
                        _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 10)
                        )
                    }
                    if(_uiState.value.numberOfIterations == 3 && _uiState.value.currentPiece == Pieces.I) {
                        _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 10)
                        )
                    }
                }
            } else {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    _uiState.value.currentPieceItems[item] += 10
                }
                _uiState.update {
                    it.copy(
                        numberOfIterations = _uiState.value.numberOfIterations.plus(1)
                    )
                }
                if(_uiState.value.numberOfIterations == 1) {
                    when(_uiState.value.currentPiece) {
                        Pieces.O -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 10, _uiState.value.currentPieceItems[1] - 10)
                        )
                        Pieces.I -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 10)
                        )
                        Pieces.J -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 10)
                        )
                        Pieces.S -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 9, _uiState.value.currentPieceItems[1] - 9)
                        )
                        Pieces.Z -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[0] - 11, _uiState.value.currentPieceItems[1] - 11)
                        )
                        Pieces.T -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[1] - 10)
                        )
                        Pieces.L -> _uiState.value.currentPieceItems.addAll(
                            0,
                            listOf(_uiState.value.currentPieceItems[2] - 10)
                        )
                    }
                }
                if(_uiState.value.numberOfIterations == 2 && _uiState.value.currentPiece == Pieces.I) {
                    _uiState.value.currentPieceItems.addAll(
                        0,
                        listOf(_uiState.value.currentPieceItems[0] - 10)
                    )
                }
                if(_uiState.value.numberOfIterations == 3 && _uiState.value.currentPiece == Pieces.I) {
                    _uiState.value.currentPieceItems.addAll(
                        0,
                        listOf(_uiState.value.currentPieceItems[0] - 10)
                    )
                }
            }
        }
    }

    fun shiftLeft() {
        if(_uiState.value.currentPieceItems.all { it % 10 != 0 } &&
            //_uiState.value.currentPieceItems.all { it / 10 != 19 } &&
            _uiState.value.currentPieceItems.all { ((it - 1) !in _uiState.value.allPieces)}) {
            for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                _uiState.value.currentPieceItems[item] -= 1
            }
        }
    }

    fun shiftRight() {
        if(_uiState.value.currentPieceItems.all { it % 10 != 9 } &&
            //_uiState.value.currentPieceItems.all { it / 10 != 19 } &&
            _uiState.value.currentPieceItems.all {((it + 1) !in _uiState.value.allPieces)}) {
            for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                _uiState.value.currentPieceItems[item] += 1
            }
        }
    }

    fun rotateLeft() {
        //S
        if (_uiState.value.currentPiece == Pieces.S) {
            if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 10
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {(it % 10 != 0) && (it / 10 != 19 )}) &&
                ((_uiState.value.currentPieceItems[0] + 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 10
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            }
        //L
        } else if (_uiState.value.currentPiece == Pieces.L) {
            if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 10) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] += 10
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) &&
                    (_uiState.value.currentPieceItems.all {it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 2) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 2
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 10) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 2 || item == 3) {
                        _uiState.value.currentPieceItems[item] -= 10
                    }
                }
            } else if ((_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 2) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 9) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 2
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            }
        //J
        } else if (_uiState.value.currentPiece == Pieces.J) {
            if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19) }) &&
                ((_uiState.value.currentPieceItems[0] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 8) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19 })  &&
                ((_uiState.value.currentPieceItems[0] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 2 || item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19) }) &&
                ((_uiState.value.currentPieceItems[0] + 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19 })  &&
                ((_uiState.value.currentPieceItems[0] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 9) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 2 || item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            }
        //Z
        } else if (_uiState.value.currentPiece == Pieces.Z) {
            if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {it / 10 != 19 })  &&
                ((_uiState.value.currentPieceItems[0] - 8) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {(it % 10 != 0) && (it / 10 != 19 )})  &&
                ((_uiState.value.currentPieceItems[0] + 8) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            }
        //I
        } else if (_uiState.value.currentPiece == Pieces.I) {
            if ((_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it % 10 != 0) && (it % 10 != 1) && (it / 10 != 19) })  &&
                ((_uiState.value.currentPieceItems[0] + 18) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 9) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 18
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems.all {it / 10 != 19 })
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 18
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            }
        //T
        } else if (_uiState.value.currentPiece == Pieces.T) {
            if ((_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19 ) })  &&
                (_uiState.value.currentPieceItems[0] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 1 || item == 2) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { it / 10 != 19 }) &&
                (_uiState.value.currentPieceItems[0] !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 1) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[3] !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 1 || item == 2) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { it / 10 != 19 })  &&
                ((_uiState.value.currentPieceItems[0] - 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[3] !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            }
        }
    }



    fun rotateRight() {
        //S
        if (_uiState.value.currentPiece == Pieces.S) {
            if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {it / 10 != 19 })  &&
                ((_uiState.value.currentPieceItems[0] - 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 10
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {(it % 10 != 0) && (it / 10 != 19 )}) &&
                ((_uiState.value.currentPieceItems[0] + 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 10
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            }
        //L
        } else if (_uiState.value.currentPiece == Pieces.L) {
            if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 2) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 9) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 2
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19  }) &&
                ((_uiState.value.currentPieceItems[0] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 10) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 2 || item == 3) {
                        _uiState.value.currentPieceItems[item] += 10
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 2) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 2
                    }
                }
            } else if ((_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19  }) &&
                ((_uiState.value.currentPieceItems[0] - 10) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 10) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] -= 10
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            }
        //J
        } else if (_uiState.value.currentPiece == Pieces.J) {
            if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 9) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 8) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[3] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[3] - 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19)}) &&
                ((_uiState.value.currentPieceItems[0] - 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0 || item == 1) {
                        _uiState.value.currentPieceItems[item] -= 1
                    } else if (item == 2 || item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all { it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 8) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            }
        //Z
        } else if (_uiState.value.currentPiece == Pieces.Z) {
            if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 8) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 8
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) &&
                (_uiState.value.currentPieceItems.all {(it % 10 != 0) && (it / 10 != 19 )}) &&
                ((_uiState.value.currentPieceItems[0] + 8) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 1) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 8
                    } else if (item == 2) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 1
                    }
                }
            }
        //I
        } else if (_uiState.value.currentPiece == Pieces.I) {
            if ((_uiState.value.currentPieceItems[0] + 10 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it % 10 != 0) && (it % 10 != 1) && (it / 10 != 19) }) &&
                ((_uiState.value.currentPieceItems[0] + 18) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 9) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 18
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] += 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[0] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems.all {it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 18) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 9) !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
                ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 18
                    } else if (item == 1) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            }
        //T
        } else if (_uiState.value.currentPiece == Pieces.T) {
            if ((_uiState.value.currentPieceItems[1] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { (it % 10 != 0) && (it / 10 != 19 ) }) &&
                ((_uiState.value.currentPieceItems[0] + 9) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[3] !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] += 9
                    }

                }
            } else if ((_uiState.value.currentPieceItems[1] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[1] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[1] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { it / 10 != 19 }) &&
                ((_uiState.value.currentPieceItems[0] - 9) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] - 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] - 1) !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[3] !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 0) {
                        _uiState.value.currentPieceItems[item] -= 9
                    } else if (item == 1 || item == 2) {
                        _uiState.value.currentPieceItems[item] -= 1
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[2] + 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { (it % 10 != 9) && (it / 10 != 19 ) }) &&
                (_uiState.value.currentPieceItems[0] !in _uiState.value.allPieces) && (_uiState.value.currentPieceItems[1] !in _uiState.value.allPieces) &&
                (_uiState.value.currentPieceItems[2] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] - 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 3) {
                        _uiState.value.currentPieceItems[item] -= 9
                    }
                }
            } else if ((_uiState.value.currentPieceItems[2] - 1 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems[2] + 1 in _uiState.value.currentPieceItems)
                && (_uiState.value.currentPieceItems[2] - 10 in _uiState.value.currentPieceItems) && (_uiState.value.currentPieceItems.all { it / 10 != 19 }) &&
                (_uiState.value.currentPieceItems[0] !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[1] + 1) !in _uiState.value.allPieces) &&
                ((_uiState.value.currentPieceItems[2] + 1) !in _uiState.value.allPieces) && ((_uiState.value.currentPieceItems[3] + 9) !in _uiState.value.allPieces)
            ) {
                for (item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                    if (item == 1 || item == 2) {
                        _uiState.value.currentPieceItems[item] += 1
                    } else if (item == 3) {
                        _uiState.value.currentPieceItems[item] += 9
                    }
                }
            }
        }
    }

    fun getNewPiece() {
        val sizeToUpdate = (0..uiState.value.generatorList.size).toList()
        if(!_uiState.value.gameOver) {
            if (uiState.value.generatorList.values.all { it }) {
                for (item in sizeToUpdate) {
                    _uiState.value.generatorList[item] = false
                }
            }

            val firstPieceGenerator =
                uiState.value.generatorList.filter { (key, value) -> !value }.keys.random()

            _uiState.update {
                it.copy(
                    currentPiece = when (firstPieceGenerator) {
                        0 -> Pieces.O
                        1 -> Pieces.I
                        2 -> Pieces.J
                        3 -> Pieces.S
                        4 -> Pieces.Z
                        5 -> Pieces.T
                        else -> Pieces.L
                    },
                    currentPieceItems = when (firstPieceGenerator) {
                        0 -> mutableStateListOf(0, 1) //mutableStateListOf(0, 1, 10, 11)
                        1 -> mutableStateListOf(0) //mutableStateListOf(0, 10, 20, 30)
                        2 -> mutableStateListOf(0, 1, 2) //mutableStateListOf(0, 10, 11, 12)
                        3 -> mutableStateListOf(0, 1) //mutableStateListOf(1, 2, 10, 11)
                        4 -> mutableStateListOf(1, 2) //mutableStateListOf(0, 1, 11, 12)
                        5 -> mutableStateListOf(0, 1, 2) //mutableStateListOf(1, 10, 11, 12)
                        else -> mutableStateListOf(0, 1, 2) //mutableStateListOf(2, 10, 11, 12)
                    },
                    canContinue = true,
                    numberOfIterations = 0
                )
            }
            _uiState.value.generatorList[firstPieceGenerator] = true
        }
    }

    fun clearLine() {
        val listToCheck: MutableList<Int> = mutableListOf()
        val items = (0 until _uiState.value.allPieces.size).toList()
        val rows = (0 until 20).toList()

        if(!_uiState.value.gameOver) {
            for(item in items) {
                listToCheck.add((_uiState.value.allPieces[item]) / 10)
            }
            for (item in rows) {
                if((listToCheck.count { it == item }) == 10) {
                    val deleteList = (10*item until 10*(item + 1)).toList()
                    for(deleteItem in deleteList) {
                        _uiState.value.allPieces.remove(deleteItem)
                        when(deleteItem) {
                            in _uiState.value.colorCells[0]!! -> _uiState.value.colorCells[0]?.remove(deleteItem)
                            in _uiState.value.colorCells[1]!! -> _uiState.value.colorCells[1]?.remove(deleteItem)
                            in _uiState.value.colorCells[2]!! -> _uiState.value.colorCells[2]?.remove(deleteItem)
                            in _uiState.value.colorCells[3]!! -> _uiState.value.colorCells[3]?.remove(deleteItem)
                            in _uiState.value.colorCells[4]!! -> _uiState.value.colorCells[4]?.remove(deleteItem)
                            in _uiState.value.colorCells[5]!! -> _uiState.value.colorCells[5]?.remove(deleteItem)
                            in _uiState.value.colorCells[6]!! -> _uiState.value.colorCells[6]?.remove(deleteItem)
                        }
                    }
                    val updatedItems = (0 until _uiState.value.allPieces.size).toList()
                    for(dropDownItem in updatedItems) {
                        if(_uiState.value.allPieces[dropDownItem] < 10*item) {
                            when(_uiState.value.allPieces[dropDownItem]) {
                                in _uiState.value.colorCells[0]!! -> _uiState.value.colorCells[0]!![_uiState.value.colorCells[0]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[1]!! -> _uiState.value.colorCells[1]!![_uiState.value.colorCells[1]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[2]!! -> _uiState.value.colorCells[2]!![_uiState.value.colorCells[2]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[3]!! -> _uiState.value.colorCells[3]!![_uiState.value.colorCells[3]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[4]!! -> _uiState.value.colorCells[4]!![_uiState.value.colorCells[4]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[5]!! -> _uiState.value.colorCells[5]!![_uiState.value.colorCells[5]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                                in _uiState.value.colorCells[6]!! -> _uiState.value.colorCells[6]!![_uiState.value.colorCells[6]!!.indexOf(_uiState.value.allPieces[dropDownItem])] += 10
                            }
                            _uiState.value.allPieces[dropDownItem] += 10
                        }
                    }
                    if(_uiState.value.speed > 100) {
                        _uiState.update {
                            it.copy(
                                score = _uiState.value.score.plus(1000),
                                rowsCleared = _uiState.value.rowsCleared.plus(1),
                                speed = _uiState.value.speed.minus(10)
                            )
                        }
                    } else {
                        _uiState.update {
                            it.copy(
                                score = _uiState.value.score.plus(1000),
                                rowsCleared = _uiState.value.rowsCleared.plus(1)
                            )
                        }
                    }
                }
            }
        }
    }

    fun checkGameEnd() {
        if(!_uiState.value.allPieces.all { it / 10 != 0 }) {
            _uiState.update {
                it.copy(
                    gameOver = true
                )
            }
        }
    }

    fun dropDownOnce() {
        if((_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces } &&
                    _uiState.value.currentPieceItems.all { it / 10 != 19 } &&
                    _uiState.value.numberOfIterations > 0 && _uiState.value.currentPiece != Pieces.I) ||
            (_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces } &&
                    _uiState.value.currentPieceItems.all { it / 10 != 19 } &&
                    _uiState.value.numberOfIterations > 2 && _uiState.value.currentPiece == Pieces.I)) {
            for(item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                _uiState.value.currentPieceItems[item] += 10
            }
        }
    }

    fun dropDownCompletely() {
        while((_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces } &&
            _uiState.value.currentPieceItems.all { it / 10 != 19 } &&
            _uiState.value.numberOfIterations > 0 && _uiState.value.currentPiece != Pieces.I) ||
            (_uiState.value.currentPieceItems.all { (it + 10) !in _uiState.value.allPieces } &&
            _uiState.value.currentPieceItems.all { it / 10 != 19 } &&
            _uiState.value.numberOfIterations > 2 && _uiState.value.currentPiece == Pieces.I)) {
            for(item in (0 until _uiState.value.currentPieceItems.size).toList()) {
                _uiState.value.currentPieceItems[item] += 10
            }
        }
    }
}