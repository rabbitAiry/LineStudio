package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_apmLine = Line(
    id = "APM",
    name = "APM线",
    name2 = "APM Line",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "广州塔", name2 = "Canton Tower", exitInterchanges = listOf("林和西" to "3")),
        "02" to Station(id = "02", name = "海心沙", name2 = "Haixinsha"),
        "03" to Station(id = "03", name = "大剧院", name2 = "Guangzhou Opera House"),
        "04" to Station(id = "04", name = "花城大道", name2 = "Huacheng Dadao"),
        "05" to Station(id = "05", name = "妇儿中心", name2 = "Guangzhou Women and Children's Medical Center"),
        "06" to Station(id = "06", name = "黄埔大道", name2 = "Huangpu Dadao"),
        "07" to Station(id = "07", name = "天河南", name2 = "Tianhenan"),
        "08" to Station(id = "08", name = "体育中心南", name2 = "Tianhe Sports Center South"),
        "09" to Station(id = "09", name = "林和西", name2 = "Linhexi", exitInterchanges = listOf("广州塔" to "3", "广州塔" to "THZ1"))
    ),
    colorValue = 0xFF00B5E2
)