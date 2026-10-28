package com.airy.linedownloader.util

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType

fun String.toPinyin(): String {
    val pinyin = PinyinHelper.toHanYuPinyinString(
        this,
        HanyuPinyinOutputFormat().apply { toneType = HanyuPinyinToneType.WITHOUT_TONE },
        "",
        true
    )
    return pinyin[0].uppercaseChar() + pinyin.substring(1)
}

fun String.toColorLongValue() : Long{
    val src = if (this.startsWith("0x")) substring(2) else this
    return 0xFF000000L or src.toLong(16)
}