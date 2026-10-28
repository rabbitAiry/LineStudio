package com.airy.line

import kotlinx.serialization.Serializable

/**
 * @param stationList 交路沿线站点id
 * @param expressOf 当交路为快车时，该数字指向交路列表中对应的慢车，否则设为-1
 * @param shuttleOf 当交路为区间车时，该数字指向交路列表中对应的完整交路，否则设为-1
 * @param branchOf 该数字指向交路列表中令一分支交路，在绘制线路图时会将两段，线路一齐绘制，不设置时设为-1
 */
@Serializable
data class Route(
    val stationList: List<String>,
    val expressOf: Int = -1,
    val shuttleOf: Int = -1,
    val branchOf: Int = -1,
    val isCircular: Boolean = false
)
