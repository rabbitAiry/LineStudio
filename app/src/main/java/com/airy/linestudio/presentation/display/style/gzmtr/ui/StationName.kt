package com.airy.linestudio.presentation.display.style.gzmtr.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText

private const val text_overlay_rate = 0.8f

fun DrawScope.drawGzMtrStationName(
    textLayout: TextLayoutResult,
    textLayoutEn: TextLayoutResult,
    isUpside: Boolean,
    indicatorLeftTop: Offset,
    indicatorLeftBottom: Offset
) {
    val textSize = textLayout.size
    val textEnSize = textLayoutEn.size

    if (isUpside) {
        drawText(
            textLayoutResult = textLayout,
            topLeft = indicatorLeftTop + Offset(
                -textSize.width / 2f,
                -textEnSize.height - textSize.height * text_overlay_rate
            )
        )
        drawText(
            textLayoutResult = textLayoutEn,
            topLeft = indicatorLeftTop + Offset(-textEnSize.width / 2f, -textEnSize.height.toFloat())
        )
    } else {
        drawText(
            textLayoutResult = textLayout,
            topLeft = indicatorLeftBottom + Offset(-textSize.width / 2f, 0f)
        )
        drawText(
            textLayoutResult = textLayoutEn,
            topLeft = indicatorLeftBottom + Offset(-textEnSize.width / 2f, textSize.height * text_overlay_rate)
        )
    }
}