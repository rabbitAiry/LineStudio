package com.airy.linestudio.repository.utils

import androidx.compose.ui.graphics.Color

/**
 * 解析失败时返回白色
 */
fun colorTextToColor(text: String): Color {
    return try {
        val modifiedText = text.trim().removePrefix("#").alphaCheck()
        val data = modifiedText.toLong(16)
        Color(data)
    }catch (e:NumberFormatException){
        Color.Red
    }
}

fun String.alphaCheck() = if (length == 6) "ff$this" else this