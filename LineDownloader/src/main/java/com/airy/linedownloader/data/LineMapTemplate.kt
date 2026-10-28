package com.airy.linedownloader.data

/**
 * 仅作为下载模板
 */
data class LineMapTemplate(
    val cityName: String,
    val lineMap: List<LineTemplate>,
)

data class LineTemplate(
    val id: String,
    val name: String
)