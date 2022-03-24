package com.leandrodev.contasdolar.android.auth.signin

import com.leandrodev.contasdolar.android.auth.google.SignInProvider
import com.leandrodev.contasdolar.android.auth.google.SignInProviderImpl
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton

val authModule = DI.Module("Auth") {
    bindProvider<AuthViewModel> { AuthViewModelImpl() }
    bindSingleton<SignInProvider> { SignInProviderImpl() }
}
