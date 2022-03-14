package com.leandrodev.contasdolar.android.auth.google

import androidx.compose.runtime.Composable
import com.leandrodev.contasdolar.android.model.User

interface SignInProvider {
    @Composable
    fun rememberGoogleSignInLauncher(
        onSuccessListener: (User) -> Unit,
        onErrorListener: (() -> Unit)?,
    ): GoogleSignInLauncher
}
