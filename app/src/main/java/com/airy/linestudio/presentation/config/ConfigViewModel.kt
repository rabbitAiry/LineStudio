package com.airy.linestudio.presentation.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airy.linestudio.repository.linedata.LineDataRepository
import com.airy.linestudio.repository.motion.MotionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val lineDataRepository: LineDataRepository,
    private val motionRepository: MotionRepository
): ViewModel() {
    private val _state = MutableStateFlow(ConfigState())
    val state
        get() = _state.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _state.value
        )



}