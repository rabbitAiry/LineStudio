package com.airy.linestudio.presentation.display.guangzhou.widget

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.sp
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Station
import com.airy.linestudio.presentation.display.utils.backgroundColor
import com.airy.linestudio.presentation.display.utils.getMaxTextSize
import com.airy.linestudio.presentation.display.utils.splitToTwoStationList
import com.airy.linestudio.presentation.display.utils.grey
import com.airy.linestudio.presentation.display.utils.textRate
import com.airy.linestudio.repository.motion.MotionState
import com.airy.linestudio.repository.utils.color
import com.airy.linestudio.repository.utils.getStationList
import com.airy.linestudio.ui.theme.FlashYellow
import kotlin.math.min

private const val mapPaddingRate = 0.04f            // 左右侧留白
private const val textCollapseRate = 0.04f          // name1和name2文本上下相互折叠以减少空白
private const val arrowWidthRate = 0.36f            // 箭头宽度
private const val arrowHeightRate = 0.2f            // 箭头高度


/**
 * 画C型线
 */
private fun DrawScope.drawCircleRoute(
    line: Line,
    lineMap: LineMap?,
    time: Long,
    status: MotionState,
    textMeasurer: TextMeasurer
) {
    val paddingWidth = mapPaddingRate * size.width
    val (list1, list2) = line.getStationList(status).splitToTwoStationList()
    val stationWidth = (size.width - 2 * paddingWidth) / list2.size

    /**
     * pw: 车站椭圆标志宽度
     * st: 基准文本大小
     */
    val pw = stationWidth / 2
    val st = (getMaxTextSize(textMeasurer, (pw / 2).toInt()) * 0.9).toInt()
    val curveStartX = size.width - paddingWidth - (1 - arrowWidthRate)/2 * pw    /* 箭头剩余空间 */
    val radius = min(paddingWidth * 0.8f, size.height / 4f)

    /*
    仅过此界点后使用彩色线路
     */
    val boundaryId = if (status.inStop) status.stationId else status.stationId - 1
    val boundaryAtTop = boundaryId < list1.size
    val routeSize = line.getStationList(status).size

    drawCircleLine(
        line = line,
        status = status,
        pw = pw,
        boundaryId = boundaryId,
        boundaryAtTop = boundaryAtTop,
        curveStartX = curveStartX,
        radius = radius
    )

    val topLineY = size.height / 4
    val unpassedArrowCnt =
        if (boundaryAtTop) routeSize - status.stationId + 2
        else routeSize - status.stationId

    var currX = paddingWidth
    var arrowId = 0
    for ((idx, station) in list1.withIndex()) {
        val position = idx
        drawStation(
            station = station,
            line = line,
            lineMap = lineMap,
            centerLeft = Offset(currX, topLineY),
            isPassed = if (status.inStop) boundaryId > position else boundaryId >= position,
            pw = pw,
            st = st,
            isLast = idx == list1.size-1,
            textMeasurer = textMeasurer,
            isTextAbove = idx % 2 == 1,
            isTextRotated = false,
            isInterchangeListVertical = false,
        )
        drawArrow(
            center = Offset(currX + 1.5f * pw, topLineY),
            degree = 0f,
            pw = pw,
            highlight =
                if (boundaryId > position) false
                else {
                    arrowId++
                    arrowId - 1 < time % unpassedArrowCnt
                }
        )
        currX += stationWidth
    }

    drawArrow(
        center = Offset(curveStartX + radius, size.height / 2),
        degree = 90f,
        pw = pw,
        highlight =
            if (boundaryId >= list1.size) false
            else {
                arrowId++
                arrowId - 1 < time % unpassedArrowCnt
            }
    )

    val bottomLineY = size.height / 4 * 3
    arrowId = unpassedArrowCnt - 1
    currX = paddingWidth
    for ((idx, station) in list2.withIndex()) {
        val position = routeSize - idx - 1
        drawStation(
            station = station,
            line = line,
            lineMap = lineMap,
            centerLeft = Offset(currX, bottomLineY),
            isPassed = if (status.inStop) boundaryId > position else boundaryId >= position,
            isLast = idx == list2.size-1,
            pw = pw,
            st = st,
            textMeasurer = textMeasurer,
            isTextAbove = idx % 2 == 1,
            isTextRotated = false,
            isInterchangeListVertical = false,
        )
        drawArrow(
            center = Offset(currX + 1.5f * pw, bottomLineY),
            degree = 180f,
            pw = pw,
            highlight =
                if (boundaryId >= position) false
                else {
                    arrowId--
                    arrowId + 1 < time % unpassedArrowCnt
                }
        )
        currX += stationWidth
    }

    // drawText(textMeasurer, "pw: $pw, st:$st")
    // 3000:1000 | pw: 92, st: 14
}

