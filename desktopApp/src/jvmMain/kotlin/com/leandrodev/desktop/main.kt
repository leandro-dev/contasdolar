package com.leandrodev.desktop

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication(
    title = "Home",
    state = WindowState(width = 1280.dp, height = 768.dp),
    icon = null,
) {
    MainView()
}

@Composable
fun MainView() {
    MaterialTheme {
        Surface {
            Text("Hello Desktop")
        }
    }
}
