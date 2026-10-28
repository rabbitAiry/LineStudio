package com.airy.linestudio.repository.linedata

import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.linestudio.source.preference.data.SelectedLineData

data class LineDataState(
    val lineMapList: List<LineMap> = emptyList(),
    val lineList: List<Line> = emptyList(),
    val lastSelected: SelectedLineData = SelectedLineData()
)