package com.airy.linestudio.presentation.display.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import kotlin.math.pow

val colorOfToday get()=run{
    val hue = System.currentTimeMillis()/1000/60/60/24 % 360f
    Color(android.graphics.Color.HSVToColor(
        floatArrayOf(hue, 0.7f, 0.99f)
    ))
}

fun Color.grey(): Color{
    val mean = (red + green + blue)/3
    return Color(mean, mean, mean)
}

fun Color.greyWithGamma(gamma: Double): Color{
    val mean = (((red + green + blue) / 3 / 255).toDouble().pow(gamma) * 255).toFloat()
    return Color(mean, mean, mean)
}

fun Color.backgroundColor(): Color{
    return if (luminance() > 0.5) Color.Black else Color.White
}

/**
 * @param rate 亮度， 0f - 1f
 */
fun Color.lighter(rate: Float): Color{
    val hsv = FloatArray(3)
    android.graphics.Color.RGBToHSV((red*255).toInt(), (green*255).toInt(), (blue*255).toInt(), hsv)
    hsv[1] = rate
    hsv[2] = 0.99f
    return Color(android.graphics.Color.HSVToColor(hsv))
}