package com.example.myapplication

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TetrisAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    playAgain: () -> Unit,
    score: Int,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        title = {
            Text(
                text = stringResource(id = R.string.game_over)
            )
        },
        text = {
            Text(
                text = "You scored: $score"
            )
        },
        dismissButton = {
            TextButton(
                onClick = playAgain
            ) {
                Text(
                    text = "Play Again"
                )
            }
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = onConfirmation
            ) {
                Text(
                    text = "Return Home"
                )
            }
        }
    )
}