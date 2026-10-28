package com.airy.line.util

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

operator fun Line.get(id: Int): Route = routeList[id]

fun Line.stationOf(stationId: String): Station = stationMap[stationId] ?: throw NullPointerException("stationId$stationId")

fun Line.firstStation(routeId: Int): Station = stationOf(get(routeId).stationList.first())
fun Line.lastStation(routeId: Int): Station = stationOf(get(routeId).stationList.last())

fun Line.checkStationMap(): Boolean {
    val stationList = routeList.flatMap { it.stationList }
    return stationList.all { stationMap.containsKey(it) }
}

fun Line.checkName2Supported(): Boolean {
    return stationMap.values.all { it.name2.isNotEmpty() }
}