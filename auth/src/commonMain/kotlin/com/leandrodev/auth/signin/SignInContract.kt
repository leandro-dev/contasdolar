package com.leandrodev.auth.signin

import com.leandrodev.auth.model.User
import com.leandrodev.shared.MppViewModel
import kotlinx.coroutines.flow.SharedFlow

interface ViewActions {
    class SignInWithGoogle : ViewActions
    object Authenticated : ViewActions
}

abstract class SignInViewModel : MppViewModel() {
    abstract val actions: SharedFlow<ViewActions>
    abstract fun onGoogleAuthClick()
    abstract fun onGoogleAuthSuccess(account: User)
    abstract fun onGoogleAuthError()
}
