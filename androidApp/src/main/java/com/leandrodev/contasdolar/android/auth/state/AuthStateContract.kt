package com.leandrodev.contasdolar.android.auth.state

import com.leandrodev.contasdolar.MppViewModel
import com.leandrodev.contasdolar.android.model.User
import com.leandrodev.shared.ViewState

sealed interface AuthState {
    object Unknown : AuthState
    class Authenticated(val user: User) : AuthState
    object Unauthenticated : AuthState
}

abstract class AuthStateViewModel : MppViewModel() {
    abstract val state: ViewState<AuthState>
}