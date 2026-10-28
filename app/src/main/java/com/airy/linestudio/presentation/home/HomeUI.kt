package com.airy.linestudio.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Route
import com.airy.line.test.guangzhouLineMap
import com.airy.line.test.gz_line10
import com.airy.linestudio.presentation.display.utils.colorOfToday
import com.airy.linestudio.presentation.display.utils.greyWithGamma
import com.airy.linestudio.presentation.display.utils.lighter
import com.airy.linestudio.presentation.home.data.styleList
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.ui.widget.HomeRouteSelection
import com.airy.linestudio.ui.widget.HomeRowEnd
import com.airy.linestudio.ui.widget.HomeStyleSelection

data class HomeColor(
    val homeColor: Color = colorOfToday,
    val lighter: Color = homeColor.lighter(0.3f),
    val background: Color = homeColor.lighter(0.1f)
)

val LocalColor = compositionLocalOf { HomeColor() }

@Composable
fun HomeScreen(vm: HomeViewModel, onStart: ()->Unit) {
    val state = HomeState()
    HomeUI(state) { lineMap, line, routeId, style ->
        vm.start(lineMap, line, routeId, style)
        onStart()
    }
}

@Composable
fun HomeUI(state: HomeState, onSelected: (LineMap?, Line, Int, PidsStyle) -> Unit) {
    val color by remember { mutableStateOf(HomeColor()) }

    var selectedLineMap: LineMap? by remember { mutableStateOf(state.lineMapList.firstOrNull()) }
    var selectedLine: Line? by remember { mutableStateOf(selectedLineMap?.lines?.values?.firstOrNull()) }
    var selectedRoute: Int by remember { mutableIntStateOf(0) }
    var selectedStyle: PidsStyle by remember { mutableStateOf(styleList.first()) }

    CompositionLocalProvider(LocalColor provides color) {
        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                HomeRouteSelection(
                    lineMapList = state.lineMapList,
                    lineList = state.lineList,
                    selectedLineMap = selectedLineMap,
                    selectedLine = selectedLine,
                    selectedRoute = selectedRoute,
                    onLineMapSelected = {
                        if (selectedLineMap != it) {
                            selectedLineMap = it
                            selectedLine = selectedLineMap?.lines?.values?.firstOrNull()
                            selectedRoute = 0
                        }
                    },
                    onLineSelected = {
                        if (selectedLine != it) {
                            selectedLine = it
                            selectedRoute = 0
                        }
                    },
                    onRouteSelected = { selectedRoute = it }
                )
                HomeStyleSelection(selectedStyle) { selectedStyle = it }
                HomeRowEnd()
            }
            IconButton(
                modifier = Modifier
                    .padding(40.dp)
                    .shadow(6.dp, CircleShape)
                    .align(Alignment.BottomEnd)
                    .background(color.homeColor, CircleShape)
                    .size(48.dp),
                onClick = { onSelected(selectedLineMap, selectedLine!!, selectedRoute, selectedStyle) }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, "Next", modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Preview(device = "spec:parent=pixel_9,orientation=landscape")
@Composable
private fun PreviewHomeScreen() {
    HomeUI(
        HomeState(
            lineMapList = listOf(
                guangzhouLineMap,
                LineMap("测试", "", mapOf("1" to Line("1", "测试线")))
            ),
            lineList = listOf(Line("1", "测试线"), gz_line10),
        ),
        { _, _, _, _ -> }
    )
}