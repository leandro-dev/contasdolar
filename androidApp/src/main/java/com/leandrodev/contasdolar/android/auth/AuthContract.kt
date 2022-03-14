package com.leandrodev.contasdolar.android.auth

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.leandrodev.contasdolar.MppViewModel
import kotlinx.coroutines.flow.SharedFlow

interface ViewActions {
    class SignInWithGoogle : ViewActions
    object Authenticated : ViewActions
}

abstract class AuthViewModel : MppViewModel() {
    abstract val actions: SharedFlow<ViewActions>
    abstract fun onGoogleAuthClick()
    abstract fun onGoogleAuthSuccess(account: GoogleSignInAccount)
    abstract fun onGoogleAuthError()
}
