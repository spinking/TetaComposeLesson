package studio.eyesthetics.tetacomposelesson.ui.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorRedMonza
import java.util.*

@Composable
fun ScheduleScreen(
    date: Date
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorRedMonza)
    )
}