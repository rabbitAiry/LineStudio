package com.airy.linestudio.repository.utils

import androidx.compose.ui.graphics.Color
import com.airy.line.Line
import com.airy.line.Station
import com.airy.linestudio.repository.motion.MotionState

val Line.color get() = Color(colorValue)
fun Line.currStop(status: MotionState) = getStationList(status)[status.stationId]
fun Line.terminalStop(status: MotionState) = getStationList(status).last()
fun Line.getStationList(status: MotionState) = routeList[status.routeId].stationList.mapNotNull { stationMap[it] }