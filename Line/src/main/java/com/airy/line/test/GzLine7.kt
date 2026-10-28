package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line7 = Line(
    id = "7",
    name = "7号线",
    name2 = "Line 7",
    routeList = listOf(
        Route(stationList = listOf("01-8", "01-7", "01-6", "01-5", "01-4", "01-3", "01-2", "01-1", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"))
    ),
    stationMap = mapOf(
        "01-8" to Station(id = "01-8", name = "美的大道", name2 = "Meidi Dadao"),
        "01-7" to Station(id = "01-7", name = "北滘公园", name2 = "Beijiao Park", interchanges = listOf("F3")),
        "01-6" to Station(id = "01-6", name = "美的", name2 = "Midea"),
        "01-5" to Station(id = "01-5", name = "南涌", name2 = "Nanchong"),
        "01-4" to Station(id = "01-4", name = "锦龙", name2 = "Jinlong"),
        "01-3" to Station(id = "01-3", name = "陈村", name2 = "Chencun", exitInterchanges = listOf("陈村" to "广东城际")),
        "01-2" to Station(id = "01-2", name = "陈村北", name2 = "Chencunbei"),
        "01-1" to Station(id = "01-1", name = "大洲", name2 = "Dazhou"),
        "01" to Station(id = "01", name = "广州南站", name2 = "Guangzhou South Railway Station", interchanges = listOf("2", "22", "F2"), exitInterchanges = listOf("番禺" to "广东城际")),
        "02" to Station(id = "02", name = "石壁", name2 = "Shibi", interchanges = listOf("2")),
        "03" to Station(id = "03", name = "谢村", name2 = "Xiecun"),
        "04" to Station(id = "04", name = "钟村", name2 = "Zhongcun"),
        "05" to Station(id = "05", name = "汉溪长隆", name2 = "Hanxi Changlnog", interchanges = listOf("3"), exitInterchanges = listOf("广州长隆" to "广东城际")),
        "06" to Station(id = "06", name = "南村万博", name2 = "Nancun Wanbo", interchanges = listOf("18")),
        "07" to Station(id = "07", name = "员岗", name2 = "Yuangang"),
        "08" to Station(id = "08", name = "板桥", name2 = "Banqiao"),
        "09" to Station(id = "09", name = "大学城南", name2 = "Higher Education Mega Center S.", interchanges = listOf("4", "12")),
        "10" to Station(id = "10", name = "深井", name2 = "Shenjing", exitInterchanges = listOf("深井" to "广东城际")),
        "11" to Station(id = "11", name = "长洲", name2 = "Changzhou"),
        "12" to Station(id = "12", name = "洪圣沙", name2 = "Hongshengsha"),
        "13" to Station(id = "13", name = "裕丰围", name2 = "Yufengwei", interchanges = listOf("13")),
        "14" to Station(id = "14", name = "大沙东", name2 = "Dashadong", interchanges = listOf("5")),
        "15" to Station(id = "15", name = "姬堂", name2 = "Jitang"),
        "16" to Station(id = "16", name = "加庄", name2 = "Jiazhuang"),
        "17" to Station(id = "17", name = "科丰路", name2 = "Kefeng Lu"),
        "18" to Station(id = "18", name = "萝岗", name2 = "Luogang", interchanges = listOf("6"), exitInterchanges = listOf("萝岗" to "THP1")),
        "19" to Station(id = "19", name = "水西", name2 = "Shuixi", interchanges = listOf("21"), exitInterchanges = listOf("水西" to "THP1")),
        "20" to Station(id = "20", name = "燕山", name2 = "Yanshan")
    ),
    colorValue = 0xFF97D700
)