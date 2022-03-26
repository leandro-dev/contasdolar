package com.leandrodev.auth.state

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.leandrodev.auth.signin.AuthScreen
import com.leandrodev.shared.getViewModel

@Composable
fun AuthStateScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthStateViewModel = getViewModel(),
    authenticatedContent: @Composable (Modifier) -> Unit,
) {
    val state: AuthState by viewModel.state.collectAsState(initial = AuthState.Unknown)
    when (state) {
        is AuthState.Unknown -> {
            Text(modifier = modifier, text = "Loading...")
        }
        is AuthState.Authenticated -> {
            authenticatedContent(modifier)
        }
        is AuthState.Unauthenticated -> {
            AuthScreen(modifier)
        }
    }
}
