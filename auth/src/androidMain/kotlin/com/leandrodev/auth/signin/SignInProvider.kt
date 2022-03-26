package com.leandrodev.auth.signin

import androidx.compose.runtime.Composable
import com.leandrodev.auth.model.User

interface SignInProvider {
    @Composable
    fun rememberGoogleSignInLauncher(
        onSuccessListener: (User) -> Unit,
        onErrorListener: (() -> Unit)?,
    ): GoogleSignInLauncher
}