/**
 * 画C型线
 */
private fun DrawScope.drawLineRoute(
    line: Line,
    lineMap: LineMap?,
    time: Long,
    status: MotionState,
    textMeasurer: TextMeasurer
) {
    val paddingWidth = mapPaddingRate * size.width
    val routeSize = line.getStationList(status).size

    /**
     * pw: 车站椭圆标志宽度
     * st: 基准文本大小
     */
    val pw = (size.width - 2 * paddingWidth) / (routeSize * 2 - 1)
    val stationWidth = pw * 2
    val st = (getMaxTextSize(textMeasurer, (pw / 2).toInt()) * 0.9).toInt()

    /*
    仅过此界点后使用彩色线路
     */
    val boundaryId = if (status.inStop) status.stationId else status.stationId - 1
    val lineWidth = pw / 4

    val lineStartX = paddingWidth / 2     // 整体左移半个padding
    val lineStartY = size.height / 2

    drawPath(
        path = Path().apply {
            moveTo(lineStartX, lineStartY)
            lineTo(lineStartX + pw * 2 * boundaryId, lineStartY)
        },
        color = line.color.grey(),
        style = Stroke(width = lineWidth)
    )
    drawPath(
        path = Path().apply {
            moveTo(lineStartX + pw * 2 * boundaryId, lineStartY)
            lineTo(size.width - paddingWidth * 1.5f, lineStartY)
        },
        color = line.color,
        style = Stroke(width = lineWidth)
    )

    val unpassedArrowCnt = routeSize - status.stationId + 1

    var currX = lineStartX
    var arrowId = 0
    for ((idx, station) in line.getStationList(status).withIndex()) {
        val position = idx
        drawStation(
            station = station,
            line = line,
            lineMap = lineMap,
            centerLeft = Offset(currX, lineStartY),
            isPassed = if (status.inStop) boundaryId > position else boundaryId >= position,
            isLast = idx == line.getStationList(status).size-1,
            pw = pw,
            st = st,
            textMeasurer = textMeasurer,
            isTextAbove = true,
            isTextRotated = true,
            isInterchangeListVertical = true,
        )
        if (idx == routeSize - 1) break
        drawArrow(
            center = Offset(currX + 1.5f * pw, lineStartY),
            degree = 0f,
            pw = pw,
            highlight =
                if (boundaryId > position) false
                else {
                    arrowId++
                    arrowId - 1 < time % unpassedArrowCnt
                }
        )
        currX += stationWidth
    }
}

