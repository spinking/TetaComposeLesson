package studio.eyesthetics.tetacomposelesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import studio.eyesthetics.tetacomposelesson.ui.Screen
import studio.eyesthetics.tetacomposelesson.ui.calendar.CalendarScreen
import studio.eyesthetics.tetacomposelesson.ui.schedule.ScheduleScreen
import studio.eyesthetics.tetacomposelesson.ui.theme.TetaComposeLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetaComposeLessonTheme {
                //Navigation imitation
                val currentScreen: MutableState<Screen> = remember { mutableStateOf(Screen.Calendar) }
                when(currentScreen.value) {
                    is Screen.Calendar -> CalendarScreen {
                        currentScreen.value = it
                    }
                    is Screen.Schedule -> {
                        ScheduleScreen(
                            date = (currentScreen.value as Screen.Schedule).date,
                            onBackPressed = {
                                currentScreen.value = Screen.Calendar
                            }
                        )
                    }
                }

                //Imitation of back navigation
                BackHandler(
                    enabled = currentScreen.value != Screen.Calendar
                ) {
                    currentScreen.value = Screen.Calendar
                }
            }
        }
    }
}