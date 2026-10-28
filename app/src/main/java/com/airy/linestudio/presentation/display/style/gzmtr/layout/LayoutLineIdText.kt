package com.airy.linestudio.presentation.display.style.gzmtr.layout

import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

private const val text_rate = 0.6f

fun layoutLineId(id: String, sr: Float, maxWidth: Float, textMeasurer: TextMeasurer) =
    layoutIdText(
        text = id,
        style = TextStyle(fontSize = (sr * text_rate).sp),
        maxWidth = maxWidth.toInt(),
        baseSize = sr * text_rate,
        textMeasurer = textMeasurer
    )