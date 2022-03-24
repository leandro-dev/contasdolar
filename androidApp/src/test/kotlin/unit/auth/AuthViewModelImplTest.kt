package unit.auth

import com.leandrodev.contasdolar.android.auth.signin.AuthViewModelImpl
import org.junit.Test

class AuthViewModelImplTest {
    @Test
    fun `given initial state, when click on google login, invoke google login business`() {
        val viewModel = AuthViewModelImpl()
        viewModel.onGoogleAuthClick()

        // TODO Verify ViewModel dependency
    }

    @Test
    fun `given initial state, when click on google login, should update to loading state`() {
        val viewModel = AuthViewModelImpl()
        viewModel.onGoogleAuthClick()

        // TODO Verify observers on ViewModel
    }
}