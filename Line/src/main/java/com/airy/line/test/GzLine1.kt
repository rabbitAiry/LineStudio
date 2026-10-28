package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line1 = Line(
    id = "1",
    name = "1号线",
    name2 = "Line 1",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16")),
        Route(stationList = listOf("16", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "01")),
        Route(stationList = listOf("01", "02", "03", "04", "05", "16"), expressOf = 0)
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "西塱", name2 = "Xilang", interchanges = listOf("10", "22", "GF")),
        "02" to Station(id = "02", name = "坑口", name2 = "Kengkou"),
        "03" to Station(id = "03", name = "花地湾", name2 = "Huadiwan"),
        "04" to Station(id = "04", name = "芳村", name2 = "Fangcun", interchanges = listOf("11", "22")),
        "05" to Station(id = "05", name = "黄沙", name2 = "Huangsha", interchanges = listOf("6")),
        "06" to Station(id = "06", name = "长寿路", name2 = "Changshou Lu"),
        "07" to Station(id = "07", name = "陈家祠", name2 = "Chan Clan Academy", interchanges = listOf("8")),
        "08" to Station(id = "08", name = "西门口", name2 = "Ximenkou"),
        "09" to Station(id = "09", name = "公园前", name2 = "Gongyuanqian", interchanges = listOf("2")),
        "10" to Station(id = "10", name = "农讲所", name2 = "Peasant Movement Institute"),
        "11" to Station(id = "11", name = "烈士陵园", name2 = "Martyrs'Park"),
        "12" to Station(id = "12", name = "东山口", name2 = "Dongshankou", interchanges = listOf("6")),
        "13" to Station(id = "13", name = "杨箕", name2 = "Yangji", interchanges = listOf("5")),
        "14" to Station(id = "14", name = "体育西路", name2 = "Tiyu Xilu", interchanges = listOf("3")),
        "15" to Station(id = "15", name = "体育中心", name2 = "Tianhe Sports Center"),
        "16" to Station(id = "16", name = "广州东站", name2 = "Guangzhou East Railway Station", interchanges = listOf("3", "11"))
    ),
    colorValue = 0xFFF3D03E
)