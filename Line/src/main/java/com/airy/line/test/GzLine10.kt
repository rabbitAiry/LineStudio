package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line10 = Line(
    id = "10",
    name = "10号线",
    name2 ="Line 10",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "西塱", name2 ="Xilang", interchanges = listOf("1", "22", "GF")),
        "02" to Station(id = "02", name = "花围", name2 ="Huawei"),
        "03" to Station(id = "03", name = "东沙", name2 ="Dongsha"),
        "04" to Station(id = "04", name = "大干围", name2 ="Daganwei"),
        "05" to Station(id = "05", name = "工业大道南", name2 ="Gongye Avenue South"),
        "06" to Station(id = "06", name = "东晓南", name2 ="Dongxiao South", interchanges = listOf("2")),
        "07" to Station(id = "07", name = "五凤", name2 ="Wufeng", interchanges = listOf("11")),
        "08" to Station(id = "08", name = "中大南门", name2 ="Sun Yat-sen University South Gate"),
        "09" to Station(id = "09", name = "滨江东路", name2 ="Binjiang East Road"),
        "10" to Station(id = "10", name = "东湖", name2 ="Donghu", interchanges = listOf("6")),
        "11" to Station(id = "11", name = "五羊邨", name2 ="Wuyangcun", exitInterchanges = listOf("五羊邨" to "5")),
        "12" to Station(id = "12", name = "杨箕东", name2 ="Yangji East")
    ),
    colorValue = 0xFF7D9BC1
)