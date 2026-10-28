package com.airy.line

import kotlinx.serialization.Serializable

/**
 * 线路角度下的站点
 * 如: 3号线天河客运站 {"id":"16","name":"天河客运站","otherNames":["Tianhe Coach Terminal"]}
 *
 * @param id 当前线路上的站点编号（并非所有站点都有id，可空）
 * @param name 站名 (不同线路但是站名相同的情况下视为线路之间可换乘)
 * @param enable 是否停靠此站点 (默认为停靠)
 * @param interchanges 换乘，内容是线路的id
 * @param exitInterchanges 出站换乘，内容是站点名称 - 线路的id
 */
@Serializable
data class Station(
    val id: String = "",
    val name: String,
    val name2: String = "",
    val location: Location? = null,
    val enable: Boolean = true,
    val interchanges: List<String> = emptyList(),
    val exitInterchanges: List<Pair<String, String>> = emptyList(),
)