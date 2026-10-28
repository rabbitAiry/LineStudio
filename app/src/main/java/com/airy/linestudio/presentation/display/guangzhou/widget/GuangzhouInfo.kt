package com.airy.linestudio.presentation.display.guangzhou.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airy.line.Line
import com.airy.line.Route
import com.airy.line.Station
import com.airy.linestudio.presentation.display.utils.backgroundColor
import com.airy.linestudio.presentation.display.utils.getMaxTextSize
import com.airy.linestudio.presentation.display.utils.lighter
import com.airy.linestudio.presentation.display.utils.textRate
import com.airy.linestudio.repository.motion.MotionState
import com.airy.linestudio.repository.utils.color
import com.airy.linestudio.repository.utils.currStop
import com.airy.linestudio.repository.utils.terminalStop

private const val lineNameSizeRate = 0.8f           // 线路name1文本大小
private const val lineName2SizeRate = 0.5f          // 线路name2文本大小
private const val hintSizeRate = 0.6f               // 提示词文本大小
private const val routeInfoSizeRate = 0.6f          // 线路信息文本大小
private const val stationNameSizeRate = 0.9f        // 车站name1文本大小
private const val stationName2SizeRate = 0.6f       // 车站name2文本大小


@Composable
fun GuangzhouFoldedInfo(
    line: Line,
    status: MotionState,
    textMeasurer: TextMeasurer,
    modifier: Modifier
) {
    val route = line.routeList[status.routeId]

    // baseTextSize
    var bt by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .clipBorder(
                2.dp,
                DarkGray,
                RoundedCornerShape(0, 4, 4, 0)
            )
            .onPlaced { coordinates ->
                val width = coordinates.size.width
                bt = (getMaxTextSize(textMeasurer, (width * 0.3f).toInt(), "1号线") * 0.9f).toInt()
            }
    ) {
        LineInfo(line, bt, route, modifier = Modifier
            .weight(1f)
            .fillMaxWidth())
        TerminalInfo(line, status, bt, modifier = Modifier
            .weight(1f)
            .fillMaxWidth())
        NextStationInfo(status, bt, line, modifier = Modifier
            .weight(2f)
            .fillMaxWidth())
    }
}

@Composable
private fun LineInfo(
    line: Line,
    bt: Int,
    route: Route,
    modifier: Modifier
) {
    Row(
        modifier
            .drawWithContent {
                drawRect(
                    Brush.radialGradient(
                        listOf(line.color.lighter(0.3f), line.color),
                        Offset(size.width * 0.9f, 0f),
                        radius = size.height * 1.5f
                    )
                )
                drawContent()
            }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val color = line.color.backgroundColor()
        Column(
            Modifier
                .weight(2f)
                .aspectRatio(1.1f / 0.6f)
                .clipBorder(1.8.dp, color.copy(alpha = 0.5f), RoundedCornerShape(20))
                .background(line.color),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LineText(line, bt)
        }
        Column(Modifier.weight(3f), horizontalAlignment = Alignment.End) {
            if (route.branchOf != -1) RouteText("支线 / Branch", color, bt)
            if (route.expressOf != -1) RouteText("快车 / Express", color, bt)
            if (route.shuttleOf != -1) RouteText("区间车 / Shuttle", color, bt)
            if (route.isCircular) RouteText("环线 / Circular", color, bt)
        }
    }
}

@Composable
private fun TerminalInfo(
    line: Line,
    status: MotionState,
    bt: Int,
    modifier: Modifier
) {
    Column(
        modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
    ) {
        val terminal = line.terminalStop(status)
        HintText("终点站 Towards", bt)
        Column(
            Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StationText(terminal, bt)
        }
    }
}

@Composable
private fun NextStationInfo(
    status: MotionState,
    bt: Int,
    line: Line,
    modifier: Modifier
) {
    Column(modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)) {
        HintText(if (status.inStop) "本站 This station" else "下一站 Next station", bt)
        Column(
            Modifier
                .padding(horizontal = 4.dp, vertical = 10.dp)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .background(
                    line.color.copy(alpha = 0.3f),
                    RoundedCornerShape(10)
                )
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StationText(line.currStop(status), bt)
        }
    }
}

@Composable
fun RouteText(text: String, color: Color, bt: Int) {
    Text(
        text,
        style = MaterialTheme.typography.labelLarge.copy(fontSize = (bt * routeInfoSizeRate).sp),
        color = color
    )
}

@Composable
private fun HintText(text: String, bt: Int) {
    Text(
        text,
        style = MaterialTheme.typography.labelLarge.copy(fontSize = (bt * hintSizeRate).sp),
        color = DarkGray
    )
}

@Composable
fun LineText(line: Line, bt: Int) {
    val rate = textRate(line.name, 0.7f)
    Text(
        line.name,
        style = MaterialTheme.typography.labelMedium.copy(fontSize = (bt * lineNameSizeRate * rate).sp),
        textAlign = TextAlign.Center,
        color = line.color.backgroundColor()
    )
    Text(
        line.name2,
        style = MaterialTheme.typography.labelMedium.copy(fontSize = (bt * lineName2SizeRate * rate).sp),
        textAlign = TextAlign.Center,
        color = line.color.backgroundColor()
    )
}

@Composable
fun StationText(station: Station, bt: Int) {
    val rate = textRate(station.name)
    Text(
        station.name,
        style = MaterialTheme.typography.labelMedium.copy(fontSize = (bt * stationNameSizeRate * rate).sp),
        textAlign = TextAlign.Center
    )
    Text(
        station.name2,
        style = MaterialTheme.typography.labelMedium.copy(fontSize = (bt * stationName2SizeRate).sp),
        textAlign = TextAlign.Center
    )
}

private fun Modifier.clipBorder(width: Dp, color: Color, shape: Shape) =
    clip(shape).border(width, color, shape)