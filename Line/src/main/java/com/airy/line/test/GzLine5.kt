package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line5 = Line(
    id = "5",
    name = "5号线",
    name2 = "Line 5",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "滘口", name2 = "Jiaokou"),
        "02" to Station(id = "02", name = "坦尾", name2 = "Tanwei", interchanges = listOf("6")),
        "03" to Station(id = "03", name = "中山八", name2 = "Zhongshanba", interchanges = listOf("11")),
        "04" to Station(id = "04", name = "西场", name2 = "Xichang"),
        "05" to Station(id = "05", name = "西村", name2 = "Xicun", interchanges = listOf("8")),
        "06" to Station(id = "06", name = "广州火车站", name2 = "Guangzhou Railway Station", interchanges = listOf("11")),
        "07" to Station(id = "07", name = "小北", name2 = "Xiaobei"),
        "08" to Station(id = "08", name = "淘金", name2 = "Taojin"),
        "09" to Station(id = "09", name = "区庄", name2 = "Ouzhuang", interchanges = listOf("6")),
        "10" to Station(id = "10", name = "动物园", name2 = "Zoo"),
        "11" to Station(id = "11", name = "杨箕", name2 = "Yangji", interchanges = listOf("1")),
        "12" to Station(id = "12", name = "五羊邨", name2 = "Wuyangcun", exitInterchanges = listOf("五羊邨" to "10")),
        "13" to Station(id = "13", name = "珠江新城", name2 = "Zhujiang New Town", interchanges = listOf("3")),
        "14" to Station(id = "14", name = "猎德", name2 = "Liede"),
        "15" to Station(id = "15", name = "潭村", name2 = "Tancun"),
        "16" to Station(id = "16", name = "员村", name2 = "Yuancun", interchanges = listOf("11")),
        "17" to Station(id = "17", name = "科韵路", name2 = "Keyun Lu", exitInterchanges = listOf("科韵路" to "广东城际")),
        "18" to Station(id = "18", name = "车陂南", name2 = "Chebeinan", interchanges = listOf("4")),
        "19" to Station(id = "19", name = "东圃", name2 = "Dongpu"),
        "20" to Station(id = "20", name = "三溪", name2 = "Sanxi"),
        "21" to Station(id = "21", name = "鱼珠", name2 = "Yuzhu", interchanges = listOf("13")),
        "22" to Station(id = "22", name = "大沙地", name2 = "Dashadi"),
        "23" to Station(id = "23", name = "大沙东", name2 = "Dashadong", interchanges = listOf("7")),
        "24" to Station(id = "24", name = "文冲", name2 = "Wenchong"),
        "25" to Station(id = "25", name = "双沙", name2 = "Shuangsha"),
        "26" to Station(id = "26", name = "庙头", name2 = "Miaotou"),
        "27" to Station(id = "27", name = "夏园", name2 = "Xiayuan", interchanges = listOf("13")),
        "28" to Station(id = "28", name = "保盈大道", name2 = "Baoying Dadao"),
        "29" to Station(id = "29", name = "夏港", name2 = "Xiagang"),
        "30" to Station(id = "30", name = "黄埔新港", name2 = "Huangpu New Port")
    ),
    colorValue = 0xFFC5003E
)