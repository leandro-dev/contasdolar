package com.leandrodev.contasdolar.android.auth.state

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.leandrodev.contasdolar.android.auth.signin.AuthScreen
import com.leandrodev.contasdolar.android.home.HomeNavHost
import org.koin.androidx.compose.getViewModel

@Composable
fun AuthStateScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthStateViewModel = getViewModel(),
) {
    val state: AuthState by viewModel.state.collectAsState(initial = AuthState.Unknown)
    when (state) {
        is AuthState.Unknown -> {
            Text(modifier = modifier, text = "Loading...")
        }
        is AuthState.Authenticated -> {
            HomeNavHost(modifier)
        }
        is AuthState.Unauthenticated -> {
            AuthScreen(modifier)
        }
    }
}