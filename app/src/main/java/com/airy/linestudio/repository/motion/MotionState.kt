package com.airy.linestudio.repository.motion

import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.linestudio.repository.data.PidsStyle

/**
 * @param stationId 该站到达/出发
 */
data class MotionState(
    val style: PidsStyle = PidsStyle.entries[0],
    val lineMap: LineMap? = null,
    val line: Line? = null,
    val routeId: Int = 0,
    val stationId: Int = 0,
    val inStop: Boolean = true,
){
    val isLast get() = line?.routeList?.getOrNull(routeId)?.stationList?.size?.let { it - 1 == stationId } ?: true
}
