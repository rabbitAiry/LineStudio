package com.airy.line.test

import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station

val fs_tnh1 = Line(
    id = "TNH1",
    name = "南海有轨1号线",
    name2 = "TNH1",
    routeList = listOf(
        Route(
            stationList = listOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15")
        )
    ),
    stationMap = mapOf(
        "01" to Station(id = "01", name = "\uD85D\uDCBD岗", name2 = "Leigang", exitInterchanges = listOf("\uD85D\uDCBD岗" to "GF")),
        "02" to Station(id = "02", name = "华翠路", name2 = "Huacuilu"),
        "03" to Station(id = "03", name = "夏西", name2 = "Xiaxi"),
        "04" to Station(id = "04", name = "夏东", name2 = "Xiadong"),
        "05" to Station(id = "05", name = "康怡公园", name2 = "Kangyi Park"),
        "06" to Station(id = "06", name = "平西", name2 = "Pingxi"),
        "07" to Station(id = "07", name = "平南", name2 = "Pingnan"),
        "08" to Station(id = "08", name = "玉器街", name2 = "Yuqijie"),
        "09" to Station(id = "09", name = "中区", name2 = "Zhongqu"),
        "10" to Station(id = "10", name = "三山新城北", name2 = "Sanshanxinchengbei"),
        "11" to Station(id = "11", name = "文翰湖公园（季华实验室）", name2 = "Wenhanhu Park(Ji Hua Laboratory)"),
        "12" to Station(id = "12", name = "三山新城南", name2 = "Sanshanxinchengnan"),
        "13" to Station(id = "13", name = "林岳北", name2 = "Linyuebei"),
        "14" to Station(id = "14", name = "林岳西", name2 = "Linyue Xi", interchanges = listOf("F2")),
        "15" to Station(id = "15", name = "林岳东", name2 = "Linyuedong", exitInterchanges = listOf("林岳东" to "F2"))
    ),
    colorValue = 0xFF5EB3E4
)