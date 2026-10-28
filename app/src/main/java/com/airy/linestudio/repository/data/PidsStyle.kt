package com.airy.linestudio.repository.data

enum class PidsStyle(val title: String, val description: String = "") {
    GuangzhouMetroLine("直线风格"),
    GuangzhouMetroCurve("半环风格");

    fun getGroup(): PidsGroup{
        for (group in PidsGroup.entries){
            if (group.list.contains(this)) return group
        }
        throw IllegalStateException("can't find PidsGroup")
    }
}

enum class PidsGroup(val list: List<PidsStyle>){
    GuangzhouMetro(listOf(PidsStyle.GuangzhouMetroLine, PidsStyle.GuangzhouMetroCurve))
}