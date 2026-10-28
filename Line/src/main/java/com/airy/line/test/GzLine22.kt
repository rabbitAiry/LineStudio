package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line22 = Line(
    id = "22",
    name = "22号线",
    name2 = "Line 22",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "番禺广场", name2 = "Panyu Square", interchanges = listOf("3", "18")),
        "02" to Station(id = "02", name = "市广路", name2 = "Shiguanglu"),
        "03" to Station(id = "03", name = "广州南站", name2 = "Guangzhou South Railway Station", interchanges = listOf("2", "7", "F2"), exitInterchanges = listOf("番禺" to "广东城际")),
        "04" to Station(id = "04", name = "陈头岗", name2 = "Chentougang"),
        "05" to Station(id = "05", name = "南浦西", name2 = "Nanpu West"),
        "06" to Station(id = "06", name = "南漖", name2 = "Nanjiao"),
        "07" to Station(id = "07", name = "西塱", name2 = "Xilang", interchanges = listOf("1", "10", "GF")),
        "08" to Station(id = "08", name = "芳村", name2 = "Fangcun", interchanges = listOf("1", "11"))
    ),
    colorValue = 0xFFCD5228
)