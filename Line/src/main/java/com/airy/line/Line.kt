package com.airy.line

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive


private const val defaultLineColor = 0xff3e79f5

/**
 * 线路
 *
 * @param id 线路id
 * @param name 线路名称
 * @param name2 线路名称（外语）
 * @param routeList 交路列表
 * @param colorValue 颜色（如0xFFAABBCC）
 */
@Serializable
data class Line(
    val id: String = "",
    val name: String,
    val name2: String = "",
    val routeList: List<Route> = emptyList(),
    val stationMap: Map<String, Station> = emptyMap(),
    @Serializable(with = HexColorSerializer::class) val colorValue: Long = defaultLineColor
)

object HexColorSerializer : KSerializer<Long> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("HexColor", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Long {
        val value = decoder.decodeString()
        return if (value.startsWith("0x") || value.startsWith("0X")) {
            value.substring(2).toLong(16)
        } else {
            value.toLong(16)
        }
    }

    override fun serialize(encoder: Encoder, value: Long) {
        encoder.encodeString("0x${value.toString(16).uppercase().padStart(8, '0')}")
    }
}