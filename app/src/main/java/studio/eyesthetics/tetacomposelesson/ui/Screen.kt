package studio.eyesthetics.tetacomposelesson.ui

import java.util.*

sealed class Screen {
    data class Schedule(val date: Date) : Screen()
    object Calendar : Screen()
}