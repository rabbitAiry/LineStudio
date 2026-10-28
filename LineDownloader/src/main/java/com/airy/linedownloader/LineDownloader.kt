package com.airy.linedownloader

import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Location
import com.airy.line.Route
import com.airy.line.Station
import com.airy.linedownloader.connection.getSearchKeywordResult
import com.airy.linedownloader.connection.AmapKeywordLineResult
import com.airy.linedownloader.connection.AmapSearchKeywordResult
import com.airy.linedownloader.data.LineMapTemplate
import com.airy.linedownloader.data.LineTemplate
import com.airy.linedownloader.connection.defaultColor
import com.airy.line.util.decodeFromJsonString
import com.airy.line.util.encodeToJsonString
import com.airy.linedownloader.util.toColorLongValue
import com.airy.linedownloader.util.toPinyin
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.io.File

private suspend fun downloadCityMap(template: LineMapTemplate) {
    try {
        val lines = template.lineMap.map { lineTemplate ->
            val busLines = getSearchKeywordResult(template.cityName, lineTemplate.name).buslines.filter { it.status == "1" }
            delay(1000L) // 防止因发送频繁被高德限制
            busLines.toLine(lineTemplate)
        }.associateBy { it.id }
        println("Download Finish")

        val file = File("${template.cityName}.txt")
        file.writeText(encodeToJsonString(LineMap(template.cityName, lines)))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private suspend fun downloadLine(cityName:String, lineTemplate: LineTemplate) {
    try {
        val busLines = getSearchKeywordResult(cityName, lineTemplate.name).buslines
        val line = busLines.toLine(lineTemplate)
        println("Download Finish")
        println(line)

        val file = File("${cityName}-${lineTemplate.name}.txt")
        file.writeText(encodeToJsonString(line))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun List<AmapKeywordLineResult>.toLine(lineTemplate: LineTemplate): Line {
    var currId = 0
    val filteredData = this.filter { it.type == "地铁" && it.name.contains(lineTemplate.name) && !it.name.contains("接驳") }
    val stationMap = filteredData.flatMap { line -> line.busstops }
        .map { it ->
            val (lat, lon) = it.location.split(",").map { it.toDouble() }
            currId++
            Station(
                id = "(Line-${lineTemplate.id}-$currId)",
                name = it.name,
                name2 = it.name.toPinyin(),
                location = Location(lat, lon)
            )
        }
        .associateBy { it.name }
    return Line(
        id = lineTemplate.id,
        name = lineTemplate.name,
        routeList = filteredData.map {
            Route(stationList = it.busstops.map { station -> stationMap[station.name]?.id ?: "-1" })
        },
        stationMap = stationMap,
        colorValue = filteredData.firstOrNull()?.uicolor?.toColorLongValue() ?: defaultColor.toColorLongValue()
    )
}

private fun LineMap.writeToFile(name: String){
    val file = File("$name.txt")
    file.writeText(encodeToJsonString(this))
}

fun main() = runBlocking {
    println("Start To Download")
//    downloadCityMap(guangzhouTemplate)
//    test()
    downloadLine("广州", LineTemplate("APM", "APM线"))
    downloadLine("广州", LineTemplate("GF", "广佛线"))
}

private fun test(){
    val file = File("test.txt")
    val raw = file.readText()
    val data = decodeFromJsonString<AmapSearchKeywordResult>(raw)
    LineMap("test", mapOf("F3" to data.buslines.toLine(LineTemplate("F3", "3号线"))))
        .writeToFile("test_output")
}