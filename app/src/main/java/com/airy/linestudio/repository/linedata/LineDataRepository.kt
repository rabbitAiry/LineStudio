package com.airy.linestudio.repository.linedata

import com.airy.linestudio.source.file.FileSource
import com.airy.linestudio.source.preference.PreferenceSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LineDataRepository @Inject constructor(
    private val fileSource: FileSource,
    private val preferenceSource: PreferenceSource
) {
    private var _state = MutableStateFlow(LineDataState())
    val state = _state.asStateFlow()

    init {
        val res = fileSource.getAllLineMap()
        _state.update {
            LineDataState(res.first, res.second)
        }
    }

    fun addLineFile(location: String){
        val res = fileSource.getLineFileWithLocation(location)
        _state.update {
            it.copy(lineMapList = it.lineMapList + res.first, lineList = it.lineList + res.second)
        }
    }
}