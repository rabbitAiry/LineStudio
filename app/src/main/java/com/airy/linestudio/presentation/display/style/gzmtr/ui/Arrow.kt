package com.airy.linestudio.presentation.display.style.gzmtr.ui

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate

fun DrawScope.drawArrow(
    topLeft: Offset,
    degree: Float,
    width: Float,
    height: Float
){
    val rectW = width * 0.6f
    val triaW = width * 0.4f

    rotate(degree, topLeft + Offset(width/2, height/2)){
        drawPath(
            path = Path().apply {
                moveTo(topLeft.x, topLeft.y + height*0.3f)
                lineTo(topLeft.x + rectW, topLeft.y + height*0.3f)
                lineTo(topLeft.x + rectW, topLeft.y + height*0.1f)
                lineTo(topLeft.x + rectW + triaW, topLeft.y + height/2)
                lineTo(topLeft.x + rectW, topLeft.y + height*0.9f)
                lineTo(topLeft.x + rectW, topLeft.y + height*0.7f)
                lineTo(topLeft.x, topLeft.y + height*0.7f)
                lineTo(topLeft.x, topLeft.y + height*0.3f)
            },
            color = Color.White
        )
    }
}