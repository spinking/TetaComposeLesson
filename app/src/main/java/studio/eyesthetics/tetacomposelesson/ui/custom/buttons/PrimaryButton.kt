package studio.eyesthetics.tetacomposelesson.ui.custom.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import studio.eyesthetics.tetacomposelesson.R
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorGrayChateau
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorRedMonza
import studio.eyesthetics.tetacomposelesson.ui.theme.ColorWhite

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String = "",
    isEnabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorRedMonza,
            contentColor = ColorWhite,
            disabledBackgroundColor = ColorGrayChateau,
            disabledContentColor = ColorWhite
        ),
        enabled = isEnabled,
        modifier = CombinedModifier(modifier, Modifier.height(52.dp)),
        contentPadding = PaddingValues(all = 10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = buttonText.ifEmpty { stringResource(R.string.butotn_ok) },
            style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Medium)
        )
    }
}