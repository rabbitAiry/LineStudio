package com.airy.linedownloader

import com.airy.linedownloader.data.foshanRenameMap
import com.airy.linedownloader.data.guangzhouMap
import java.io.File

private fun replaceInFile(filePath: String, replaceList: Map<String, String>) {
    val file = File(filePath)
    var content = file.readText()
    for (item in replaceList){
        content = content.replace(item.key, item.value)
    }
    file.writeText(content)
}

fun main() {
    replaceInFile("广州.txt", guangzhouMap)
}