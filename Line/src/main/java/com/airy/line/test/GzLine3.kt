package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line3 = Line(
    id = "3",
    name = "3号线",
    name2 = "Line 3",
    routeList = listOf(
        Route(stationList = listOf("01-4", "01-3", "01-2", "01-1", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"), branchOf = 1),
        Route(stationList = listOf("01-4", "01-3", "01-2", "01-1", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16"), branchOf = 0)
    ),
    stationMap = mapOf(
        "01-4" to Station(id = "01-4", name = "海傍", name2 = "Haibang", interchanges = listOf("4")),
        "01-3" to Station(id = "01-3", name = "海涌路", name2 = "Haichong Lu"),
        "01-2" to Station(id = "01-2", name = "石碁南", name2 = "Shiqinan"),
        "01-1" to Station(id = "01-1", name = "傍江", name2 = "Bangjiang"),
        "01" to Station(id = "01", name = "番禺广场", name2 = "Panyu Square", interchanges = listOf("18", "22")),
        "02" to Station(id = "02", name = "市桥", name2 = "Shiqiao"),
        "03" to Station(id = "03", name = "汉溪长隆", name2 = "Hanxi Changlong", interchanges = listOf("7"), exitInterchanges = listOf("广州长隆" to "广东城际")),
        "04" to Station(id = "04", name = "大石", name2 = "Dashi", exitInterchanges = listOf("大石东" to "广东城际")),
        "05" to Station(id = "05", name = "厦滘", name2 = "Xiajiao"),
        "06" to Station(id = "06", name = "沥滘", name2 = "Lijiao", interchanges = listOf("GF")),
        "07" to Station(id = "07", name = "大塘", name2 = "Datang", interchanges = listOf("11")),
        "08" to Station(id = "08", name = "客村", name2 = "Kecun", interchanges = listOf("8")),
        "09" to Station(id = "09", name = "广州塔", name2 = "Canton Tower", exitInterchanges = listOf("广州塔" to "APM", "广州塔" to "THZ1")),
        "10" to Station(id = "10", name = "珠江新城", name2 = "Zhujiang New Town", interchanges = listOf("5")),
        "11" to Station(id = "11", name = "体育西路", name2 = "Tiyu Xilu", interchanges = listOf("1")),
        "12" to Station(id = "12", name = "石牌桥", name2 = "Shipaiqiao"),
        "13" to Station(id = "13", name = "岗顶", name2 = "Gangding"),
        "14" to Station(id = "14", name = "华师", name2 = "South China Normal University", interchanges = listOf("11")),
        "15" to Station(id = "15", name = "五山", name2 = "Wushan"),
        "16" to Station(id = "16", name = "天河客运站", name2 = "Tianhe Coach Terminal", interchanges = listOf("6")),
        "17" to Station(id = "17", name = "林和西", name2 = "Linhexi", exitInterchanges = listOf("林和西" to "APM")),
        "18" to Station(id = "18", name = "广州东站", name2 = "Guangzhou East Railway Station", interchanges = listOf("1", "11")),
        "19" to Station(id = "19", name = "燕塘", name2 = "Yantang", interchanges = listOf("6")),
        "20" to Station(id = "20", name = "梅花园", name2 = "Meihuayaun"),
        "21" to Station(id = "21", name = "京溪南方医院", name2 = "Jingxi Nanfang Hospital"),
        "22" to Station(id = "22", name = "同和", name2 = "Tonghe"),
        "23" to Station(id = "23", name = "永泰", name2 = "Yongtai"),
        "24" to Station(id = "24", name = "白云大道北", name2 = "Baiyundadaobei"),
        "25" to Station(id = "25", name = "嘉禾望岗", name2 = "Jiahewanggang", interchanges = listOf("2", "14")),
        "26" to Station(id = "26", name = "龙归", name2 = "Longgui"),
        "27" to Station(id = "27", name = "人和", name2 = "Renhe"),
        "28" to Station(id = "28", name = "高增", name2 = "Gaozeng", interchanges = listOf("9")),
        "29" to Station(id = "29", name = "机场南（1号航站楼）", name2 = "Airport S.(Terminal 1)", exitInterchanges = listOf("白云机场南" to "广东城际")),
        "30" to Station(id = "30", name = "机场北（2号航站楼）", name2 = "Airport N.(Terminal 2)", exitInterchanges = listOf("白云机场北" to "广东城际"))
    ),
    colorValue = 0xFFECA154
)
