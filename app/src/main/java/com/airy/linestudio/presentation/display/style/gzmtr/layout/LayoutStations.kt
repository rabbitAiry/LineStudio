package com.airy.linestudio.presentation.display.style.gzmtr.layout

private const val station_text_rate = 0.8f
private const val station_text_en_rate = 0.5f
private const val base_id_text_rate = 0.6f
private const val line_box_text_rate = 0.6f
private const val line_box_text_en_rate = 0.35f

/*
fun layoutGzMtrStations(
    list: List<Station>,
    details: Map<String, StationDetail>,
    sr: Float,
    maxNameWidth: Int,
    maxIdWidth: Int,
    maxLineBoxWidth: Int,
    textMeasurer: TextMeasurer,
): List<GzMtrStationLayoutInfo> {
    val textStyle = TextStyle(fontSize = (sr * station_text_rate).sp)
    val textStyleEn = TextStyle(fontSize = (sr * station_text_en_rate).sp, textAlign = TextAlign.Center)
    val idTextStyle = TextStyle(fontSize = (sr * base_id_text_rate).sp)

    val res = LinkedList<GzMtrStationLayoutInfo>()
    for (station in list) {
        res.add(
            GzMtrStationLayoutInfo(
                stationIdLayout = layoutIdText(
                    text = station.id,
                    style = idTextStyle,
                    baseSize = sr * base_id_text_rate,
                    maxWidth = maxIdWidth,
                    textMeasurer = textMeasurer
                ),
                stationNameLayout = textMeasurer.measure(
                    text = station.name,
                    style = textStyle
                ),
                stationNameEnLayout = textMeasurer.measure(
                    text = station.otherNames.getOrElse(0) { "" },
                    style = textStyleEn,
                    constraints = Constraints(maxWidth = maxNameWidth),
                    maxLines = 2
                ),
                interchanges = details[station.name]?.getAll()?.map {
                    layoutGzMtrLineBox(
                        line = it,
                        baseTextSize = sr * line_box_text_rate,
                        baseTextEnSize = sr * line_box_text_en_rate,
                        maxWidth = maxLineBoxWidth,
                        textMeasurer = textMeasurer
                    )
                } ?: emptyList()
            )
        )
    }
    return res
}

*/