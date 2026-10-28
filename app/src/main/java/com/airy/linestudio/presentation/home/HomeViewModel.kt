package com.airy.linestudio.presentation.home

import androidx.lifecycle.ViewModel
import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.line.Route
import com.airy.linestudio.repository.linedata.LineDataRepository
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.repository.motion.MotionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val lineDataRepository: LineDataRepository,
    private val motionRepository: MotionRepository
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun start(lineMap: LineMap?, line: Line, routeId: Int, style: PidsStyle) {
        motionRepository.startTrip(lineMap, line, routeId, 0, style)
    }

}