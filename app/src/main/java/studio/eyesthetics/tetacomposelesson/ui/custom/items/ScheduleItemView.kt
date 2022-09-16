package studio.eyesthetics.tetacomposelesson.ui.custom.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import studio.eyesthetics.tetacomposelesson.R
import studio.eyesthetics.tetacomposelesson.extensions.formatToTime
import studio.eyesthetics.tetacomposelesson.ui.custom.items.data.ScheduleItem

@Composable
fun ScheduleItemView(
    item: ScheduleItem
) {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 28.dp)
    ) {
        val (ivMark, tvTime, tvAction) = createRefs()
        Image(
            modifier = Modifier.constrainAs(ivMark) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            painter = painterResource(id = R.drawable.ic_mark),
            contentDescription = "mark"
        )
        Text(
            text = item.time.formatToTime(),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.constrainAs(tvTime) {
                start.linkTo(ivMark.end, margin = 12.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(
            text = item.action,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.constrainAs(tvAction) {
                start.linkTo(tvTime.end, margin = 12.dp)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }
        )
    }
}