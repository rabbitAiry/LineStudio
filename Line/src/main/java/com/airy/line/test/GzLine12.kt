package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line12 = Line(
    id = "12",
    name = "12号线",
    name2 = "Line 12",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09")),
        Route(stationList = listOf("17", "18", "19", "20", "21", "22", "23", "24", "25"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "浔峰岗", name2 = "Xunfenggang", interchanges = listOf("6")),
        "02" to Station(id = "02", name = "浔峰岗北", name2 = "Xunfenggang North"),
        "03" to Station(id = "03", name = "西洲", name2 = "Xizhou"),
        "04" to Station(id = "04", name = "聚龙", name2 = "Julong", interchanges = listOf("8")),
        "05" to Station(id = "05", name = "广州白云站", name2 = "Guangzhou Baiyun Railway Station", exitInterchanges = listOf("广州白云" to "广东城际")),
        "06" to Station(id = "06", name = "棠涌", name2 = "Tangchong"),
        "07" to Station(id = "07", name = "新市墟", name2 = "Xinshixu", interchanges = listOf("14")),
        "08" to Station(id = "08", name = "白云文化广场", name2 = "Baiyun Culture Square", interchanges = listOf("2")),
        "09" to Station(id = "09", name = "广州体育馆", name2 = "Guangzhou Gymnasium"),
        "17" to Station(id = "17", name = "二沙岛", name2 = "Ersha Island"),
        "18" to Station(id = "18", name = "赤岗塔", name2 = "Chigang Pagoda"),
        "19" to Station(id = "19", name = "赤岗", name2 = "Chigang", interchanges = listOf("8")),
        "20" to Station(id = "20", name = "赤沙北", name2 = "Chisha North"),
        "21" to Station(id = "21", name = "赤沙", name2 = "Chisha", interchanges = listOf("11")),
        "22" to Station(id = "22", name = "北山", name2 = "Beishan"),
        "23" to Station(id = "23", name = "官洲", name2 = "Guanzhou", interchanges = listOf("4")),
        "24" to Station(id = "24", name = "大学城北", name2 = "Higher Education Mega Center N.", interchanges = listOf("4")),
        "25" to Station(id = "25", name = "大学城南", name2 = "Higher Education Mega Center S.", interchanges = listOf("4", "7"))
    ),
    colorValue = 0xFF71CC98
)