private fun DrawScope.drawCircleLine(
    line: Line,
    status: MotionState,
    pw: Float,
    boundaryId: Int,
    boundaryAtTop: Boolean,
    curveStartX: Float,
    radius: Float
) {
    val routeSize = line.getStationList(status).size
    val lineWidth = pw / 4

    val lineStartX = mapPaddingRate * size.width
    val lineStartY = size.height / 4
    val lineEndY = size.height / 4 * 3

    if (boundaryAtTop) {
        drawPath(
            path = Path().apply {
                moveTo(lineStartX, lineStartY)
                lineTo(lineStartX + pw * 2 * boundaryId, lineStartY)
            },
            color = line.color.grey(),
            style = Stroke(width = lineWidth)
        )
        drawPath(
            path = Path().apply {
                moveTo(lineStartX + pw * 2 * boundaryId, lineStartY)
                lineTo(curveStartX, lineStartY)
                quadraticTo(
                    curveStartX + radius,
                    lineStartY,
                    curveStartX + radius,
                    lineStartY + radius
                )
                lineTo(curveStartX + radius, lineEndY - radius)
                quadraticTo(curveStartX + radius, lineEndY, curveStartX, lineEndY)
                lineTo(lineStartX, lineEndY)
            },
            color = line.color,
            style = Stroke(width = lineWidth)
        )
    } else {
        val boundaryStartX = pw * 2 * (routeSize - boundaryId)
        drawPath(
            path = Path().apply {
                moveTo(lineStartX, lineStartY)
                lineTo(curveStartX, lineStartY)
                quadraticTo(
                    curveStartX + radius,
                    lineStartY,
                    curveStartX + radius,
                    lineStartY + radius
                )
                lineTo(curveStartX + radius, lineEndY - radius)
                quadraticTo(curveStartX + radius, lineEndY, curveStartX, lineEndY)
                lineTo(boundaryStartX, lineEndY)
            },
            color = line.color.grey(),
            style = Stroke(width = lineWidth)
        )
        drawPath(
            path = Path().apply {
                moveTo(boundaryStartX, lineEndY)
                lineTo(lineStartX, lineEndY)
            },
            color = line.color,
            style = Stroke(width = lineWidth)
        )
    }
}

/**
 * @param isPassed 是否已经过站
 * @param isTextAbove 车站名称是否在线的上方
 * @param isInterchangeListVertical 换乘站列表使用横向还是竖向
 */
private fun DrawScope.drawStation(
    station: Station,
    line: Line,
    lineMap: LineMap?,
    isPassed: Boolean,
    isLast: Boolean,
    centerLeft: Offset,
    pw: Float,
    st: Int,
    textMeasurer: TextMeasurer,
    isTextAbove: Boolean,
    isTextRotated: Boolean,
    isInterchangeListVertical: Boolean
) {
    drawPill(pw, line, centerLeft, textMeasurer, st, station, isPassed)
    if (isTextRotated) drawStationNameTextRotated(centerLeft, pw, textMeasurer, station, st, isLast)
    else drawStationNameText(centerLeft, pw, textMeasurer, station, st, isTextAbove)
    drawInterchanges(
        pw,
        line,
        station,
        lineMap,
        centerLeft,
        isTextAbove,
        textMeasurer,
        st,
        isPassed,
        isInterchangeListVertical
    )
}

private fun DrawScope.drawPill(
    pw: Float,
    line: Line,
    centerLeft: Offset,
    textMeasurer: TextMeasurer,
    st: Int,
    station: Station,
    isPassed: Boolean
) {
    val pillBorderWidth = 0.05f * pw
    val pillColor = if (isPassed) line.color.grey() else line.color

    // pill-background
    drawRoundRect(
        color = Color.White,
        topLeft = Offset(centerLeft.x, centerLeft.y - 0.25f * pw),
        size = Size(pw, 0.5f * pw),
        cornerRadius = CornerRadius(0.5f * pw, 0.5f * pw),
        style = Fill
    )
    drawRoundRect(
        color = pillColor,
        topLeft = Offset(centerLeft.x, centerLeft.y - 0.25f * pw),
        size = Size(pw, 0.5f * pw),
        cornerRadius = CornerRadius(0.5f * pw, 0.5f * pw),
        style = Stroke(pillBorderWidth)
    )
    // pill-center line
    drawLine(
        color = pillColor,
        start = Offset(centerLeft.x + 0.5f * pw, centerLeft.y - 0.25f * pw),
        end = Offset(centerLeft.x + 0.5f * pw, centerLeft.y + 0.25f * pw),
        strokeWidth = pillBorderWidth
    )
    val lineIdTextRate = textRate(line.id, 0.6f)
    val stationIdTextRate = textRate(station.id, 0.6f)
    // pill-line id
    val lineIdText = textMeasurer.measure(line.id, TextStyle(fontSize = (st * 0.9 * lineIdTextRate).sp))
    drawText(
        textLayoutResult = lineIdText,
        topLeft = Offset(
            centerLeft.x + 0.25f * pw - lineIdText.size.width / 2,
            centerLeft.y - lineIdText.size.height / 2
        ),
    )
    // pill-station id
    val stationIdText =
        textMeasurer.measure(
            station.id,
            TextStyle(fontSize = (st * 0.9 * stationIdTextRate).sp)
        )
    drawText(
        textLayoutResult = stationIdText,
        topLeft = Offset(
            centerLeft.x + 0.75f * pw - stationIdText.size.width / 2,
            centerLeft.y - stationIdText.size.height / 2
        ),
    )
}

