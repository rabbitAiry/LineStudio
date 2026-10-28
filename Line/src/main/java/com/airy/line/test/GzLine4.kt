package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line4 = Line(
    id = "4",
    name = "4号线",
    name2 = "Line 4",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "南沙客运港", name2 = "Nansha Passenger Port"),
        "02" to Station(id = "02", name = "南横", name2 = "Nanheng"),
        "03" to Station(id = "03", name = "塘坑", name2 = "Tangkeng"),
        "04" to Station(id = "04", name = "大涌", name2 = "Dachong"),
        "05" to Station(id = "05", name = "广隆", name2 = "Guanglong"),
        "06" to Station(id = "06", name = "飞沙角", name2 = "Feishajiao"),
        "07" to Station(id = "07", name = "金洲", name2 = "Jinzhou"),
        "08" to Station(id = "08", name = "蕉门", name2 = "Jiaomen"),
        "09" to Station(id = "09", name = "黄阁", name2 = "Huangge"),
        "10" to Station(id = "10", name = "黄阁汽车城", name2 = "Huangge Auto Town"),
        "11" to Station(id = "11", name = "庆盛", name2 = "Qingsheng"),
        "12" to Station(id = "12", name = "东涌", name2 = "Dongchong"),
        "13" to Station(id = "13", name = "低涌", name2 = "Dichong"),
        "14" to Station(id = "14", name = "海傍", name2 = "Haibang", interchanges = listOf("3")),
        "15" to Station(id = "15", name = "石碁", name2 = "Shi1i"),
        "16" to Station(id = "16", name = "官桥", name2 = "Guanqiao", enable = false),
        "17" to Station(id = "17", name = "新造", name2 = "Xinzao"),
        "18" to Station(id = "18", name = "大学城南", name2 = "Higher Education Mega Center S.", interchanges = listOf("7", "12")),
        "19" to Station(id = "19", name = "大学城北", name2 = "Higher Education Mega Center N.", interchanges = listOf("12")),
        "20" to Station(id = "20", name = "官洲", name2 = "Guanzhou", interchanges = listOf("12")),
        "21" to Station(id = "21", name = "万胜围", name2 = "Wanshengwei", interchanges = listOf("8"), exitInterchanges = listOf("万胜围" to "THZ1")),
        "22" to Station(id = "22", name = "车陂南", name2 = "Chebeinan", interchanges = listOf("5")),
        "23" to Station(id = "23", name = "车陂", name2 = "Chebei", interchanges = listOf("13")),
        "24" to Station(id = "24", name = "黄村", name2 = "Huangcun", interchanges = listOf("21"))
    ),
    colorValue = 0xFF00843D
)