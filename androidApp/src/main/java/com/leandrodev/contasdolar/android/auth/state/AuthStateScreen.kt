package com.leandrodev.contasdolar.android.auth.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.leandrodev.contasdolar.android.auth.signin.AuthScreen
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun AuthStateScreen(
    viewModel: AuthStateViewModel = getViewModel()
) {
    val state: AuthState by viewModel.state.collectAsState(initial = AuthState.Unknown)
    val scope = rememberCoroutineScope()
    when (state) {
        is AuthState.Unknown -> {
            Text(text = "Loading...")
        }
        is AuthState.Authenticated -> {
            Column {
                Text(text = "Authenticated...")
                Button(onClick = {
                    scope.launch {
                        Firebase.auth.signOut()
                    }
                }) {
                    Text(text = "Sign out")
                }
            }
        }
        is AuthState.Unauthenticated -> {
            AuthScreen()
        }
    }
}