private fun DrawScope.drawStationNameText(
    centerLeft: Offset,
    pw: Float,
    textMeasurer: TextMeasurer,
    station: Station,
    stationTextSize: Int,
    isTextAbove: Boolean,
) {
    val maxWidth = pw * 1.8f
    val stationNameText =
        textMeasurer.measure(
            station.name,
            TextStyle(fontSize = (0.9 * stationTextSize).sp, textAlign = TextAlign.Center),
            constraints = Constraints(maxWidth = maxWidth.toInt())
        )
    val stationName2Text =
        textMeasurer.measure(
            station.name2,
            TextStyle(fontSize = (0.6 * stationTextSize).sp, textAlign = TextAlign.Center),
            constraints = Constraints(maxWidth = maxWidth.toInt())
        )
    var currTop =
        if (isTextAbove) centerLeft.y - 0.25f * pw - stationName2Text.size.height - stationNameText.size.height
        else centerLeft.y + 0.25f * pw

    drawText(
        textLayoutResult = stationNameText,
        color = Color.Black,
        topLeft = Offset(
            x = centerLeft.x + 0.5f * pw - stationNameText.size.width / 2,
            y = currTop
        )
    )
    currTop += stationNameText.size.height - textCollapseRate * pw
    drawText(
        textLayoutResult = stationName2Text,
        color = Color.Black,
        topLeft = Offset(
            x = centerLeft.x + 0.5f * pw - stationName2Text.size.width / 2,
            y = currTop
        )
    )
}

private fun DrawScope.drawStationNameTextRotated(
    centerLeft: Offset,
    pw: Float,
    textMeasurer: TextMeasurer,
    station: Station,
    stationTextSize: Int,
    isLast: Boolean
) {
    val textPadding = 0.8f * pw
    val root2 = 1.3
    val widthLimitFromHeight = size.height / 2 * 0.9 * root2
    val widthLimitFromEnd = (mapPaddingRate * size.width * 1.5 + pw - textPadding) * root2
    val maxWidth = if (isLast) min(widthLimitFromEnd, widthLimitFromHeight) else widthLimitFromHeight
    val stationNameText =
        textMeasurer.measure(
            station.name,
            TextStyle(fontSize = (1.1 * stationTextSize).sp, textAlign = TextAlign.Center),
            constraints = Constraints(maxWidth = maxWidth.toInt())
        )
    val stationName2Text =
        textMeasurer.measure(
            station.name2,
            TextStyle(fontSize = (0.8 * stationTextSize).sp, textAlign = TextAlign.Center),
            constraints = Constraints(maxWidth = maxWidth.toInt())
        )

    rotate(-45f, centerLeft) {
        drawText(
            textLayoutResult = stationNameText,
            color = Color.Black,
            topLeft = centerLeft + Offset(textPadding*0.8f, (-stationNameText.size.height).toFloat())
        )
        drawText(
            textLayoutResult = stationName2Text,
            color = Color.Black,
            topLeft = centerLeft + Offset(textPadding, -textCollapseRate * pw)
        )
    }
}

