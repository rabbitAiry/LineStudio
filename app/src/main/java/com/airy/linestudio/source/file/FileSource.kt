package com.airy.linestudio.source.file

import android.content.Context
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.util.decodeFromJsonString
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

/**
 * TODO v2.0:
 * - 支持使用FileKit选择并导入线路文件
 * - 兼容KMP项目，将Asset资源统一放在commonMain/resources/目录下
 *
 */
@Singleton
class FileSource @Inject constructor(
    @ApplicationContext val context: Context
) {

    /**
     * 读取并去重
     */
    fun getAllLineMap(): Pair<List<LineMap>, List<Line>> {
        val fromAsset = getLineFileFromAsset()
        val fromLocal = getLineFileFromLocal()
        return (fromAsset.first + fromLocal.first) to (fromAsset.second + fromLocal.second)
    }

    /**
     * 读取LineMap文件 >> 检查是否正确 >> 将文件保存到私有目录中
     */
    fun getLineFileWithLocation(location: String): Pair<List<LineMap>, List<Line>> {
        return emptyList<LineMap>() to emptyList<Line>()
    }

    private fun getLineFileFromAsset(): Pair<List<LineMap>, List<Line>> {
        val mapList: List<LineMap>? = getFileFromAsset("lineMaps")?.map { decodeFromJsonString(it) }
        val lineList: List<Line>? = getFileFromAsset("lines")?.map { decodeFromJsonString(it) }
        return (mapList ?: emptyList()) to (lineList ?: emptyList())
    }

    /**
     * 从私有目录中读取文件 >> 检查是否正确
     */
    fun getLineFileFromLocal(): Pair<List<LineMap>, List<Line>> {
        return emptyList<LineMap>() to emptyList<Line>()
    }

    private fun getFileFromAsset(dirName: String): List<String>? =
        context.assets.list(dirName)?.mapNotNull {
            val inputStream = context.assets.open("LineMap.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val content = StringBuilder()
            while (true) {
                val line = reader.readLine()
                if (line == null) break
                else content.append(line)
            }
            reader.close()
            content.toString()
        }
}