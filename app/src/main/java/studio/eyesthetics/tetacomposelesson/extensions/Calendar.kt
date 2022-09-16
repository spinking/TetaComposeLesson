package studio.eyesthetics.tetacomposelesson.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.clearHours(): Calendar {
    this.set(Calendar.HOUR_OF_DAY, 0)
    this.set(Calendar.MINUTE, 0)
    this.set(Calendar.SECOND, 0)
    this.set(Calendar.MILLISECOND, 0)
    return this
}

fun Calendar.formatToYearAndMonth(): String {
    val yearFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    val monthFormat = SimpleDateFormat("LLLL", Locale.getDefault())
    return "${yearFormat.format(this.time)}-${monthFormat.format(this.time)
        .replaceFirstChar { 
            if (it.isLowerCase()) 
                it.titlecase(Locale.getDefault())
            else 
                it.toString()
        }}"
}

fun Calendar.getDayOfWeek(): Int {
    val dayOfWeek = this.get(Calendar.DAY_OF_WEEK)
    return if (dayOfWeek == 1)
        7
    else
        dayOfWeek - 1
}
