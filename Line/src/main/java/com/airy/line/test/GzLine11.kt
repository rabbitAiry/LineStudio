package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line11 = Line(
    id = "11",
    name = "11号线",
    name2 ="Line 11",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "赤沙", name2 ="Chisha", interchanges = listOf("12")),
        "02" to Station(id = "02", name = "琶洲", name2 ="Pazhou", exitInterchanges = listOf("琶洲" to "8", "琶洲" to "广东城际")),
        "03" to Station(id = "03", name = "员村", name2 ="Yuancun", interchanges = listOf("5")),
        "04" to Station(id = "04", name = "天河公园", name2 ="Tianhe Park", interchanges = listOf("13", "21")),
        "05" to Station(id = "05", name = "华景路", name2 ="Huajing Road"),
        "06" to Station(id = "06", name = "华师", name2 ="South China Normal University", interchanges = listOf("3")),
        "07" to Station(id = "07", name = "龙口西", name2 ="Longkou West"),
        "08" to Station(id = "08", name = "广州东站", name2 ="Guangzhou East Railway Station", interchanges = listOf("1", "3")),
        "09" to Station(id = "09", name = "沙河", name2 ="Shahe", interchanges = listOf("6")),
        "10" to Station(id = "10", name = "云台花园", name2 ="Yuntai Garden"),
        "11" to Station(id = "11", name = "大金钟路", name2 ="Dajinzhong Road"),
        "12" to Station(id = "12", name = "中医药大学", name2 ="Guangzhou University of Chinese Medicine"),
        "13" to Station(id = "13", name = "梓元岗", name2 ="Ziyuangang"),
        "14" to Station(id = "14", name = "广州火车站", name2 ="Guangzhou Railway Station", enable = false, interchanges = listOf("2", "5")),
        "15" to Station(id = "15", name = "流花", name2 ="Liuhua"),
        "16" to Station(id = "16", name = "彩虹桥", name2 ="Caihong Bridge", interchanges = listOf("8")),
        "17" to Station(id = "17", name = "中山八", name2 ="Zhongshanba", interchanges = listOf("5")),
        "18" to Station(id = "18", name = "如意坊", name2 ="Ruyifang", interchanges = listOf("6")),
        "19" to Station(id = "19", name = "石围塘", name2 ="Shiweitang"),
        "20" to Station(id = "20", name = "芳村", name2 ="Fangcun", interchanges = listOf("1", "22")),
        "21" to Station(id = "21", name = "大冲口", name2 ="Dachongkou"),
        "22" to Station(id = "22", name = "沙涌", name2 ="Shachong", interchanges = listOf("GF")),
        "23" to Station(id = "23", name = "鹤洞东", name2 ="Hedong East"),
        "24" to Station(id = "24", name = "棣园", name2 ="Diyuan"),
        "25" to Station(id = "25", name = "燕岗", name2 ="Yangang", interchanges = listOf("GF")),
        "26" to Station(id = "26", name = "江泰路", name2 ="Jiangtai Road", interchanges = listOf("2")),
        "27" to Station(id = "27", name = "五凤", name2 ="Wufeng", interchanges = listOf("10")),
        "28" to Station(id = "28", name = "逸景路", name2 ="Yijing Road"),
        "29" to Station(id = "29", name = "上涌", name2 ="Shangchong"),
        "30" to Station(id = "30", name = "大塘", name2 ="Datang", interchanges = listOf("3")),
        "31" to Station(id = "31", name = "龙潭", name2 ="Longtan", interchanges = listOf("18"))
    ),
    colorValue = 0xFF71CC98
)