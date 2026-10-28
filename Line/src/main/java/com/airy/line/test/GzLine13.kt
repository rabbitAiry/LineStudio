package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line13 = Line(
    id = "13",
    name = "13号线",
    name2 = "Line 13",
    routeList = listOf(
        Route(stationList = listOf("20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34"))
    ),
    stationMap = mapOf(
        "20" to Station(id = "20", name = "天河公园", name2 = "Tianhe Park", interchanges = listOf("11", "21")),
        "21" to Station(id = "21", name = "棠下", name2 = "Tangxia"),
        "22" to Station(id = "22", name = "车陂", name2 = "Chebei", interchanges = listOf("4")),
        "23" to Station(id = "23", name = "天河珠村", name2 = "Tianhe Zhucun"),
        "24" to Station(id = "24", name = "鱼珠", name2 = "Yuzhu", interchanges = listOf("5")),
        "25" to Station(id = "25", name = "裕丰围", name2 = "Yufengwei", interchanges = listOf("7")),
        "26" to Station(id = "26", name = "双岗", name2 = "Shuanggang"),
        "27" to Station(id = "27", name = "南海神庙", name2 = "Nanhai God Temple"),
        "28" to Station(id = "28", name = "夏园", name2 = "Xiayuan", interchanges = listOf("5")),
        "29" to Station(id = "29", name = "南岗", name2 = "Nangang"),
        "30" to Station(id = "30", name = "沙村", name2 = "Shacun"),
        "31" to Station(id = "31", name = "白江", name2 = "Baijaing"),
        "32" to Station(id = "32", name = "新塘", name2 = "Xintang"),
        "33" to Station(id = "33", name = "官湖", name2 = "Guanhu"),
        "34" to Station(id = "34", name = "新沙", name2 = "Xinsha")
    ),
    colorValue = 0xFF8E8C13
)