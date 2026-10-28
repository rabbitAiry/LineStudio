package com.airy.linestudio.repository.motion.data

import com.airy.line.Location

data class MotionAnalytics(
    val currSpeed: Float = 0f,
    val avgSpeed: Float = 0f,
    val distance: Float = 0f,
    val time: Long = 0,
    val locationList: List<Location> = emptyList()
)