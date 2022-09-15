package studio.eyesthetics.tetacomposelesson.ui

sealed class Screen {
    data class Schedule(val date: String) : Screen()
    object Calendar : Screen()
}