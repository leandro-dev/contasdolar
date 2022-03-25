package com.leandrodev.contasdolar.android.auth.signin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leandrodev.contasdolar.android.GoogleSignInButton
import com.leandrodev.contasdolar.android.R
import com.leandrodev.contasdolar.android.auth.google.GoogleSignInLauncher
import com.leandrodev.contasdolar.android.auth.google.SignInProvider
import com.leandrodev.contasdolar.android.model.User
import com.leandrodev.shared.get
import com.leandrodev.shared.getViewModel
import com.leandrodev.ui.theme.HomeTheme

@Composable
internal fun AuthScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = getViewModel(),
    signInProvider: SignInProvider = get(),
) {
    val launcher = signInProvider.rememberGoogleSignInLauncher(
        onSuccessListener = viewModel::onGoogleAuthSuccess,
        onErrorListener = viewModel::onGoogleAuthError
    )
    val context = LocalContext.current
    LaunchedEffect(context) {
        viewModel.actions.collect {
            when (it) {
                is ViewActions.SignInWithGoogle -> {
                    launcher.launchIntent()
                }
                is ViewActions.Authenticated -> {
                    Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.money_bag),
                contentDescription = stringResource(id = R.string.ic_launcher_description),
            )
            Text(
                text = stringResource(id = R.string.auth_screen_title),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(top = 32.dp),
            )
            GoogleSignInButton(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 32.dp),
                onClick = viewModel::onGoogleAuthClick
            )
        }
    }
}

@Preview
@Composable
private fun previewAuthScreen() {
    HomeTheme {
        AuthScreen(
            viewModel = AuthViewModelImpl(),
            signInProvider = object : SignInProvider {
                @Composable
                override fun rememberGoogleSignInLauncher(
                    onSuccessListener: (User) -> Unit,
                    onErrorListener: (() -> Unit)?
                ): GoogleSignInLauncher {
                    return object : GoogleSignInLauncher {
                        override fun launchIntent() = Unit
                    }
                }
            }
        )
    }
}
