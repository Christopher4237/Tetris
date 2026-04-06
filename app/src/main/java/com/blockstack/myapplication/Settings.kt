package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Settings(
    sliderPosition: SnapshotStateList<Float>,
    onClickSave: () -> Unit,
    updateSpeed: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = "Starting Speed (ms)"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 40.dp, end = 40.dp
            )
        ) {
            Slider(
                value = sliderPosition[0],
                onValueChange = updateSpeed,
                valueRange = 100f..500f,
                steps = 39,
                modifier = Modifier.weight(0.75f)
            )
            Spacer(
                modifier = Modifier.width(5.dp)
            )
            Text(
                text = sliderPosition[0].toInt().toString()
            )
        }
        Button(
            onClick = onClickSave
        ) {
            Text(
                text = "Save"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    MyApplicationTheme {
        Settings(
            sliderPosition = mutableStateListOf(400F),
            onClickSave = {},
            updateSpeed = {}
        )
    }
}