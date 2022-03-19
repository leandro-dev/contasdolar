package com.leandrodev.contasdolar.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColorPalette = lightColors(
    primary = green600,
    primaryVariant = green600Dark,
    secondary = brown300,
    secondaryVariant = brown300Dark,
    background = blueSky,
    surface = blueSky,
    onPrimary = white,
    onSecondary = black,
)

@Composable
fun HomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // TODO Create a dark theme
    val colors = lightColorPalette

    MaterialTheme(
        colors = colors,
        content = content,
    )
}
