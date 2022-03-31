import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.kodein.di.*
import androidx.compose.material.MaterialTheme
import com.leandrodev.auth.di.authModule
import com.leandrodev.auth.state.AuthStateScreen
import com.leandrodev.auth.state.AuthStateViewModel
import com.leandrodev.bills.billsDiModule

class KodeinMppApplication(override val di: DI) : DIAware {
    val viewModel: AuthStateViewModel by instance()
}

fun main() {
    renderComposable(rootElementId = "root") {
        val app = KodeinMppApplication(
            DI {
                import(billsDiModule)
                import(authModule)
            }
        )
        MaterialTheme {
            AuthStateScreen(
                viewModel = app.viewModel
            ) {
                H1 {
                    Text(value = "Hello JS world")
                }
            }
        }
    }
}
