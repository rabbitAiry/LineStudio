package com.airy.linestudio.presentation.display.utils

import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

fun getMaxTextSize(textMeasurer: TextMeasurer, width: Int, text: String="00"): Int {
    var max = width
    var min = 1
    while (max >= min) {
        val curr = (max + min + 1) / 2
        val textWidth = textMeasurer.measure(text, TextStyle(fontSize = curr.sp)).size.width
        if (textWidth > width) {
            max = curr - 1
        } else {
            min = curr + 1
        }
    }
    return min
}