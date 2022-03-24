package com.leandrodev.contasdolar.android.auth.signin

import com.leandrodev.contasdolar.android.model.User
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class AuthViewModelImpl : AuthViewModel() {
    override val actions = MutableSharedFlow<ViewActions>(
        extraBufferCapacity = 100,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override fun onGoogleAuthClick() {
        actions.tryEmit(ViewActions.SignInWithGoogle())
    }

    override fun onGoogleAuthSuccess(account: User) {
        actions.tryEmit(ViewActions.Authenticated)
    }

    override fun onGoogleAuthError() {

    }
}