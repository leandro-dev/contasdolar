package unit.auth

import com.leandrodev.auth.signin.SignInViewModelImpl
import org.junit.Test

class AuthViewModelImplTest {
    @Test
    fun `given initial state, when click on google login, invoke google login business`() {
        val viewModel = SignInViewModelImpl()
        viewModel.onGoogleAuthClick()

        // TODO Verify ViewModel dependency
    }

    @Test
    fun `given initial state, when click on google login, should update to loading state`() {
        val viewModel = SignInViewModelImpl()
        viewModel.onGoogleAuthClick()

        // TODO Verify observers on ViewModel
    }
}