package com.airy.linestudio.presentation.display.style.gzmtr.ui

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.*

fun DrawScope.drawGzMtrStationIndicator(
    lineColor: Color,
    lineIdLayout: TextLayoutResult,
    stationIdLayout: TextLayoutResult,
    topLeft: Offset,
    width: Float,
    height: Float,
    strokeWidth: Float,
) {
    val corner = CornerRadius(width/2, width/2)

    drawRoundRect(
        color = Color.White,
        topLeft = topLeft,
        size = Size(width, height),
        cornerRadius = corner
    )
    drawRoundRect(
        color = lineColor,
        topLeft = topLeft,
        size = Size(width, height),
        cornerRadius = corner,
        style = Stroke(width = strokeWidth)
    )
    drawLine(
        color = lineColor,
        start = topLeft + Offset(width / 2, 0f),
        end = topLeft + Offset(width / 2, height),
        strokeWidth = strokeWidth
    )
    drawText(
        textLayoutResult = lineIdLayout,
        topLeft = topLeft + Offset((width / 2 - lineIdLayout.size.width) / 2, (height - lineIdLayout.size.height) / 2),
    )
    drawText(
        textLayoutResult = stationIdLayout,
        topLeft = topLeft + Offset((width * 3 / 2 - stationIdLayout.size.width) / 2, (height - stationIdLayout.size.height) / 2)
    )
}