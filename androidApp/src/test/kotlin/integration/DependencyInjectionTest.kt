package integration

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.leandrodev.contasdolar.android.auth.authModule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import kotlin.test.AfterTest

@RunWith(AndroidJUnit4::class)
class DependencyInjectionTest : KoinTest {

    @Test
    fun `should have valid auth DI configuration`() {
        checkModules {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(authModule)
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }
}