private fun DrawScope.drawInterchanges(
    pw: Float,
    line: Line,
    station: Station,
    lineMap: LineMap?,
    centerLeft: Offset,
    isTextAbove: Boolean,
    textMeasurer: TextMeasurer,
    st: Int,
    isPassed: Boolean,
    isVertical: Boolean
) {
    val blockWidth = 1.1f * pw
    val blockHeight = 0.6f * pw
    val blockGap = 0.02f * pw
    val pillGap = 0.2f * pw
    val radius = 0.12f * pw

    val interchanges = station.interchanges
    val exitInterchanges = station.exitInterchanges.map { it.second }.filter { !it.contains("城际") }
    val transferOptions = when {
        interchanges.isNotEmpty() && exitInterchanges.isNotEmpty() -> interchanges + exitInterchanges
        interchanges.isNotEmpty() -> interchanges
        else -> null
    }
    transferOptions?.let { options ->
        val lineList = options.mapNotNull { lineMap?.lines?.get(it) }
        var left =
            if (isVertical) centerLeft.x + 0.5f * pw - blockWidth * 0.5f
            else centerLeft.x + 0.5f * pw - (lineList.size * blockWidth + (lineList.size - 1) * blockGap) * 0.5f
        var top = when {
            isVertical and isTextAbove -> centerLeft.y + 0.25f * pw + pillGap
            isVertical -> centerLeft.y - 0.25f * pw - pillGap - blockHeight * lineList.size - blockGap * (lineList.size - 1)
            isTextAbove -> centerLeft.y + 0.25f * pw + pillGap
            else -> centerLeft.y - 0.25f * pw - pillGap - blockHeight
        }
        lineList.forEach { otherLine ->
            var currTop = top
            val limitRate = textRate(otherLine.name)

            drawRoundRect(
                color = if (isPassed) otherLine.color.grey() else otherLine.color,
                topLeft = Offset(left, currTop),
                size = Size(blockWidth, blockHeight),
                cornerRadius = CornerRadius(radius)
            )

            val textColor = otherLine.color.backgroundColor()
            val lineNameText =
                textMeasurer.measure(
                    otherLine.name,
                    TextStyle(fontSize = (0.8 * limitRate * st).sp),
                    constraints = Constraints(maxWidth = (pw * 1.8).toInt())
                )
            val lineName2Text =
                textMeasurer.measure(
                    otherLine.name2,
                    TextStyle(fontSize = (0.5 * limitRate * st).sp),
                    constraints = Constraints(maxWidth = (pw * 1.8).toInt())
                )
            val totalHeight = lineNameText.size.height + lineName2Text.size.height
            currTop += (blockHeight - totalHeight) / 2
            drawText(
                textLayoutResult = lineNameText,
                color = textColor,
                topLeft = Offset(
                    left + (blockWidth - lineNameText.size.width) / 2,
                    currTop
                )
            )
            currTop += lineNameText.size.height - textCollapseRate * pw
            drawText(
                textLayoutResult = lineName2Text,
                color = textColor,
                topLeft = Offset(
                    left + (blockWidth - lineName2Text.size.width) / 2,
                    currTop
                )
            )
            if (isVertical) top += blockHeight + blockGap
            else left += blockWidth + blockGap
        }
    }
}

/**
 * @param highlight 设为黄色箭头
 */
private fun DrawScope.drawArrow(
    center: Offset,
    degree: Float,
    pw: Float,
    highlight: Boolean
) {
    val width = pw * arrowWidthRate
    val headHeight = pw * arrowHeightRate
    val headWidth = width / 2
    val lineHeight = headHeight / 2

    val startX = center.x - width / 2
    val color = if (highlight) FlashYellow else Color.White
    val arrowPath = Path().apply {
        // 描边
        moveTo(startX, center.y - lineHeight / 2)
        lineTo(startX + width - headWidth, center.y - lineHeight / 2)
        lineTo(startX + width - headWidth, center.y - headHeight / 2)
        lineTo(startX + width, center.y)
        lineTo(startX + width - headWidth, center.y + headHeight / 2)
        lineTo(startX + width - headWidth, center.y + lineHeight / 2)
        lineTo(startX, center.y + lineHeight / 2)
        lineTo(startX, center.y - lineHeight / 2)
    }
    rotate(degree, center) {
        drawPath(
            path = arrowPath,
            color = color,
            style = Fill
        )
        drawPath(
            path = arrowPath,
            color = Color.Black,
            style = Stroke(join = StrokeJoin.Round)
        )
    }
}