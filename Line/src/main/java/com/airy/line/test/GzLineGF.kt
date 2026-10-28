package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val gz_guangFoLine = Line(
    id = "GF",
    name = "广佛线",
    name2 ="Guangfo Line",
    routeList = listOf(
        Route(stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"))
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "新城东", name2 ="Xincheng Dong"),
        "02" to Station(id = "02", name = "东平", name2 ="Dongping", interchanges = listOf("F3"), exitInterchanges = listOf("顺德北" to "广东城际")),
        "03" to Station(id = "03", name = "世纪莲", name2 ="Shijilian"),
        "04" to Station(id = "04", name = "澜石", name2 ="Lanshi"),
        "05" to Station(id = "05", name = "魁奇路", name2 ="Kuiqi Lu", interchanges = listOf("F2")),
        "06" to Station(id = "06", name = "季华园", name2 ="Jihua Park"),
        "07" to Station(id = "07", name = "同济路", name2 ="Tongji Lu"),
        "08" to Station(id = "08", name = "祖庙", name2 ="Zumiao"),
        "09" to Station(id = "09", name = "普君北路", name2 ="Pujun Beilu"),
        "10" to Station(id = "10", name = "朝安", name2 ="Chao'an"),
        "11" to Station(id = "11", name = "桂城", name2 ="Guicheng", interchanges = listOf("F3")),
        "12" to Station(id = "12", name = "南桂路", name2 ="Nangui Lu"),
        "13" to Station(id = "13", name = "\uD85D\uDCBD岗", name2 ="Leigang", exitInterchanges = listOf("虫雷岗" to "APM")),
        "14" to Station(id = "14", name = "千灯湖", name2 ="Qiandeng Lake"),
        "15" to Station(id = "15", name = "金融高新区", name2 ="Financial Hi-Tech Zone"),
        "16" to Station(id = "16", name = "龙溪", name2 ="Longxi"),
        "17" to Station(id = "17", name = "菊树", name2 ="Jushu"),
        "18" to Station(id = "18", name = "西塱", name2 ="Xilang", interchanges = listOf("1", "10", "22")),
        "19" to Station(id = "19", name = "鹤洞", name2 ="Hedong"),
        "20" to Station(id = "20", name = "沙涌", name2 ="Shachong", interchanges = listOf("11")),
        "21" to Station(id = "21", name = "沙园", name2 ="Shayuan", interchanges = listOf("8")),
        "22" to Station(id = "22", name = "燕岗", name2 ="Yangang", interchanges = listOf("11")),
        "23" to Station(id = "23", name = "石溪", name2 ="Shixi"),
        "24" to Station(id = "24", name = "南洲", name2 ="Nanzhou", interchanges = listOf("2")),
        "25" to Station(id = "25", name = "沥滘", name2 ="Lijiao", interchanges = listOf("3"))
    ),
    colorValue = 0xFFC4D600
)