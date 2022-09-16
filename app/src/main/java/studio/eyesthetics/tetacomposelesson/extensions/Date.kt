package studio.eyesthetics.tetacomposelesson.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToString(): String {
    val simpleDateFormat =
        SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun Date.formatToTime(): String {
    val simpleDateFormat =
        SimpleDateFormat("HH:mm", Locale.getDefault())
    return simpleDateFormat.format(this)
}