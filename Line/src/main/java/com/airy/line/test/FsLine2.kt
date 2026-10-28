package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val fs_Line2 = Line(
    id = "F2",
    name = "佛山2号线",
    name2 ="Foshan Line 2",
    routeList = listOf(
        Route(
            stationList = listOf("11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27")
        )
    ),
    stationMap = mapOf(
        "11" to Station(id = "11", name = "南庄", name2 = "Nanzhuang"),
        "12" to Station(id = "12", name = "湖涌", name2 = "Huchong"),
        "13" to Station(id = "13", name = "绿岛湖", name2 = "Lvdao Lake"),
        "14" to Station(id = "14", name = "智慧新城", name2 = "Zhihui Xincheng"),
        "15" to Station(id = "15", name = "张槎", name2 = "Zhangcha", exitInterchanges = listOf("张槎" to "广东城际")),
        "16" to Station(id = "16", name = "石湾", name2 = "Shiwan"),
        "17" to Station(id = "17", name = "沙岗", name2 = "Shagang"),
        "18" to Station(id = "18", name = "魁奇路", name2 = "Kuiqi Lu", interchanges = listOf("GF")),
        "19" to Station(id = "19", name = "石梁", name2 = "Shiliang"),
        "20" to Station(id = "20", name = "湾华", name2 = "Wanhua", interchanges = listOf("F3")),
        "21" to Station(id = "21", name = "登洲", name2 = "Dengzhou"),
        "22" to Station(id = "22", name = "花卉世界", name2 = "Flower World"),
        "23" to Station(id = "23", name = "仙涌", name2 = "Xianchong"),
        "24" to Station(id = "24", name = "石洲", name2 = "Shizhou"),
        "25" to Station(id = "25", name = "林岳西", name2 = "Linyue Xi", interchanges = listOf("TNH1")),
        "26" to Station(id = "26", name = "林岳东", name2 = "Linyue Dong", exitInterchanges = listOf("林岳东" to "TNH1")),
        "27" to Station(id = "27", name = "广州南站", name2 = "Guangzhou South Railway Station", interchanges = listOf("2", "7", "22"), exitInterchanges = listOf("番禺" to "广东城际"))
    ),
    colorValue = 0xFFF5333F
)