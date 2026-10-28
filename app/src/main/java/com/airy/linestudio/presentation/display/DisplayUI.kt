package com.airy.linestudio.presentation.display

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.airy.line.test.fs_tnh1
import com.airy.line.test.guangzhouLineMap
import com.airy.linestudio.presentation.display.guangzhou.GuangzhouDisplay
import com.airy.linestudio.repository.data.PidsGroup
import com.airy.linestudio.repository.data.PidsStyle
import com.airy.linestudio.repository.motion.MotionState

@Composable
fun DisplayScreen(viewModel: DisplayViewModel) {
    val state = viewModel.state.collectAsState().value

    when(state.style.getGroup()){
        PidsGroup.GuangzhouMetro -> GuangzhouDisplay(state)
    }
}

@Preview(device = "spec:width=3000px,height=1000px,orientation=landscape")
@Composable
private fun PreviewDisplayScreen() {
    GuangzhouDisplay(MotionState(
        line = fs_tnh1,
        lineMap = guangzhouLineMap,
    ))
}

/**
 * TODO
 * 1. 建立Preview
 * 2. 验证广州风格显示是否正确
 * 3. 设计双击进入控制面板
 * 4. 增加日志
 */