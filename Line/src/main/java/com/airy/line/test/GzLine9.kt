package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line9 = Line(
    id = "9",
    name = "9号线",
    name2 ="Line 9",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "飞鹅岭", name2 ="Fei'eling"),
        "02" to Station(id = "02", name = "花都汽车城", name2 ="Huadu Autocity"),
        "03" to Station(id = "03", name = "广州北站", name2 ="Guangzhou North Railway Station", exitInterchanges = listOf("花都" to "广东城际")),
        "04" to Station(id = "04", name = "花城路", name2 ="Huachenglu"),
        "05" to Station(id = "05", name = "花果山公园", name2 ="Huaguoshan Park"),
        "06" to Station(id = "06", name = "花都广场", name2 ="Huadu Square"),
        "07" to Station(id = "07", name = "马鞍山公园", name2 ="Ma'anshan Park"),
        "08" to Station(id = "08", name = "莲塘", name2 ="Liantang"),
        "09" to Station(id = "09", name = "清埗", name2 ="Qingbu"),
        "10" to Station(id = "10", name = "清塘", name2 ="Qingtang"),
        "11" to Station(id = "11", name = "高增", name2 ="Gaozeng", interchanges = listOf("3"))
    ),
    colorValue = 0xFF71CC98
)