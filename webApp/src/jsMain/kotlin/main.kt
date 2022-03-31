import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import androidx.compose.material.MaterialTheme

fun main() {
    renderComposable(rootElementId = "root") {
        MaterialTheme {
            H1 {
                Text(value = "Hello JS world")
            }
        }
    }
}
