package com.airy.linestudio.presentation.display.guangzhou

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import com.airy.line.test.fs_tnh1
import com.airy.line.test.guangzhouLineMap
import com.airy.linestudio.presentation.display.guangzhou.widget.GuangzhouFoldedInfo
import com.airy.linestudio.presentation.display.guangzhou.widget.GuangzhouFoldedMap
import com.airy.linestudio.repository.motion.MotionState

@Composable
fun GuangzhouDisplay(state: MotionState) {
    val textMeasurer = rememberTextMeasurer()
    state.line?.let { line ->
        Row {
            GuangzhouFoldedInfo(line, state, textMeasurer, Modifier.weight(1f).fillMaxHeight())
            GuangzhouFoldedMap(line, state, textMeasurer, Modifier.weight(4f).fillMaxHeight())
        }
    }
}
