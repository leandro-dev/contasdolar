package com.leandrodev.contasdolar.android.ui

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import java.text.NumberFormat
import java.util.*

@Composable
fun MoneyText(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    value: Long,
) {
    val locale = Locale("pt", "BR")
    val format = NumberFormat.getCurrencyInstance(locale)
    format.maximumFractionDigits = 2
    val valueToFormat = value.toBigDecimal().divide(100.toBigDecimal())
    val formattedText = format.format(valueToFormat)
    val color = when {
        value > 0 -> Color.Green
        value == 0L -> MaterialTheme.colors.onSurface
        else -> Color.Red
    }
    Text(
        modifier = modifier,
        style = style,
        text = formattedText,
        color = color,
    )
}
