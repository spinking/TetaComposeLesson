package studio.eyesthetics.tetacomposelesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import studio.eyesthetics.tetacomposelesson.ui.Screen
import studio.eyesthetics.tetacomposelesson.ui.theme.TetaComposeLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TetaComposeLessonTheme {
                val currentScreen = remember { mutableStateOf(Screen.Calendar) }
                when(currentScreen.value) {
                    Screen.Calendar ->
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TetaComposeLessonTheme {
        Greeting("Android")
    }
}