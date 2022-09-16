package studio.eyesthetics.tetacomposelesson.utils

import kotlin.random.Random

object Utils {
    private val actions = listOf(
        "Спать",
        "Есть",
        "Рыбачить",
        "Костылить",
        "Делать баги",
        "Фиксить баги",
        "Слушать громко музыку",
        "Перфорировать"
    )
    fun getRandomScheduleAction(): String {
        return actions[Random.nextInt(0, actions.size)]
    }
}