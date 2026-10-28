package com.airy.linestudio.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.airy.linestudio.presentation.home.LocalColor


private const val stationSize = 50f
private const val lineWidth = stationSize * 0.75f

@Composable
fun HomeRowHeader(content: @Composable (Modifier) -> Unit) {
    val color = LocalColor.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(
            modifier = Modifier
                .padding(end = 10.dp)
                .size(stationSize.dp)
        ) {
            drawLine(
                color = color.homeColor,
                start = Offset(size.width / 2, 0f),
                end = Offset(size.width / 2, size.height),
                strokeWidth = lineWidth
            )
            drawCircle(
                color = Color.DarkGray,
                radius = stationSize
            )
            drawCircle(
                color = Color.White,
                radius = stationSize * 0.6f
            )
        }
        content(Modifier.padding(top = 10.dp))
    }
}

@Composable
fun HomeRowContent(darker: Int = 0, content: @Composable (Modifier) -> Unit) {
    val color = LocalColor.current
    val background = remember(darker) {
        when (darker) {
            1 -> Color.LightGray
            2 -> Color.LightGray.copy(alpha = 0.4f)
            else -> Color.White
        }
    }

    Layout(
        modifier = Modifier.background(background),
        content = {
            Canvas(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .fillMaxHeight()
                    .width(stationSize.dp)
            ) {
                drawLine(
                    color = color.homeColor,
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = lineWidth
                )
            }
            content(Modifier.padding(vertical = 6.dp))
        }
    ) { measurables, constraints ->
        val placeable2 = measurables.getOrNull(1)?.measure(constraints)
        val height = placeable2?.height ?: 1
        val placeable1 = measurables[0].measure(constraints.copy(maxHeight = height))

        var xPosition = 0
        layout(constraints.maxWidth, height){
            listOfNotNull(placeable1, placeable2).forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = 0)
                xPosition += placeable.width
            }
        }
    }
}

@Composable
fun HomeRowEnd() {
    val color = LocalColor.current
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(stationSize.dp)) {
            val path = Path().apply {
                val startX = size.width / 2
                val endY = size.height * 0.75f
                moveTo(startX, 0f)
                cubicTo(startX, size.height / 6, size.width / 6, endY, 0f, endY)
            }
            drawPath(path, color.homeColor, style = Stroke(width = lineWidth))
        }
    }
}


@Composable
fun HomeTitleText(title: String, modifier: Modifier) {
    Text(title, modifier = modifier, style = MaterialTheme.typography.titleLarge)
}

@Composable
fun HomeTitleOptions(
    modifier: Modifier,
    option1: String,
    option2: String,
    isOption1: Boolean,
    onSelect: (Boolean) -> Unit
) {
    Row(modifier = modifier.border(2.dp, Color.Black, CircleShape)) {
        HomeTitleOptionsText(option1, isOption1) { onSelect(true) }
        HomeTitleOptionsText(option2, !isOption1) { onSelect(false) }
    }
}

@Composable
fun HomeTitleOptionsText(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val color = LocalColor.current
    Text(
        text = text,
        modifier = Modifier
            .padding(2.dp)
            .background(if (isSelected) color.lighter else Color.Transparent, CircleShape)
            .padding(vertical = 4.dp, horizontal = 10.dp)
            .clickable { onClick() },
        style = MaterialTheme.typography.titleMedium
    )
}


@Composable
fun LineListItem(
    header: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column {

    }
}