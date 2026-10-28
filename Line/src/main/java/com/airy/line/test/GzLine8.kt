package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line8 = Line(
    id = "8",
    name = "8号线",
    name2 ="Line 8",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "滘心", name2 ="Jiaoxin"),
        "02" to Station(id = "02", name = "亭岗", name2 ="Tinggang"),
        "03" to Station(id = "03", name = "石井", name2 ="Shijing"),
        "04" to Station(id = "04", name = "小坪", name2 ="Xiaoping"),
        "05" to Station(id = "05", name = "石潭（广州白云站）", name2 ="Shitan", exitInterchanges = listOf("广州白云" to "广东城际")),
        "06" to Station(id = "06", name = "聚龙", name2 ="Julong", interchanges = listOf("12")),
        "07" to Station(id = "07", name = "上步", name2 ="Shangbu"),
        "08" to Station(id = "08", name = "同德", name2 ="Tongde"),
        "09" to Station(id = "09", name = "鹅掌坦", name2 ="Ezhangtan"),
        "10" to Station(id = "10", name = "西村", name2 ="Xicun", interchanges = listOf("5")),
        "11" to Station(id = "11", name = "彩虹桥", name2 ="Caihongqiao", interchanges = listOf("11")),
        "12" to Station(id = "12", name = "陈家祠", name2 ="Chen Clan Academy", interchanges = listOf("1")),
        "13" to Station(id = "13", name = "华林寺", name2 ="Hualinsi Buddhist Temple"),
        "14" to Station(id = "14", name = "文化公园", name2 ="Cultural Park", interchanges = listOf("6")),
        "15" to Station(id = "15", name = "同福西", name2 ="Tongfuxi"),
        "16" to Station(id = "16", name = "凤凰新村", name2 ="Fenghuang Xincun"),
        "17" to Station(id = "17", name = "沙园", name2 ="Shayuan", interchanges = listOf("GF")),
        "18" to Station(id = "18", name = "宝岗大道", name2 ="Baogang Dadao"),
        "19" to Station(id = "19", name = "昌岗", name2 ="Changgang", interchanges = listOf("2")),
        "20" to Station(id = "20", name = "晓港", name2 ="Xiaogang"),
        "21" to Station(id = "21", name = "中大", name2 ="Sun Yat-sen University"),
        "22" to Station(id = "22", name = "鹭江", name2 ="Lujiang"),
        "23" to Station(id = "23", name = "客村", name2 ="Kecun", interchanges = listOf("3")),
        "24" to Station(id = "24", name = "赤岗", name2 ="Chigang", interchanges = listOf("12")),
        "25" to Station(id = "25", name = "磨碟沙", name2 ="Modiesha", interchanges = listOf("18")),
        "26" to Station(id = "26", name = "新港东", name2 ="Xingangdong"),
        "27" to Station(id = "27", name = "琶洲", name2 ="Pazhou", exitInterchanges = listOf("琶洲" to "11", "琶洲" to "广东城际")),
        "28" to Station(id = "28", name = "万胜围", name2 ="Wanshengwei", interchanges = listOf("4"), exitInterchanges = listOf("万胜围" to "THZ1"))
    ),
    colorValue = 0xFF008C95
)