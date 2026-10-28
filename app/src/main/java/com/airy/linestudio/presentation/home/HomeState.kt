package com.airy.linestudio.presentation.home

import com.airy.line.Line
import com.airy.line.LineMap

data class HomeState(
    val lineMapList: List<LineMap> = emptyList(),
    val lineList: List<Line> = emptyList(),
)
