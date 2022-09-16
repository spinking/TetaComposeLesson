package studio.eyesthetics.tetacomposelesson.ui.custom.calendar

import androidx.compose.runtime.snapshots.StateObject
import androidx.compose.runtime.snapshots.StateRecord
import androidx.compose.runtime.snapshots.readable
import androidx.compose.runtime.snapshots.writable
import androidx.compose.ui.graphics.Color
import java.io.Serializable
import java.util.*

class CalendarItem(
    val id: String,
    val dayOfMonth: Int,
    val date: Date,
    status: CalendarItemStatus,
    val color: Color
) : StateObject, Serializable {
    private var record = Record(status)
    override val firstStateRecord: StateRecord
        get() = record

    override fun prependStateRecord(value: StateRecord) {
        record = value as Record
    }

    var status: CalendarItemStatus
        get() = record.readable(this).status
        set(value) {
            record.writable(this) {
                status = value
            }
        }

    private class Record(
        var status: CalendarItemStatus = CalendarItemStatus.DEFAULT
    ) : StateRecord() {
        override fun create(): StateRecord = Record()

        override fun assign(value: StateRecord) {
            value as Record
            status = value.status
        }
    }
}

enum class CalendarItemStatus {
    DEFAULT,
    EMPTY,
    ACTIVE
}