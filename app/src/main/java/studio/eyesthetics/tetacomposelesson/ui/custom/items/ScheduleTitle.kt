package studio.eyesthetics.tetacomposelesson.ui.custom.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleTitle(
    title: String
) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    )
}