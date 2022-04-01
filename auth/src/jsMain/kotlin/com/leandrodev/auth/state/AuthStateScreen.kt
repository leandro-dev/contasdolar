package com.leandrodev.auth.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.web.dom.*

@Composable
fun AuthStateScreen(
    viewModel: AuthStateViewModel,
    authenticatedContent: @Composable () -> Unit,
) {
    val state: AuthState by viewModel.state.collectAsState(initial = AuthState.Unknown)
    when (state) {
        is AuthState.Unknown -> {
            Text(value = "Loading...")
        }
        is AuthState.Authenticated -> {
            authenticatedContent()
        }
        is AuthState.Unauthenticated -> {
            Text(value = "Unauthenticated...")
        }
    }
}
