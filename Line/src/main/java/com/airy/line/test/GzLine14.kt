package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_line14 = Line(
    id = "14",
    name = "14号线",
    name2 = "Line 14",
    routeList = listOf(
        Route(stationList = listOf("02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21")),
        Route(stationList = listOf("02", "03", "04", "05", "06", "07", "08", "09", "10", "16", "20", "21"), expressOf = 0),
        Route(stationList = listOf("16", "22", "23", "24", "25", "26", "27", "28", "29", "30"))
    ),
    stationMap = mapOf(
        "02" to Station(id = "02", name = "乐嘉路", name2 = "Baiyun Dongping"),
        "03" to Station(id = "03", name = "云霄路", name2 = "Xialiang"),
        "04" to Station(id = "04", name = "新市墟", name2 = "Taihe", interchanges = listOf("12")),
        "05" to Station(id = "05", name = "马务", name2 = "Zhuliao"),
        "06" to Station(id = "06", name = "鹤边", name2 = "Zhongluotan"),
        "07" to Station(id = "07", name = "鹤龙", name2 = "Mali"),
        "08" to Station(id = "08", name = "彭边", name2 = "Xinhe"),
        "09" to Station(id = "09", name = "嘉禾望岗", name2 = "Jiahewanggang", interchanges = listOf("2", "3")),
        "10" to Station(id = "10", name = "白云东平", name2 = "Baiyun Dongping"),
        "11" to Station(id = "11", name = "夏良", name2 = "Xialiang"),
        "12" to Station(id = "12", name = "太和", name2 = "Taihe"),
        "13" to Station(id = "13", name = "竹料", name2 = "Zhuliao", exitInterchanges = listOf("竹料" to "广东城际")),
        "14" to Station(id = "14", name = "钟落潭", name2 = "Zhongluotan"),
        "15" to Station(id = "15", name = "马沥", name2 = "Mali"),
        "16" to Station(id = "16", name = "新和", name2 = "Xinhe", interchanges = listOf("14知识城")),
        "17" to Station(id = "17", name = "太平", name2 = "Taiping"),
        "18" to Station(id = "18", name = "神岗", name2 = "Shengang"),
        "19" to Station(id = "19", name = "赤草", name2 = "Chicao"),
        "20" to Station(id = "20", name = "从化客运站", name2 = "Conghua Coach Terminal"),
        "21" to Station(id = "21", name = "东风", name2 = "Dongfeng"),
        "22" to Station(id = "22", name = "红卫", name2 = "Hongwei"),
        "23" to Station(id = "23", name = "新南", name2 = "Xinnan"),
        "24" to Station(id = "24", name = "枫下", name2 = "Fengxia"),
        "25" to Station(id = "25", name = "知识城", name2 = "Sino-Singapore Guangzhou Knowledge City"),
        "26" to Station(id = "26", name = "何棠下", name2 = "Hetangxia"),
        "27" to Station(id = "27", name = "旺村", name2 = "Wangcun"),
        "28" to Station(id = "28", name = "汤村", name2 = "Tangcun"),
        "29" to Station(id = "29", name = "镇龙北", name2 = "Zhenlongbei"),
        "30" to Station(id = "30", name = "镇龙", name2 = "Zhenlong", interchanges = listOf("21"))
    ),
    colorValue = 0xFF81312F
)
