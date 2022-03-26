package com.leandrodev.contasdolar.android.auth.signin

import com.leandrodev.shared.MppViewModel
import com.leandrodev.contasdolar.android.model.User
import kotlinx.coroutines.flow.SharedFlow

interface ViewActions {
    class SignInWithGoogle : ViewActions
    object Authenticated : ViewActions
}

abstract class AuthViewModel : MppViewModel() {
    abstract val actions: SharedFlow<ViewActions>
    abstract fun onGoogleAuthClick()
    abstract fun onGoogleAuthSuccess(account: User)
    abstract fun onGoogleAuthError()
}
