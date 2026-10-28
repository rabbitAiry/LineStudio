package com.airy.line.util

import kotlinx.serialization.json.Json

val jsonTool = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
    encodeDefaults = true
    allowStructuredMapKeys = true
    coerceInputValues = true
    useAlternativeNames = true
    prettyPrint = true
}

inline fun <reified T> decodeFromJsonString(msg: String) = jsonTool.decodeFromString<T>(msg)

inline fun <reified T> encodeToJsonString(data: T) = jsonTool.encodeToString(data)

inline fun <reified T> encodeToJsonBytes(data: T) = encodeToJsonString(data).toByteArray()