package com.airy.linestudio.presentation.display.style.gzmtr.layout

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.airy.line.Line
import com.airy.linestudio.presentation.display.style.gzmtr.data.InterchangeLayoutInfo
import com.airy.linestudio.repository.utils.color


fun layoutGzMtrLineBox(
    line: Line,
    baseTextSize: Float,
    baseTextEnSize: Float,
    maxWidth: Int,
    textMeasurer: TextMeasurer
): InterchangeLayoutInfo {
    val textColor = if (line.color.luminance() > 0.5f) Color.Black else Color.White
    val textStyle = TextStyle(fontSize = baseTextSize.sp, color = textColor)
    val textStyleEn = TextStyle(fontSize = baseTextEnSize.sp, color = textColor)

    return InterchangeLayoutInfo(
        color = line.color,
        lineNameLayout = layoutIdText(
            text = line.name,
            style = textStyle,
            maxWidth = maxWidth,
            baseSize = baseTextSize,
            textMeasurer = textMeasurer
        ),
        lineNameEnLayout = layoutIdText(
            text = "",  //line.otherNames.getOrElse(0) { "" },
            style = textStyleEn,
            maxWidth = maxWidth,
            baseSize = baseTextEnSize,
            textMeasurer = textMeasurer
        )
    )
}