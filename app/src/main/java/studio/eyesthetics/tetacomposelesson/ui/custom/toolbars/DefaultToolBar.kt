package studio.eyesthetics.tetacomposelesson.ui.custom.toolbars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import studio.eyesthetics.tetacomposelesson.R

@Composable
fun DefaultToolBar(label: String, modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
    ConstraintLayout(modifier = CombinedModifier(modifier, Modifier
        .fillMaxWidth()
        .height(56.dp))
    ) {
        val (btnBack, tvTitle) = createRefs()
        IconButton(
            modifier = Modifier.constrainAs(btnBack) {
                start.linkTo(parent.start, 4.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            onClick = {
                onBackPressed.invoke()
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back",
                tint = MaterialTheme.colors.onBackground
            )
        }

        Text(
            text = label,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.constrainAs(tvTitle) {
                start.linkTo(btnBack.end, margin = 4.dp)
                end.linkTo(parent.end, margin = 24.dp)
                top.linkTo(btnBack.top)
                bottom.linkTo(btnBack.bottom)
                width = Dimension.fillToConstraints
            }
        )
    }
}