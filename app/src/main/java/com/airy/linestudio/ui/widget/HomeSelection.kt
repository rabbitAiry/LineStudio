package com.airy.linestudio.ui.widget

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Route
import com.airy.linestudio.presentation.home.data.styleList
import com.airy.linestudio.repository.data.PidsStyle

@Composable
fun ColumnScope.HomeRouteSelection(
    lineMapList: List<LineMap>,
    lineList: List<Line>,
    selectedLineMap: LineMap?,
    selectedLine: Line?,
    selectedRoute: Int,
    onLineMapSelected: (LineMap?) -> Unit,
    onLineSelected: (Line?) -> Unit,
    onRouteSelected: (Int) -> Unit,
) {
    var showLineMap by remember { mutableStateOf(true) }
    HomeRowHeader { modifier ->
        HomeTitleOptions(
            modifier = modifier,
            option1 = "线网",
            option2 = "线路",
            isOption1 = showLineMap,
            onSelect = {
                showLineMap = it
                if (showLineMap) onLineMapSelected(lineMapList.firstOrNull())
                else {
                    onLineMapSelected(null)
                    onLineSelected(lineList.firstOrNull())
                }
            }
        )
    }
    HomeRowContent { modifier ->
        if (showLineMap){
            LazyRow(modifier) {
                items(lineMapList){
                    LineMapCard(
                        lineMap = it,
                        chosenMap = selectedLineMap,
                        onLineMapSelected = onLineMapSelected
                    )
                }
            }
        } else {
            LazyRow(modifier) {
                items(lineList) { item -> LineCard(item, selectedLine, onLineSelected) }
            }
        }
    }
    selectedLineMap?.let { lineMap ->
        HomeRowContent(1) { modifier ->
            LazyRow(modifier)  {
                items(lineMap.lines.values.toList()){ item ->
                    LineCard(item, selectedLine, onLineSelected)
                }
            }
        }
    }
    selectedLine?.let { line ->
        HomeRowContent(2) { modifier ->
            LazyRow(modifier)  {
                itemsIndexed(line.routeList) { index, item ->
                    RouteCard(line, index, selectedRoute, onRouteSelected)
                }
            }
        }
    }
}

@Composable
fun ColumnScope.HomeStyleSelection(
    selectedStyle: PidsStyle,
    onSelected: (PidsStyle) -> Unit
) {
    HomeRowHeader { modifier -> HomeTitleText("风格", modifier) }
    HomeRowContent { modifier ->
        LazyRow(modifier)  {
            items(styleList) { item ->
                StyleCard(item, selectedStyle, onSelected)
            }
        }
    }
}