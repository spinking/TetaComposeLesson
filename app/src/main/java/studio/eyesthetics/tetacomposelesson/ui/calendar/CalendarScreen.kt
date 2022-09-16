package studio.eyesthetics.tetacomposelesson.ui.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import studio.eyesthetics.tetacomposelesson.R
import studio.eyesthetics.tetacomposelesson.extensions.clearHours
import studio.eyesthetics.tetacomposelesson.ui.Screen
import studio.eyesthetics.tetacomposelesson.ui.custom.buttons.PrimaryButton
import studio.eyesthetics.tetacomposelesson.ui.custom.calendar.CalendarView
import java.util.*

@Composable
fun CalendarScreen(
    onChangeScreen: (Screen) -> Unit
) {
    val isButtonEnabled = remember { mutableStateOf(false) }
    val activeDate = remember { mutableStateOf(Calendar.getInstance().clearHours().time) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
    ) {
        CalendarView(
            startDate = Calendar.getInstance().clearHours().time,
            onDateChanged = {
                activeDate.value = it
                isButtonEnabled.value = true
            }
        )

        Spacer(modifier = Modifier.height(26.dp))

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            buttonText = stringResource(R.string.caneldar_accept_button),
            isEnabled = isButtonEnabled.value,
            onClick = {
                onChangeScreen.invoke(Screen.Schedule(date = activeDate.value))
            }
        )
    }
}