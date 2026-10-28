package com.airy.linestudio.presentation.display.utils

import androidx.compose.ui.graphics.Color
import com.airy.line.Line

fun <T> List<T>.splitToTwoStationList(): Pair<List<T>, List<T>>{
    val half = size/2
    return subList(0, half) to subList(half, size).reversed()
}

/**
 * 为超长的文本选择合适的缩小范围
 */
fun textRate(text: String, rate:Float = 0.8f): Float{
    var textLength = text.length
    var limitRate = 1f
    while(textLength > 3) {
        limitRate *= rate
        textLength -= 2
    }
    return limitRate
}