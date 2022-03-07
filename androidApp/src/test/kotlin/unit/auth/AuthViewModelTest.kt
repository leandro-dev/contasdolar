package unit.auth

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.leandrodev.contasdolar.android.auth.AuthViewModel
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthViewModelTest {
    @Test
    fun `given initial state, when click on google login, invoke google login business`() {
        val viewModel = AuthViewModel(
            ApplicationProvider.getApplicationContext()
        )
        viewModel.onGoogleAuthClick()

        // TODO Verify ViewModel dependency
    }

    @Test
    fun `given initial state, when click on google login, should update to loading state`() {
        val viewModel = AuthViewModel(
            ApplicationProvider.getApplicationContext()
        )
        viewModel.onGoogleAuthClick()

        // TODO Verify observers on ViewModel
    }
}