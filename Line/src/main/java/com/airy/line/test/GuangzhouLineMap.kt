package com.airy.line.test

import com.airy.line.Line
import com.airy.line.LineMap

val guangzhouLineMap = LineMap(
    name = "广州（广佛）",
    lines = mapOf(
        "1" to gz_line1,
        "2" to gz_line2,
        "3" to gz_line3,
        "4" to gz_line4,
        "5" to gz_line5,
        "6" to gz_line6,
        "7" to gz_line7,
        "8" to gz_line8,
        "9" to gz_line9,
        "10" to gz_line10,
        "11" to gz_line11,
        "12" to gz_line12,
        "13" to gz_line13,
        "14" to gz_line14,
        "18" to gz_line18,
        "21" to gz_line21,
        "22" to gz_line22,
        "APM" to gz_apmLine,
        "GF" to gz_guangFoLine,
        "F2" to fs_Line2,
        "F3" to fs_Line3,
        "TNH1" to fs_tnh1,

        "广东城际" to Line(
            "广东城际",
            name = "广东城际",
            name2 = "Guangdong Intercity",
            stationMap = emptyMap(),
            colorValue = 0xFF206CEF
        ),
    )
)