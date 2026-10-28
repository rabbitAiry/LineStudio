package com.airy.linestudio.presentation.display.style.gzmtr.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.*

private const val start_rate = 0.4f
private const val corner_rate = 0.12f
private const val text_overlay_rate = 0.8f

fun DrawScope.drawGzMtrLineBox(
    color: Color,
    textLayout: TextLayoutResult,
    textEnLayout: TextLayoutResult,
    width: Float,
    height: Float,
    topLeft: Offset,
) {
    val textStartY = (height - textLayout.size.height * text_overlay_rate - textEnLayout.size.height) * start_rate
    val corner = width * corner_rate

    drawRoundRect(
        color = color,
        topLeft = topLeft,
        size = Size(width, height),
        cornerRadius = CornerRadius(corner, corner)
    )

    drawText(
        textLayoutResult = textLayout,
        topLeft = topLeft + Offset((width - textLayout.size.width) / 2, textStartY)
    )

    drawText(
        textLayoutResult = textEnLayout,
        topLeft = topLeft + Offset(
            (width - textEnLayout.size.width) / 2,
            textStartY + textLayout.size.height * text_overlay_rate
        )
    )
}