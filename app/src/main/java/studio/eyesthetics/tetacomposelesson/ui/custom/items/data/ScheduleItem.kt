package studio.eyesthetics.tetacomposelesson.ui.custom.items.data

import java.io.Serializable
import java.util.*

data class ScheduleItem(
    val time: Date,
    val action: String
) : Serializable