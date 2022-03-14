package com.leandrodev.contasdolar.android.auth.google

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class SignInProviderImpl : SignInProvider {
    @Composable
    override fun rememberGoogleSignInLauncher(
        onSuccessListener: (GoogleSignInAccount) -> Unit,
        onErrorListener: (() -> Unit)?,
    ): GoogleSignInLauncher {
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    onSuccessListener(account)
                } catch (e: ApiException) {
                    onErrorListener?.invoke()
                }
            }
        )

        val context = LocalContext.current
        return object : GoogleSignInLauncher {
            override fun launchIntent() {
                val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build()

                val googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)
                launcher.launch(googleSignInClient.signInIntent)
            }
        }
    }
}
