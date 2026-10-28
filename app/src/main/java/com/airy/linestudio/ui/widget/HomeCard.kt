package com.airy.linestudio.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.util.firstStation
import com.airy.line.util.get
import com.airy.line.util.lastStation
import com.airy.linestudio.presentation.home.LocalColor
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.repository.utils.color

@Composable
fun LineMapCard(
    lineMap: LineMap,
    chosenMap: LineMap?,
    onLineMapSelected: (LineMap) -> Unit,
) {
    val (mainText, subText) = remember(lineMap.name) {
        val splitIndex = lineMap.name.indexOf('(').takeIf { it != -1 } ?: lineMap.name.indexOf('（')

        if (splitIndex != -1) {
            lineMap.name.substring(0, splitIndex) to lineMap.name.substring(splitIndex)
        } else {
            lineMap.name to null
        }
    }

    SelectionCard(
        cornerPercent = 10,
        isSelected = chosenMap == lineMap,
        onSelect = { onLineMapSelected(lineMap) }) { modifier ->
        Column(modifier.padding(horizontal = 10.dp).widthIn(min = 120.dp, max = 160.dp)){
            Row(verticalAlignment = Alignment.Bottom) {
                Text(mainText, style = MaterialTheme.typography.titleLarge, maxLines = 1)
                subText?.let { Text(it, style = MaterialTheme.typography.titleSmall, maxLines = 1) }
            }
            Text("共计${lineMap.lines.size}条线路", style = MaterialTheme.typography.labelMedium)
        }
    }
}

@Composable
fun LineCard(line: Line, chosenLine: Line?, onLineSelected: (Line) -> Unit) {
    SelectionCard(
        cornerPercent = 50,
        isSelected = chosenLine == line,
        onSelect = { onLineSelected(line) }
    ) { modifier ->
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.padding(start = 4.dp).background(line.color, CircleShape).size(16.dp)) { }
            Text(
                line.name,
                modifier = Modifier.padding(horizontal = 4.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun RouteCard(line: Line, routeId: Int, chosenRouteId: Int, onRouteSelected: (Int) -> Unit) {
    val (destinationText, descriptionText) = remember(line, routeId) {
        val route = line[routeId]
        val firstStop = line.firstStation(routeId).name
        val terminalStop = line.lastStation(routeId).name
        val routeText = "${if (route.shuttleOf != -1) "区间" else ""} " +
                "${if (route.expressOf != -1) "快线" else ""} " +
                "${if (route.branchOf != -1) "支线" else ""} " +
                if (route.isCircular) "环线" else ""
        "$firstStop ->\n$terminalStop" to routeText
    }

    SelectionCard(
        cornerPercent = 50,
        isSelected = routeId == chosenRouteId,
        onSelect = { onRouteSelected(routeId) }) { modifier ->
        Row(modifier.height(IntrinsicSize.Min), verticalAlignment = Alignment.CenterVertically) {
            Text(descriptionText, style = MaterialTheme.typography.titleSmall)
            VerticalDivider(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxHeight(),
                color = line.color,
                thickness = 6.dp
            )
            Text(
                destinationText,
                modifier = Modifier.padding(start = 4.dp, end = 8.dp),
                style = MaterialTheme.typography.labelSmall,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun StyleCard(style: PidsStyle, chosenStyle: PidsStyle?, onStyleSelected: (PidsStyle) -> Unit) {
    SelectionCard(10, style == chosenStyle, { onStyleSelected(style) }) { modifier ->
        Column(modifier = modifier.padding(horizontal = 10.dp).widthIn(min = 120.dp, max = 160.dp)) {
            Text(
                text = style.title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1
            )
            Text(
                text = style.description,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 1
            )
        }
    }
}

@Composable
fun SelectionCard(
    cornerPercent: Int,
    isSelected: Boolean,
    onSelect: () -> Unit,
    content: @Composable ColumnScope.(Modifier) -> Unit
) {
    val color = LocalColor.current
    Column {
        Card (
            modifier = Modifier
                .clickable(enabled = true, onClick = onSelect)
                .padding(end = 10.dp)
                .widthIn(min = 50.dp),
            shape = RoundedCornerShape(cornerPercent),
            colors = CardDefaults.cardColors().copy(containerColor = if (isSelected) color.background else Color.White),
            border = BorderStroke(2.dp, if (isSelected) color.homeColor else Color.LightGray),
            content = { content(Modifier.padding(4.dp)) }
        )
    }
}
