package studio.eyesthetics.tetacomposelesson.ui.custom.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CalendarItemView(item: CalendarItem, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(modifier = Modifier
        .width(56.dp)
        .height(48.dp)
        .padding(horizontal = 8.dp, vertical = 4.dp)
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = {
                if (item.status != CalendarItemStatus.EMPTY) {
                    item.status = CalendarItemStatus.ACTIVE
                    onClick.invoke()
                }
            }
        )
        .background(
            color = if (item.status == CalendarItemStatus.ACTIVE) MaterialTheme.colors.secondary else MaterialTheme.colors.background,
            shape = if (item.status == CalendarItemStatus.ACTIVE) MaterialTheme.shapes.large else RectangleShape
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.dayOfMonth.toString(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            color = if (item.status == CalendarItemStatus.ACTIVE) MaterialTheme.colors.background else item.color
        )
    }
}