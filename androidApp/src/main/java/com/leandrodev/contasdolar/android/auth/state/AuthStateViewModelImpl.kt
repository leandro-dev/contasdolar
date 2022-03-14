package com.leandrodev.contasdolar.android.auth.state

import androidx.lifecycle.viewModelScope
import com.leandrodev.contasdolar.android.model.User
import com.leandrodev.contasdolar.android.utils.MutableViewState
import com.leandrodev.contasdolar.android.utils.createViewAction
import com.leandrodev.contasdolar.android.utils.toUser
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AuthStateViewModelImpl : AuthStateViewModel() {
    override val state: MutableViewState<AuthState> = createViewAction()

    init {
        viewModelScope.launch { 
            Firebase.auth.authStateChanged.collectLatest {
                val user = Firebase.auth.currentUser?.toUser()
                state.emit(getStateFromUser(user))
            }
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