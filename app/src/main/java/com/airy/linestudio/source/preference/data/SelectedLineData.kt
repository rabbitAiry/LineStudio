package com.airy.linestudio.source.preference.data

import com.airy.linestudio.repository.data.PidsStyle

/**
 * @param lastSelectedLineName 线网名/线路名
 */
data class SelectedLineData(
    val lastSelectedLineName: String? = null,
    val lastSelectedStyle: PidsStyle? = null,
)