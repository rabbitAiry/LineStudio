package com.airy.linedownloader

import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Station
import com.airy.line.util.decodeFromJsonString
import com.airy.line.util.encodeToJsonString
import java.io.File

private fun interchangeFinder(filePath: String){
    val file = File(filePath)
    val lineMap = decodeFromJsonString<LineMap>(file.readText())

    val stationList = ArrayList<Pair<Station, String>>()
    lineMap.lines.values.forEach { line ->
        line.stationMap.values.forEach { station ->
            stationList.add(station to line.id)
        }
    }

    println(stationList.size)

    val resultLines = HashMap<String, Line>()
    lineMap.lines.values.forEach { line ->
        val resultStationList = ArrayList<Station>()
        line.stationMap.values.forEach { station ->
            resultStationList.add(
                station.copy(interchanges = stationList.filter { it.first.name == station.name }.map { it.second }.filterNot { it == line.id })
            )
        }
        resultLines[line.id] = line.copy(stationMap = resultStationList.associateBy { it.id })
    }
    val result = lineMap.copy(lines = resultLines.toSortedMap{ s1, s2 ->
        val num1 = s1.toIntOrNull() ?: 10000
        val num2 = s2.toIntOrNull() ?: 10000
        num1.compareTo(num2)
    })
    file.writeText(encodeToJsonString(result))
}

fun main(){
    interchangeFinder("广州.txt")
}