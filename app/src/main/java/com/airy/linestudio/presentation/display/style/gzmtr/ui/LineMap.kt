package com.airy.linestudio.presentation.display.style.gzmtr.ui

// map
private const val map_padding_rate = 0.3f

// station indicator
private const val si_width_rate = 2f
private const val si_height_rate = 1f
private const val si_stroke_rate = 0.08f
private const val si_gap_rate = 0.2f

// line
private const val line_stroke_rate = 0.5f

// line box
private const val lb_width_rate = 2.2f
private const val lb_height_rate = 1.2f
private const val lb_boxes_gap_rate = 0.05f
private const val lb_stick_width_rate = 0.1f
private const val lb_stick_height_rate = 0.5f

// arrow
private const val ar_width_rate = 0.5f
private const val ar_height_rate = 0.5f

/*
@Composable
fun GzMtrLineMap(line: Line, details: Map<String, StationDetail>, sr: Float) {
    val textMeasurer = rememberTextMeasurer(line.routeList.size * 4)

    Canvas(Modifier.fillMaxSize()) {
        drawMapInULine(line, sr, textMeasurer, details)
    }
}

private fun DrawScope.drawMapInOneLine(
    line: Line,
    sr: Float,
    textMeasurer: TextMeasurer,
    details: Map<String, StationDetail>
) {
    val itemWidth = size.width / (line.routeList.size + map_padding_rate * 2)
    val startX = itemWidth * (0.5f + map_padding_rate)
    val endX = size.width - itemWidth * (0.5f + map_padding_rate)

    val lineIdLayout = layoutLineId(
        id = line.id,
        sr = sr,
        maxWidth = si_width_rate * sr,
        textMeasurer = textMeasurer
    )

    val layoutInfoList = layoutGzMtrStations(
        list = line.routeList,
        details = details,
        sr = sr,
        maxNameWidth = (itemWidth * 1.6f).toInt(),
        maxIdWidth = ((si_width_rate/2 - si_stroke_rate) * sr).toInt(),
        maxLineBoxWidth = (lb_width_rate * sr).toInt(),
        textMeasurer = textMeasurer,
    )

    drawLine(
        color = line.color,
        start = Offset(startX, size.height / 2),
        end = Offset(endX, size.height / 2),
        strokeWidth = sr * line_stroke_rate
    )

    drawStationList(
        lineIdLayout = lineIdLayout,
        layoutInfoList = layoutInfoList,
        sr = sr,
        itemWidth = itemWidth,
        startX = startX,
        y = size.height / 2,
        color = line.color,
        arrowDegree = 0f
    )
}

private fun DrawScope.drawMapInULine(
    line: Line,
    sr: Float,
    textMeasurer: TextMeasurer,
    details: Map<String, StationDetail>
) {
    val itemWidth = size.width / ((line.routeList.size + 1) / 2 + map_padding_rate * 3)
    val startX = itemWidth * (0.5f + map_padding_rate)
    val endX = size.width - itemWidth * (0.5f + 2 * map_padding_rate)
    val uLineX = size.width - itemWidth * map_padding_rate
    val topY = size.height * 0.25f
    val bottomY = size.height * 0.75f

    val (topList, bottomList) = line.routeList.splitToTwoStationList()
    val lineIdLayout = layoutLineId(
        id = line.id,
        sr = sr,
        maxWidth = si_width_rate * sr,
        textMeasurer = textMeasurer
    )
    val topLayoutInfoList = layoutGzMtrStations(
        list = topList,
        details = details,
        sr = sr,
        maxNameWidth = (itemWidth * 1.6f).toInt(),
        maxIdWidth = ((si_width_rate/2 - si_stroke_rate) * sr).toInt(),
        maxLineBoxWidth = (lb_width_rate * sr).toInt(),
        textMeasurer = textMeasurer,
    )
    val bottomLayoutInfoList = layoutGzMtrStations(
        list = bottomList,
        details = details,
        sr = sr,
        maxNameWidth = (itemWidth * 1.6f).toInt(),
        maxIdWidth = ((si_width_rate/2 - si_stroke_rate) * sr).toInt(),
        maxLineBoxWidth = (lb_width_rate * sr).toInt(),
        textMeasurer = textMeasurer,
    )

    val lineRadius = itemWidth * (map_padding_rate + 0.5f)
    drawPath(
        path = Path().apply {
            moveTo(startX, topY)
            lineTo(endX, topY)
            quadraticBezierTo(uLineX, topY, uLineX, topY + lineRadius)
            lineTo(uLineX, bottomY - lineRadius)
            quadraticBezierTo(uLineX, bottomY, endX, bottomY)
            lineTo(startX, bottomY)
        },
        color = line.color,
        style = Stroke(width = sr * line_stroke_rate)
    )
    val verticalArrowStep = (bottomY - topY - 2 * lineRadius) / 3
    var verticalArrowStartY = topY + lineRadius + verticalArrowStep / 2
    for (i in 0 until 3) {
        drawArrow(
            topLeft = Offset(uLineX - sr * line_stroke_rate / 2, verticalArrowStartY),
            degree = 90f,
            width = sr * ar_width_rate,
            height = sr * ar_height_rate
        )
        verticalArrowStartY += verticalArrowStep
    }

    drawStationList(
        lineIdLayout = lineIdLayout,
        layoutInfoList = topLayoutInfoList,
        sr = sr,
        itemWidth = itemWidth,
        startX = startX,
        y = topY,
        color = line.color,
        arrowDegree = 0f
    )

    drawStationList(
        lineIdLayout = lineIdLayout,
        layoutInfoList = bottomLayoutInfoList,
        sr = sr,
        itemWidth = itemWidth,
        startX = startX,
        y = bottomY,
        color = line.color,
        arrowDegree = 180f
    )
}

fun DrawScope.drawStationList(
    lineIdLayout: TextLayoutResult,
    layoutInfoList: List<GzMtrStationLayoutInfo>,
    sr: Float,
    itemWidth: Float,
    startX: Float,
    y: Float,
    color: Color,
    arrowDegree: Float,
) {
    for ((idx, info) in layoutInfoList.withIndex()) {
        val center = Offset(idx * itemWidth + startX, y)

        drawGzMtrStationIndicator(
            lineColor = color,
            lineIdLayout = lineIdLayout,
            stationIdLayout = info.stationIdLayout,
            topLeft = center + Offset(-sr * si_width_rate / 2, -sr * si_height_rate / 2),
            width = si_width_rate * sr,
            height = si_height_rate * sr,
            strokeWidth = si_stroke_rate * sr
        )

        drawGzMtrStationName(
            textLayout = info.stationNameLayout,
            textLayoutEn = info.stationNameEnLayout,
            isUpside = (idx % 2 == 0),
            indicatorLeftTop = center + Offset(0f, -sr * (si_height_rate / 2f + si_gap_rate)),
            indicatorLeftBottom = center + Offset(0f, sr * (si_height_rate / 2f + si_gap_rate))
        )

        drawGzMtrTransferLines(
            interchanges = info.interchanges,
            boxWidth = lb_width_rate * sr,
            boxHeight = lb_height_rate * sr,
            boxGap = lb_boxes_gap_rate * sr,
            stickWidth = lb_stick_width_rate * sr,
            stickHeight = lb_stick_height_rate * sr,
            isHorizontal = false,
            isDownside = (idx % 2 == 0),
            centerX = center.x,
            topY = center.y - si_height_rate * sr / 2,
            bottomY = center.y + si_height_rate * sr / 2
        )

        if (idx != 0) {
            drawArrow(
                topLeft = center + Offset(-itemWidth / 2f - sr * ar_width_rate / 2, -sr * line_stroke_rate / 2),
                degree = arrowDegree,
                width = sr * ar_width_rate,
                height = sr * ar_height_rate
            )
        }
    }
}

 */