package com.leandrodev.contasdolar

import com.leandrodev.contasdolar.android.auth.AuthViewModel
import org.junit.Test


class AuthViewModelTest {
    @Test
    fun `given initial state, when click on google login, invoke google login business`() {
        val viewModel: AuthViewModel = AuthViewModel()
        viewModel.onGoogleAuthClick()

        // TODO Verify ViewModel dependency
    }

    @Test
    fun `given initial state, when click on google login, should update to loading state`() {
        val viewModel = AuthViewModel()
        viewModel.onGoogleAuthClick()

        // TODO Verify observers on ViewModel
    }
}