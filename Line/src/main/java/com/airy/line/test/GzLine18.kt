package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line18 = Line(
    id = "18",
    name = "18号线",
    name2 = "Line 18",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08")),
        Route(stationList = listOf("01", "02", "03", "04", "07", "08"), expressOf = 0)
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "万顷沙", name2 = "Wanqingsha"),
        "02" to Station(id = "02", name = "横沥", name2 = "Hengli"),
        "03" to Station(id = "03", name = "番禺广场", name2 = "Panyu Square", interchanges = listOf("3", "22")),
        "04" to Station(id = "04", name = "南村万博", name2 = "Nancun Wanbo", interchanges = listOf("7")),
        "05" to Station(id = "05", name = "沙溪", name2 = "Shaxi"),
        "06" to Station(id = "06", name = "龙潭", name2 = "Longtan", interchanges = listOf("11")),
        "07" to Station(id = "07", name = "磨碟沙", name2 = "Modiesha", interchanges = listOf("8")),
        "08" to Station(id = "08", name = "冼村", name2 = "Xiancun")
    ),
    colorValue = 0xFF0047BA
)
