package com.airy.linestudio.repository.motion

import com.airy.line.Line
import com.airy.line.LineMap
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.source.preference.PreferenceSource
import com.airy.linestudio.source.file.FileSource
import com.airy.linestudio.source.location.MapSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 负责记录车辆运行数据
 */
@Singleton
class MotionRepository @Inject constructor(
    private val scope: CoroutineScope,
    private val mapSource: MapSource,
    private val fileSource: FileSource,
    private val preferenceSource: PreferenceSource
) {
    private var _state = MutableStateFlow(MotionState())
    val state get() = _state.asStateFlow()

    fun startTrip(lineMap: LineMap?, line: Line, routeId: Int, startStationId: Int, style: PidsStyle){
        _state.update { it.copy(style = style, lineMap = lineMap, line = line, routeId = routeId, stationId = startStationId) }
        scope.launch {
            preferenceSource.saveLastSelected(lineMap, line, style)
            if (preferenceSource.getGeofencing()){
                locationListening()
            }
        }
    }

    /**
     * 站a到达 -> 站a出发 -> 站b到达 -> ...
     */
    fun next(){
        if (_state.value.isLast) return
        if (_state.value.inStop) _state.update { it.copy(inStop = true) }
        else _state.update { it.copy(stationId = it.stationId + 1) }
    }

    fun finish(){
        _state.update { MotionState() }
    }

    private var locationJob: Job? = null
    private fun locationListening(){
        locationJob = scope.launch(Dispatchers.IO) {
            mapSource.geoLocationListening()
        }
    }

}