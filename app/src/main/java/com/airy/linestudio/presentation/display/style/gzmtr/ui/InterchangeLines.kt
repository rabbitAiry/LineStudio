package com.airy.linestudio.presentation.display.style.gzmtr.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.airy.linestudio.presentation.display.style.gzmtr.data.InterchangeLayoutInfo

fun DrawScope.drawGzMtrTransferLines(
    interchanges: List<InterchangeLayoutInfo>,
    boxWidth: Float,
    boxHeight: Float,
    boxGap: Float,
    stickWidth: Float,
    stickHeight: Float,
    isHorizontal: Boolean,
    isDownside: Boolean,
    centerX: Float,
    topY: Float,
    bottomY: Float
) {
    val allBoxesWidth = interchanges.size * boxWidth + (interchanges.size - 1) * boxGap
    val allBoxesHeight = interchanges.size * boxHeight + (interchanges.size - 1) * boxGap
    var boxStartX = if (isHorizontal)centerX - allBoxesWidth / 2 else centerX - boxWidth / 2
    var boxStartY = when {
        isDownside -> bottomY + stickHeight
        isHorizontal && !isDownside -> topY - boxHeight - stickHeight
        else -> topY - allBoxesHeight - boxGap * (interchanges.size - 1) - stickHeight
    }
    val allStickWidth = interchanges.size * stickWidth
    var stickStartX = centerX - allStickWidth / 2 + stickWidth / 2
    val stickStartY = if (isDownside) bottomY else topY - stickHeight

    for (line in interchanges) {
        drawGzMtrLineBox(
            line.color,
            line.lineNameLayout,
            line.lineNameEnLayout,
            boxWidth,
            boxHeight,
            Offset(boxStartX, boxStartY)
        )
        drawLine(
            color = line.color,
            start = Offset(stickStartX, stickStartY),
            end = Offset(stickStartX, stickStartY + stickHeight),
            strokeWidth = stickWidth
        )
        if (isHorizontal) boxStartX += boxWidth + boxGap else boxStartY += boxHeight + boxGap
        stickStartX += stickWidth
    }
}