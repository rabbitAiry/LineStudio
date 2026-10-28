package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line2 = Line(
    id = "2",
    name = "2号线",
    name2 ="Line 2",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "广州南站", name2 = "Guangzhou South Railway Station", interchanges = listOf("7", "22", "F2"), exitInterchanges = listOf("番禺" to "广东城际")),
        "02" to Station(id = "02", name = "石壁", name2 = "Shibi", interchanges = listOf("7")),
        "03" to Station(id = "03", name = "会江", name2 = "Huijiang"),
        "04" to Station(id = "04", name = "南浦", name2 = "Nanpu"),
        "05" to Station(id = "05", name = "洛溪", name2 = "Luoxi"),
        "06" to Station(id = "06", name = "南洲", name2 = "Nanzhou", interchanges = listOf("GF")),
        "07" to Station(id = "07", name = "东晓南", name2 = "Dongxiao South", interchanges = listOf("10")),
        "08" to Station(id = "08", name = "江泰路", name2 = "Jiangtai Road", interchanges = listOf("11")),
        "09" to Station(id = "09", name = "昌岗", name2 = "Changgang", interchanges = listOf("8")),
        "10" to Station(id = "10", name = "江南西", name2 = "Jiangnanxi"),
        "11" to Station(id = "11", name = "市二宫", name2 = "The 2nd workers' Cultural Palace"),
        "12" to Station(id = "12", name = "海珠广场", name2 = "Haizhu Square", interchanges = listOf("6")),
        "13" to Station(id = "13", name = "公园前", name2 = "Gongyuanqian", interchanges = listOf("1")),
        "14" to Station(id = "14", name = "纪念堂", name2 = "Sun Yat-sen Memorial Hall"),
        "15" to Station(id = "15", name = "越秀公园", name2 = "Yuexiu Park"),
        "16" to Station(id = "16", name = "广州火车站", name2 = "Guangzhou Railway Station", interchanges = listOf("5", "11")),
        "17" to Station(id = "17", name = "三元里", name2 = "Sanyuanli"),
        "18" to Station(id = "18", name = "飞翔公园", name2 = "Feixiang Park"),
        "19" to Station(id = "19", name = "白云公园", name2 = "Baiyun Park"),
        "20" to Station(id = "20", name = "白云文化广场", name2 = "Baiyun Cultural Square", interchanges = listOf("12")),
        "21" to Station(id = "21", name = "萧岗", name2 = "Xiao-gang"),
        "22" to Station(id = "22", name = "江夏", name2 = "Jiangxia"),
        "23" to Station(id = "23", name = "黄边", name2 = "Huangbian"),
        "24" to Station(id = "24", name = "嘉禾望岗", name2 = "Jiahewanggang", interchanges = listOf("3", "14"))
    ),
    colorValue = 0xFF00629B
)