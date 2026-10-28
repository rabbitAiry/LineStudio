package com.airy.linedownloader.connection

import com.airy.line.util.jsonTool
import com.example.mykey.Key
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

private val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(jsonTool)
    }
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println(message)
            }
        }
        level = LogLevel.ALL
    }
}

suspend fun getSearchKeywordResult(cityName: String, keywords: String): AmapSearchKeywordResult =
    client.get("https://restapi.amap.com/v3/bus/linename") {
        url{
            parameters.apply {
                append("key", Key.AMAP_KEY)
                append("keywords", keywords)
                append("city", cityName)
                append("extensions", "all")
            }
        }
    }.body()