package com.airy.linestudio.presentation.display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airy.linestudio.repository.linedata.LineDataRepository
import com.airy.linestudio.repository.motion.MotionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DisplayViewModel @Inject constructor(
    private val motionRepository: MotionRepository
): ViewModel() {
    val state get() = motionRepository.state

}