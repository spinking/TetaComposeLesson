package studio.eyesthetics.tetacomposelesson.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = ColorWhite,
    primaryVariant = ColorGrayAthens,
    secondary = ColorRedMonza,
    background = ColorWhite,
    surface = ColorWhite,
    onPrimary = ColorBlack,
    onSecondary = ColorBlack,
    onBackground = ColorBlack,
    onSurface = ColorBlack
)

private val LightColorPalette = lightColors(
    primary = ColorWhite,
    primaryVariant = ColorGrayAthens,
    secondary = ColorRedMonza,
    background = ColorWhite,
    surface = ColorWhite,
    onPrimary = ColorBlack,
    onSecondary = ColorBlack,
    onBackground = ColorBlack,
    onSurface = ColorBlack
)

@Composable
fun TetaComposeLessonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}