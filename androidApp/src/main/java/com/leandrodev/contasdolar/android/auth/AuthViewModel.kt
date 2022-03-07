package com.leandrodev.contasdolar.android.auth

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.leandrodev.contasdolar.android.R


class AuthViewModel(
    private val context: Context
) : ViewModel() {
    fun onGoogleAuthClick() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

//        val googleSignInClient = GoogleSignIn.getClient(this, gso)
    }
}