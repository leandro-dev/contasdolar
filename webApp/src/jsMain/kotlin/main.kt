import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        H1 {
            Text(value = "Hello JS world")
        }
    }
}
