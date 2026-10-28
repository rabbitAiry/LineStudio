package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line21 = Line(
    id = "21",
    name = "21号线",
    name2 = "Line 21",
    routeList = listOf(
        Route(stationList = listOf("02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21")),
        Route(stationList = listOf("02", "03", "04", "06", "07", "09", "10", "14", "17", "21"), expressOf = 0)
    ),
    stationMap = mapOf(
        "02" to Station(id = "02", name = "天河公园", name2 = "Tianhe Park", interchanges = listOf("11", "13")),
        "03" to Station(id = "03", name = "棠东", name2 = "Tangdong"),
        "04" to Station(id = "04", name = "黄村", name2 = "Huangcun", interchanges = listOf("4")),
        "05" to Station(id = "05", name = "大观南路", name2 = "Daguannanlu"),
        "06" to Station(id = "06", name = "天河智慧城", name2 = "Tianhe Smart City"),
        "07" to Station(id = "07", name = "神舟路", name2 = "Shenzhoulu"),
        "08" to Station(id = "08", name = "科学城", name2 = "Science City"),
        "09" to Station(id = "09", name = "苏元", name2 = "Suyuan", interchanges = listOf("6")),
        "10" to Station(id = "10", name = "水西", name2 = "Shuixi", interchanges = listOf("7"), exitInterchanges = listOf("水西" to "THP1")),
        "11" to Station(id = "11", name = "长平", name2 = "Changping", exitInterchanges = listOf("长平" to "THP1")),
        "12" to Station(id = "12", name = "金坑", name2 = "Jinkeng"),
        "13" to Station(id = "13", name = "镇龙西", name2 = "Zhenlongxi"),
        "14" to Station(id = "14", name = "镇龙", name2 = "Zhenlong", interchanges = listOf("14")),
        "15" to Station(id = "15", name = "中新", name2 = "Zhongxin"),
        "16" to Station(id = "16", name = "坑贝", name2 = "Kengbei"),
        "17" to Station(id = "17", name = "凤岗", name2 = "Fenggang"),
        "18" to Station(id = "18", name = "朱村", name2 = "Zhucun"),
        "19" to Station(id = "19", name = "山田", name2 = "Shantian"),
        "20" to Station(id = "20", name = "钟岗", name2 = "Zhonggang"),
        "21" to Station(id = "21", name = "增城广场", name2 = "Zengcheng Square")
    ),
    colorValue = 0xFF201747
)
