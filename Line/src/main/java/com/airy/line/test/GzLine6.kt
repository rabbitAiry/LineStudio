package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line6 = Line(
    id = "6",
    name2 = "Line 6",
    name = "6号线",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "浔峰岗", name2 = "Xunfenggang", interchanges = listOf("12")),
        "02" to Station(id = "02", name = "横沙", name2 = "Hengsha"),
        "03" to Station(id = "03", name = "沙贝", name2 = "Shabei"),
        "04" to Station(id = "04", name = "河沙", name2 = "Hesha"),
        "05" to Station(id = "05", name = "坦尾", name2 = "Tanwei", interchanges = listOf("5")),
        "06" to Station(id = "06", name = "如意坊", name2 = "Ruyifang", interchanges = listOf("11")),
        "07" to Station(id = "07", name = "黄沙", name2 = "Huangsha", interchanges = listOf("1")),
        "08" to Station(id = "08", name = "文化公园", name2 = "Cultural Park", interchanges = listOf("8")),
        "09" to Station(id = "09", name = "一德路", name2 = "Yide Lu"),
        "10" to Station(id = "10", name = "海珠广场", name2 = "Haizhu Square", interchanges = listOf("2")),
        "11" to Station(id = "11", name = "北京路", name2 = "Beijing Lu"),
        "12" to Station(id = "12", name = "团一大广场", name2 = "Tuanyida Square"),
        "13" to Station(id = "13", name = "东湖", name2 = "Donghu", interchanges = listOf("10")),
        "14" to Station(id = "14", name = "东山口", name2 = "Dongshankou", interchanges = listOf("1")),
        "15" to Station(id = "15", name = "区庄", name2 = "Ouzhuang", interchanges = listOf("5")),
        "16" to Station(id = "16", name = "黄花岗", name2 = "Huanghuagang"),
        "17" to Station(id = "17", name = "沙河顶", name2 = "Shaheding"),
        "18" to Station(id = "18", name = "沙河", name2 = "Shahe", interchanges = listOf("11")),
        "19" to Station(id = "19", name = "天平架", name2 = "Tianpingjia"),
        "20" to Station(id = "20", name = "燕塘", name2 = "Yantang", interchanges = listOf("3")),
        "21" to Station(id = "21", name = "天河客运站", name2 = "Tianhe Coach Terminal", interchanges = listOf("3")),
        "22" to Station(id = "22", name = "长湴", name2 = "Changban"),
        "23" to Station(id = "23", name = "植物园", name2 = "Botanical Garden"),
        "24" to Station(id = "24", name = "龙洞", name2 = "Longdong", exitInterchanges = listOf("龙洞" to "广东城际")),
        "25" to Station(id = "25", name = "柯木塱", name2 = "Kemulang"),
        "26" to Station(id = "26", name = "高塘石", name2 = "Gaotangshi"),
        "27" to Station(id = "27", name = "黄陂", name2 = "Huangbei"),
        "28" to Station(id = "28", name = "金峰", name2 = "Jinfeng"),
        "29" to Station(id = "29", name = "暹岗", name2 = "Xiangang"),
        "30" to Station(id = "30", name = "苏元", name2 = "Suyuan", interchanges = listOf("21")),
        "31" to Station(id = "31", name = "萝岗", name2 = "Luogang", interchanges = listOf("7"), exitInterchanges = listOf("萝岗" to "THP1")),
        "32" to Station(id = "32", name = "香雪", name2 = "Xiangxue", exitInterchanges = listOf("香雪" to "THP1", "香雪" to "THP2"))
    ),
    colorValue = 0xFF80225F
)