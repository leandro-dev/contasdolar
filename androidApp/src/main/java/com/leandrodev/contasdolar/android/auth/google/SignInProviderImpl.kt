package com.leandrodev.contasdolar.android.auth.google

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.leandrodev.contasdolar.android.R
import com.leandrodev.contasdolar.android.model.User
import com.leandrodev.contasdolar.android.utils.toUser
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.GoogleAuthProvider
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch


class SignInProviderImpl : SignInProvider {
    @Composable
    override fun rememberGoogleSignInLauncher(
        onSuccessListener: (User) -> Unit,
        onErrorListener: (() -> Unit)?,
    ): GoogleSignInLauncher {
        val scope = rememberCoroutineScope()
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = {
                scope.launch {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    try {
                        val account = task.getResult(ApiException::class.java)
                        val idToken = account.idToken
                        if (idToken != null) {
                            firebaseAuthWithGoogle(
                                idToken,
                                onSuccessListener,
                                onErrorListener
                            )
                        } else {
                            onErrorListener?.invoke()
                        }
                    } catch (e: ApiException) {
                        onErrorListener?.invoke()
                    }
                }
            }
        )

        val context = LocalContext.current
        return object : GoogleSignInLauncher {
            override fun launchIntent() {
                val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(context.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)
                launcher.launch(googleSignInClient.signInIntent)
            }
        }
    }

    private suspend fun firebaseAuthWithGoogle(
        idToken: String,
        onSuccessListener: (User) -> Unit,
        onErrorListener: (() -> Unit)?,
    ) {
        val credential = GoogleAuthProvider.credential(idToken, null)
        val user = Firebase.auth.signInWithCredential(credential).user
        user?.let {
            onSuccessListener(user.toUser())
        } ?: run {
            onErrorListener?.invoke()
        }
    }
}
