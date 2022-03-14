package com.leandrodev.contasdolar.android.auth.google

import androidx.compose.runtime.Composable
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

interface SignInProvider {
    @Composable
    fun rememberGoogleSignInLauncher(
        onSuccessListener: (GoogleSignInAccount) -> Unit,
        onErrorListener: (() -> Unit)?,
    ): GoogleSignInLauncher
}
