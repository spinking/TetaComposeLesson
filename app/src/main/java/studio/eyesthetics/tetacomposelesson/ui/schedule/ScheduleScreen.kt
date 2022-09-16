package studio.eyesthetics.tetacomposelesson.ui.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import studio.eyesthetics.tetacomposelesson.R
import studio.eyesthetics.tetacomposelesson.extensions.clearHours
import studio.eyesthetics.tetacomposelesson.extensions.formatToString
import studio.eyesthetics.tetacomposelesson.ui.custom.items.data.ScheduleItem
import studio.eyesthetics.tetacomposelesson.ui.custom.items.ScheduleItemView
import studio.eyesthetics.tetacomposelesson.ui.custom.items.ScheduleTitle
import studio.eyesthetics.tetacomposelesson.ui.custom.toolbars.DefaultToolBar
import studio.eyesthetics.tetacomposelesson.utils.Utils
import java.util.*

@Composable
fun ScheduleScreen(
    date: Date,
    onBackPressed: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val items = remember { mutableStateListOf<ScheduleItem>() }

    LaunchedEffect(key1 = Unit) {
        scope.launch {
            val schedule = mutableListOf<ScheduleItem>()
            val calendar = Calendar.getInstance().clearHours()
            for (i in 0..23) {
                schedule.add(
                    ScheduleItem(
                        time = calendar.time,
                        action = Utils.getRandomScheduleAction()
                    )
                )
                calendar.add(Calendar.HOUR, 1)
            }
            items.addAll(schedule)
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
    ) {
        DefaultToolBar(
            label = "${stringResource(R.string.schedule_label)} ${date.formatToString()}",
            onBackPressed = {
                onBackPressed.invoke()
            }
        )

        LazyColumn() {
            items(items = items) {
                when (it.time.hours) {
                    0 -> ScheduleTitle(title = stringResource(R.string.schedule_night))
                    6 -> ScheduleTitle(title = stringResource(R.string.shedule_morning))
                    12 -> ScheduleTitle(title = stringResource(R.string.shedule_day))
                    18 -> ScheduleTitle(title = stringResource(R.string.schedule_evening))
                }
                ScheduleItemView(item = it)
            }
        }
    }
}