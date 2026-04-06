package com.example.myapplication

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.blockstack.myapplication.TetrisViewModel
import kotlinx.coroutines.delay

enum class AppScreens(@StringRes val title: Int) {
    Home(title = R.string.home),
    Game(title = R.string.game),
    Settings(title = R.string.settings)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                stringResource(id = currentScreen.title)
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    tetrisViewModel: TetrisViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.Home.name
    )

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = currentScreen != AppScreens.Home,
                navigateUp = {
                    if (currentScreen != AppScreens.Home) {
                        navController.navigate(AppScreens.Home.name)
                    }
                }
            )
        }
    ) {
        val tetrisUiState by tetrisViewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = AppScreens.Home.name,
            modifier = Modifier.padding(it)
        ) {
            composable(
                route = AppScreens.Home.name
            ) {
                HomePage(
                    onClickGame = {
                        navController.navigate(AppScreens.Game.name)
                        tetrisViewModel.resetGame()
                    },
                    onClickSettings = {
                        navController.navigate(AppScreens.Settings.name)
                    }
                )
            }
            composable(
                route = AppScreens.Game.name
            ) {

                LaunchedEffect(key1 = tetrisUiState.currentPieceItems) {
                    tetrisViewModel.dropPiece()
                    delay(tetrisUiState.speed.toLong())
                }

                Game(
                    currentCells = tetrisUiState.currentPieceItems,
                    rowsCleared = tetrisUiState.rowsCleared,
                    score = tetrisUiState.score,
                    shiftLeft = {
                        tetrisViewModel.shiftLeft()
                    },
                    shiftRight = {
                        tetrisViewModel.shiftRight()
                    },
                    rotateLeft = {
                        tetrisViewModel.rotateLeft()
                    },
                    rotateRight = {
                        tetrisViewModel.rotateRight()
                    },
                    colorCells = tetrisUiState.colorCells[0]!!,
                    colorCells2 = tetrisUiState.colorCells[1]!!,
                    colorCells3 = tetrisUiState.colorCells[2]!!,
                    colorCells4 = tetrisUiState.colorCells[3]!!,
                    colorCells5 = tetrisUiState.colorCells[4]!!,
                    colorCells6 = tetrisUiState.colorCells[5]!!,
                    colorCells7 = tetrisUiState.colorCells[6]!!,
                    currentPiece = tetrisUiState.currentPiece,
                    allPieces = tetrisUiState.allPieces,
                    gameOver = tetrisUiState.gameOver,
                    onDismissRequest = {},
                    onConfirmation = {
                        navController.navigate(
                            AppScreens.Home.name
                        )
                    },
                    playAgain = {
                        navController.navigate(
                            AppScreens.Game.name
                        )
                        tetrisViewModel.resetGame()
                    },
                    dropDown = {
                       tetrisViewModel.dropDownOnce()
                    },
                    toggleSpeed = {
                        tetrisViewModel.dropDownCompletely()
                    },
                    numberOfIterations = tetrisUiState.numberOfIterations,
                    currentSpeed = tetrisUiState.speed
                )
            }
            composable(
                route = AppScreens.Settings.name
            ) {

                val sliderPosition = remember {
                    mutableStateListOf(tetrisUiState.speed)
                }

                val updateSpeed: (Float) -> Unit = remember(sliderPosition) {
                    {
                        sliderPosition[0] = it
                        tetrisUiState.speed = it
                    }
                }

                Settings(
                    sliderPosition = sliderPosition,
                    updateSpeed = updateSpeed,
                    onClickSave = {
                        navController.navigate(AppScreens.Home.name)
                    }
                )
            }
        }
    }
}

