package com.airy.linedownloader

import com.airy.line.LineMap
import com.airy.line.util.decodeFromJsonString
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() = runBlocking {
    test()
}

private fun test(){
    val file = File("广州.txt")
    val raw = file.readText()
    val data = decodeFromJsonString<LineMap>(raw)
    println(data.lines.map { it.key }.joinToString(","))
}