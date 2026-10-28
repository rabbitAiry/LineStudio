package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val fs_Line3 = Line(
    id = "F3",
    name = "佛山3号线",
    name2 = "Foshan Line 3",
    routeList = listOf(
        Route(
            stationList = listOf(
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27"
            )
        ),
        Route(
            stationList = listOf("30", "31", "32", "33", "34", "35", "36", "37", "38")
        )
    ),
    stationMap = mapOf(
        "02" to Station(id = "02", name = "顺德学院", name2 = "Shunde College Railway Station"),
        "03" to Station(id = "03", name = "顺德欢乐海岸", name2 = "Shunde OCT Harbour PLUS"),
        "04" to Station(id = "04", name = "顺德一中", name2 = "Shunde No.1 High School"),
        "05" to Station(id = "05", name = "驹荣北路", name2 = "Jurong Beilu"),
        "06" to Station(id = "06", name = "东乐路", name2 = "Dongle Lu"),
        "07" to Station(id = "07", name = "大良钟楼", name2 = "Daliang Zhonglou"),
        "08" to Station(id = "08", name = "环市北", name2 = "Huanshi Bei"),
        "09" to Station(
            id = "09",
            name = "顺德人民医院",
            name2 = "The First People's Hospital of Shunde"
        ),
        "10" to Station(id = "10", name = "荔村", name2 = "Licun"),
        "11" to Station(id = "11", name = "伦教", name2 = "Lunjiao"),
        "12" to Station(id = "12", name = "广教", name2 = "Guangjiao"),
        "13" to Station(
            id = "13",
            name = "北滘公园",
            name2 = "Beijiao Park",
            interchanges = listOf("7")
        ),
        "14" to Station(id = "14", name = "高村", name2 = "Gaocun"),
        "15" to Station(
            id = "15",
            name = "北滘西站",
            name2 = "Beijiao West Railway Station",
            exitInterchanges = listOf("北滘西" to "广东城际")
        ),
        "16" to Station(
            id = "16",
            name = "潭州会展",
            name2 = "Tanzhou Convention & Exhibition Center"
        ),
        "17" to Station(id = "17", name = "岳步", name2 = "Yuebu"),
        "18" to Station(id = "18", name = "大墩", name2 = "Dadun"),
        "19" to Station(
            id = "19",
            name = "东平",
            name2 = "Dongping",
            interchanges = listOf("GF"),
            exitInterchanges = listOf("顺德北" to "广东城际")
        ),
        "20" to Station(id = "20", name = "湾华", name2 = "Wanhua", interchanges = listOf("F2")),
        "21" to Station(id = "21", name = "亚艺公园", name2 = "Yayi Park"),
        "22" to Station(id = "22", name = "季华六路", name2 = "Jihua Liulu"),
        "23" to Station(id = "23", name = "镇安", name2 = "Zhen'an"),
        "24" to Station(id = "24", name = "桂城", name2 = "Guicheng", interchanges = listOf("GF")),
        "25" to Station(id = "25", name = "西约", name2 = "Xiyue"),
        "26" to Station(id = "26", name = "叠滘", name2 = "Diejiao"),
        "27" to Station(id = "27", name = "中山公园", name2 = "Zhongshan Park"),
        "30" to Station(id = "30", name = "联和", name2 = "Lianhe"),
        "31" to Station(id = "31", name = "孝德东", name2 = "Xiaode Dong"),
        "32" to Station(id = "32", name = "罗村", name2 = "Luocun"),
        "33" to Station(
            id = "33",
            name = "佛山西站",
            name2 = "Foshan West Railway Station",
            exitInterchanges = listOf("佛山西" to "广东城际")
        ),
        "34" to Station(id = "34", name = "兴业东路", name2 = "Xingye Donglu"),
        "35" to Station(id = "35", name = "科盛路", name2 = "Kesheng Lu"),
        "36" to Station(id = "36", name = "博爱中路", name2 = "Bo'ai Zhonglu"),
        "37" to Station(id = "37", name = "南海大学城", name2 = "Nanhai University Town"),
        "38" to Station(id = "38", name = "佛山大学", name2 = "Foshan University")
    ),
    colorValue = 0xFF000F9F
)