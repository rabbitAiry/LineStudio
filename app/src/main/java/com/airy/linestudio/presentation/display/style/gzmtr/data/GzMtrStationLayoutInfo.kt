package com.airy.linestudio.presentation.display.style.gzmtr.data

import androidx.compose.ui.text.TextLayoutResult

data class GzMtrStationLayoutInfo(
    val stationIdLayout: TextLayoutResult,
    val stationNameLayout: TextLayoutResult,
    val stationNameEnLayout: TextLayoutResult,
    val interchanges: List<InterchangeLayoutInfo>
)