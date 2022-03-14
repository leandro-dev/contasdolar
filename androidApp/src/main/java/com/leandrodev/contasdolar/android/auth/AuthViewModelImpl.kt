package com.leandrodev.contasdolar.android.auth

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class AuthViewModelImpl(
    private val context: Context
) : AuthViewModel() {
    override val actions = MutableSharedFlow<ViewActions>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override fun onGoogleAuthClick() {
        actions.tryEmit(ViewActions.SignInWithGoogle())
    }

    override fun onGoogleAuthSuccess(account: GoogleSignInAccount) {
        actions.tryEmit(ViewActions.Authenticated)
    }

    override fun onGoogleAuthError() {

    }
}