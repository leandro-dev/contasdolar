package com.leandrodev.auth.state

import com.leandrodev.auth.model.User
import com.leandrodev.shared.MutableViewState
import com.leandrodev.shared.createViewAction
import com.leandrodev.shared.scope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class AuthStateViewModelJs : AuthStateViewModel() {
    override val state: MutableViewState<AuthState> = createViewAction()

    init {
        scope.launch {
            delay(500)
            state.emit(AuthState.Authenticated(User()))
            /*Firebase.auth.authStateChanged.collectLatest {
                val user = Firebase.auth.currentUser?.toUser()
                state.emit(getStateFromUser(user))
            }*/
        }
    }

    private fun getStateFromUser(user: User?): AuthState {
        return if (user != null) {
            AuthState.Authenticated(user)
        } else {
            AuthState.Unauthenticated
        }
    }
}