package com.airy.line

import kotlinx.serialization.Serializable

/**
 * 线网
 *
 * @param name 线网名
 * @param version 使用日期作为线网版本， 如20251228
 * @param lines 此线网下的所有线路
 */
@Serializable
data class LineMap(
    val name: String,
    val version: String = "",
    val lines: Map<String, Line>,
)