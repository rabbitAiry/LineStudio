package com.airy.linestudio.presentation.display.style.gzmtr.layout

import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

fun layoutIdText(
    text: String,
    style: TextStyle,
    maxWidth: Int,
    baseSize: Float,
    textMeasurer: TextMeasurer
): TextLayoutResult {
    var textLayout = textMeasurer.measure(text, style)
    var idTextSize = baseSize
    while (textLayout.size.width > maxWidth) {
        idTextSize *= 0.9f
        val newStyle = style.copy(fontSize = idTextSize.sp)
        textLayout = textMeasurer.measure(text, newStyle)
    }
    return textLayout
}