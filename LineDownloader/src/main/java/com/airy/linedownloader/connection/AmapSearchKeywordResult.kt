package com.airy.linedownloader.connection

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive

const val defaultColor = "0xFF206CEF"  // 蓝色

/**
 * 高德地图公交关键字查询结果
 * @param status 状态码, 0 表示失败；1 表示成功
 * @param info 状态值的说明，如果成功返回"ok"，错误原因见[https://lbs.amap.com/api/webservice/guide/tools/info]
 * @param infocode 状态码的详细说明，具体信息见[https://lbs.amap.com/api/webservice/guide/tools/infocode]
 */
@Serializable
data class AmapSearchKeywordResult(
    val status: String,
    val info: String,
    val infocode: String,
    val buslines: List<AmapKeywordLineResult>
)

/**
 * 高德地图公交查询结果
 * @param id 公交线路ID
 * @param type 公交线路类型
 * @param name 公交线路名称
 * @param status 线路状态, 0-停运/1-正常/2-规划中/3-在建
 */
@Serializable
data class AmapKeywordLineResult(
    val id: String,
    val type: String,
    val name: String,
    val status: String,
    @Serializable(with = AmapColorSerializer::class) val uicolor: String,
    val busstops: List<AmapIdLineStopResult>
)

/**
 * 高德地图公交id查询结果
 * @param id 站点ID
 * @param name 站点名
 * @param location 站点经纬度(如"113.265896,22.988184")
 * @param sequence 站点序号
 */
@Serializable
data class AmapIdLineStopResult(
    val id: String,
    val name: String,
    val location: String,
    val sequence: String,
)


object AmapColorSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("AmapColor", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): String {
        val jsonDecoder = decoder as? JsonDecoder ?: error("Can only deserialize JSON")
        return when (val element = jsonDecoder.decodeJsonElement()) {
            is JsonPrimitive -> element.content
            else -> defaultColor
        }
    }

    override fun serialize(encoder: Encoder, value: String) {
        encoder.encodeString(value)
    }
}