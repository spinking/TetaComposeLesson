package studio.eyesthetics.tetacomposelesson.ui.custom.calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import studio.eyesthetics.tetacomposelesson.extensions.clearHours
import studio.eyesthetics.tetacomposelesson.extensions.formatToYearAndMonth
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorWhite
import studio.eyesthetics.tetacomposelesson.R
import studio.eyesthetics.tetacomposelesson.extensions.getDayOfWeek
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorGrayChateau
import java.util.*

@Composable
fun CalendarView(
    startDate: Date?,
    onDateChanged: (Date) -> Unit,
    modifier: Modifier = Modifier
) {
    val calendar = Calendar.getInstance(Locale.getDefault()).clearHours()
    val scope = rememberCoroutineScope()
    val cells = remember { mutableStateOf(emptyList<CalendarItem>()) }
    val selectedItem = remember { mutableStateOf<CalendarItem?>(null) }
    val selectedMonth = remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    val monthTitle = remember { mutableStateOf(calendar.formatToYearAndMonth()) }

    val todayColor = MaterialTheme.colors.secondary
    val defaultColor = MaterialTheme.colors.onPrimary
    val emptyColor = MaterialTheme.colors.background

    LaunchedEffect(key1 = selectedMonth.value) {
        scope.launch {
            calendar.set(Calendar.MONTH, selectedMonth.value)
            monthTitle.value = calendar.formatToYearAndMonth()
            val items = mutableListOf<CalendarItem>()
            val monthDayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            calendar.set(Calendar.DAY_OF_MONTH, monthDayCount)
            val endEmptyDays = 7 - calendar.getDayOfWeek()
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            val startEmptyDays = calendar.getDayOfWeek() - 1

            val maxCalendarVisibleColumn = startEmptyDays + monthDayCount
            val maxCalendarColumn = maxCalendarVisibleColumn + endEmptyDays

            var index = 1
            while (items.size < maxCalendarColumn) {
                calendar.timeInMillis
                if (index <= startEmptyDays || index >= maxCalendarVisibleColumn) {
                    items.add(
                        CalendarItem(
                            id = UUID.randomUUID().toString(),
                            dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH),
                            date = calendar.time,
                            status = CalendarItemStatus.EMPTY,
                            color = emptyColor
                        )
                    )
                } else {
                    items.add(
                        CalendarItem(
                            id = UUID.randomUUID().toString(),
                            dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH),
                            date = calendar.time,
                            status = if (selectedItem.value?.date?.time == calendar.timeInMillis)
                                CalendarItemStatus.ACTIVE
                            else
                                CalendarItemStatus.DEFAULT,
                            color = when {
                                startDate?.time == calendar.timeInMillis -> todayColor
                                index % 7 == 6 || index % 7 == 0 -> ColorGrayChateau
                                else -> defaultColor
                            }
                        )
                    )
                    if (selectedItem.value?.date?.time == calendar.timeInMillis) selectedItem.value = items.last()
                    calendar.add(Calendar.DAY_OF_MONTH, 1)
                }
                index++
            }
            cells.value = items
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorWhite)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
        ) {
            Text(
                text = monthTitle.value,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                IconButton(
                    onClick = {
                        selectedMonth.value--
                    }) {
                    Image(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = null)
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        selectedMonth.value++
                    }) {
                    Image(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = null, modifier = Modifier.rotate(180f))
                }
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = CombinedModifier(modifier, Modifier.fillMaxWidth())
        ) {
            items(items = cells.value, key = { it.id }) {
                CalendarItemView(item = it) {
                    selectedItem.value?.let { item ->
                        item.status = CalendarItemStatus.DEFAULT
                    }
                    selectedItem.value = it
                    onDateChanged.invoke(it.date)
                }
            }
        }
    }
}